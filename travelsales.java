import java.util.Scanner;

class travelsales {
    static final int max = 1000;
    static int c[][] = new int[max][max];
    static int n;

    // static int mincost=999;
    public static void main(String args[]) {
        int tour[] = new int[max];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of Cities : ");
        n = input.nextInt();
        System.out.println("Enter the cost adjacecy matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                c[i][j] = input.nextInt();
        }
        for (int i = 0; i < n; i++)
            tour[i] = i;
        int min = tspdp(0, tour);
        System.out.println("Minimum cost : " + min);
        System.out.println("Tour is :");
        for (int i = 0; i < n; i++)
            System.out.print(tour[i] + " ");
        System.out.println();
        input.close();
    }

    static int tspdp(int start, int tour[]) {
        int temp[] = new int[max];
        int mintour[] = new int[max];
        int cost, mincost = 999;
        if (start == n - 2)
            return (c[tour[n - 2]][tour[n - 1]] + c[tour[n - 1]][0]);
        for (int i = start + 1; i < n; i++) {
            for (int j = 0; j < n; j++)
                temp[j] = tour[j];
            temp[start + 1] = tour[i];
            temp[i] = tour[start + 1];
            if ((cost = tspdp(start + 1, temp)) + c[tour[start]][tour[i]] < mincost) {
                mincost = cost + c[tour[start]][tour[i]];
                for (int k = 0; k < n; k++)
                    mintour[k] = temp[k];
            }
        }
        for (int k = 0; k < n; k++)
            tour[k] = mintour[k];
        return mincost;
    }
}