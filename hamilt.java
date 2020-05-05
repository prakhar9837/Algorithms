import java.util.Scanner;

class hamilt {
    static boolean found = false;
    static int G[][];
    static int x[];
    static int n;

    public static void main(String args[]) {
        getdata();
        System.out.println("Solutions");
        hamiltonian(2);
        printsolnpossible();
    }

    static void printsolnpossible() {
        if (found == false)
            System.out.println("No Solution poosiable !!");
    }

    static void getdata() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter no. of vertices");
        n = input.nextInt();
        G = new int[n + 1][n + 1];
        x = new int[n + 1];
        System.out.println("If edge between the follwing vertices enter 1 or 0");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i < j) {
                    System.out.print("edge between " + i + " and " + j + ":");
                    G[i][j] = G[j][i] = input.nextInt();
                }
                if (i == j)
                    G[i][j] = 0;
            }
        }
        for (int i = 1; i <= n; i++)
            x[i] = 0;
        x[1] = 1;
        input.close();
    }

    static void hamiltonian(int k) {
        while (true) {
            nextvalue(k);
            if (x[k] == 0)
                return;
            if (k == n) {
                for (int i = 1; i <= n; i++)
                    System.out.print(x[i] + " ");
                System.out.println(x[1]);
                System.out.println();
                found = true;
                return;
            } else
                hamiltonian(k + 1);
        }
    }

    static void nextvalue(int k) {
        while (true) {
            x[k] = (x[k] + 1) % (n + 1);
            if (x[k] == 0)
                return;
            if (G[x[k - 1]][x[k]] != 0) {
                int j;
                for (j = 1; j < k; j++)
                    if (x[k] == x[j])
                        break;
                if (j == k) {
                    if ((k < n) || ((k == n) && G[x[n]][x[1]] != 0))
                        return;
                }
            }
        }
    }
}