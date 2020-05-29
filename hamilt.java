import java.util.Scanner;
/*
Hamiltonian cycles (basically three things needs to be done while writting the logic of this program

It should not take duplicates
There should be an edge to the vertex we need to check with
There should be an edge from the last vertex .
*/
class hamilt {
    static boolean found = false;
    static int G[][]; //matrix that will either contain 1 or 0 that will check whether their is an edge between the vertices or not. 
    static int x[]; //this array will contain the hamiltonian cycles
    static int n; //total number of vertices

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

    static void getdata() { //take the input of the required details
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
            x[i] = 0;  //initially puts all the elements to 0, because as of now we didn't got any path
        x[1] = 1;
        input.close();
    }

    static void hamiltonian(int k) {
        while (true) {
            nextvalue(k); //this function will return the next required value that will satisfy the above conditions of the program. 
            if (x[k] == 0) 
                return;
            if (k == n) {
                for (int i = 1; i <= n; i++) //will print the hamiltonian cycle
                    System.out.print(x[i] + " ");
                System.out.println(x[1]);
                System.out.println();
                found = true;
                return;
            } else
                hamiltonian(k + 1); //recursive calling with the next vertex
        }
    }

    static void nextvalue(int k) {
        while (true) {
            x[k] = (x[k] + 1) % (n + 1); 
            if (x[k] == 0) //if their is no path then return
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
