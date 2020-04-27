import java.lang.*;
import java.util.*;

class dijik {
    final static int MAX = 20, infinity = 9999;
    static int n;
    static int a[][];
    static Scanner scan = new Scanner(System.in);

    public static void main(String args[]) {
        ReadMatrix();
        int s = 0;
        System.out.println("Enter Starting Matrix:");
        s = scan.nextInt();
        Dij(s);
    }

    static void ReadMatrix() {
        a = new int[MAX][MAX];
        System.out.println("Enter the number of Vertices: ");
        n = scan.nextInt();
        System.out.println("Enter Cost Adjacency Matrix :\n");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                a[i][j] = scan.nextInt();
        }
    }

    static void Dij(int s) {
        int S[] = new int[MAX];
        int d[] = new int[MAX];
        int u, v;
        int i;
        for (i = 1; i <= n; i++) {
            S[i] = 0;
            d[i] = a[s][i];
        }
        S[s] = 1;
        d[s] = 1;
        i = 2;
        while (i <= n) {
            u = Exact_Min(S, d);
            // System.out.println(u);
            S[u] = 1;
            i++;
            for (v = 1; v <= n; v++) {
                if ((d[u] + a[u][v] < d[v]) && (S[v] == 0))
                    d[v] = d[u] + a[u][v];
            }
        }
        for (i = 1; i <= n; i++)
            if (i != s)
                System.out.println(i + ":" + d[i]);
    }

    static int Exact_Min(int S[], int d[]) {
        int i, j = 1, min;
        min = infinity;
        for (i = 1; i <= n; i++) {
            if ((d[i] < min) && (S[i] == 0)) {
                min = d[i];
                j = i;
            }
        }
        return j;
    }
}