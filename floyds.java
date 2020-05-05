import java.util.Scanner;

class floyds {
    static final int max = 20;
    static int arr[][] = new int[max][max];
    static int n;

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter total no. of vertices:");
        n = input.nextInt();
        System.out.println("Enter Cost Adjacency Matrix:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                arr[i][j] = input.nextInt();
        }
        floy();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        input.close();
    }

    static void floy() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][j] > arr[k][j] + arr[i][k])
                        arr[i][j] = arr[k][j] + arr[i][k];
                }
            }
        }
    }
}
