import java.lang.*;
import java.util.*;

class dijik {
    final static int MAX = 20, infinity = 9999;
    static int n; //size
    static int a[][]; //cost adjacency matrix
    static Scanner scan = new Scanner(System.in);  //initialization of object of scanner class

    public static void main(String args[]) {
        ReadMatrix(); //read the cost adjacency matrix
        int s = 0; //starting vertex
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
        int S[] = new int[MAX]; //this will check whether that node is visited or not
        int d[] = new int[MAX]; //distance array having the final distance with all the vertices
        int u, v;
        int i;
        for (i = 1; i <= n; i++) {
            S[i] = 0;
            d[i] = a[s][i];
        }
        S[s] = 1; //s is the starting vertex
        d[s] = 1; 
        i = 2; //loop starts from 2 because 1 vertex is already visited
        while (i <= n) { 
            u = Exact_Min(S, d); //find the minimum neighbouring distance
            // System.out.println(u);
            S[u] = 1;
            i++;
            for (v = 1; v <= n; v++) {
                if ((d[u] + a[u][v] < d[v]) && (S[v] == 0)) //comparison if become successful then change the distance array
                    d[v] = d[u] + a[u][v];
            }
        }
        for (i = 1; i <= n; i++)   //finally print the minimum distances from the starting vertex
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
        return j; //this will return the minimum distance
    }
}
