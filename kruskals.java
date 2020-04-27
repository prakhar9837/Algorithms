import java.util.*;

class kruskals {
    static final int max = 10;
    static int cost[][] = new int[max][max];
    static int n;
    static int parent[] = new int[max];

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter total no. of vertices : ");
        n = input.nextInt();
        System.out.println("Enter the cost Adjacency Matrix : ");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                cost[i][j] = input.nextInt();
                if (cost[i][j] == 0)
                    cost[i][j] = 999;
            }
        }
        kruskalalgo();
        input.close();
    }

    static void kruskalalgo() {
        int mincost = 0, u = 0, v = 0, a = 0, b = 0, ne = 1, min = 999;
        while (ne < n) {
            min = 999;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (min > cost[i][j]) {
                        min = cost[i][j];
                        a = u = i;
                        b = v = j;
                    }
                }
            }
            u = find(u);
            v = find(v);
            if (u != v) {
                uni(u, v);
                mincost += cost[u][v];
                System.out.println(ne++ + "edge(" + a + "," + b + ")" + "=" + cost[u][v]);
            }
            cost[b][a] = 999;
            cost[a][b] = 999;
        }
        System.out.println("Minimum cost : " + mincost);
    }

    static int find(int i) {
        while (parent[i] > 0)
            i = parent[i];
        return i;
    }

    static void uni(int i, int j) {
        parent[j] = i;
    }
}