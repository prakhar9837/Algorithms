import java.util.Scanner;

public class knapsack {
    static int v[][] = new int[20][20];

    public static int max1(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub int p[] = new int[20];
        int w[] = new int[20];
        int p[] = new int[20];
        int i, j, n, max;
        Scanner in = new Scanner(System.in);
        System.out.println("enter the number of items");
        n = in.nextInt();
        for (i = 1; i <= n; i++) {
            System.out.println(" enter the weight and profit of the item");
            w[i] = in.nextInt();
            p[i] = in.nextInt();
        }
        System.out.println("\n enter the capacity of the knapsack");
        max = in.nextInt();
        for (i = 0; i <= n; i++)
            v[i][0] = 0;
        for (j = 0; j <= max; j++)
            v[0][j] = 0;
        for (i = 1; i <= n; i++)
            for (j = 1; j <= max; j++) {
                if (w[i] > j)
                    v[i][j] = v[i - 1][j];
                else
                    v[i][j] = max1(v[i - 1][j], v[i - 1][j - w[i]] + p[i]);
            }
        /*
         * System.out.println ("The table is"); for(i=0;i<=n;i++) { for(j=0;j<=max;j++)
         * System.out.println ("\t"+v[i][j]); }
         */
        System.out.println("The maximum profit is " + v[n][max]);
        System.out.println("\nThe items selected are:");
        j = max;
        for (i = n; i >= 1; i--)
            if (v[i][j] != v[i - 1][j]) {
                System.out.println("\t item:" + i);
                j = j - w[i];
            }
    }
}