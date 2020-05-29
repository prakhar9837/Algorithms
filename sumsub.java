import java.lang.*;
import java.util.Scanner;

class sumsub {
    static final int max = 100;
    static int arr[] = new int[max]; //array containing the values
    static int soln[] = new int[max]; //this array will contain the solution
    static int n, d; //n is the total number of objects and d is the subset value 
    static int flag = 0; //used to check whether atleast one set of subsets found or not

    public static void main(String args[]) {
        int sum = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the total number of objects:");
        n = input.nextInt();
        System.out.println("Enter Set Values in ascending order : ");
        for (int i = 1; i <= n; i++)
            arr[i] = input.nextInt();
        System.out.println("Enter sum of subset value:");
        d = input.nextInt();
        for (int i = 1; i <= n; i++) {
            sum += arr[i];
        }
        System.out.println("Subsets");
        if (sum < d || d < arr[1])
            System.out.println("No Subsets Possible");
        else {
            SumofSubsets(0, 0, sum); //call the function with the required values
            if (flag == 0) 
                System.out.println("No Subsets Possible");
        }
        input.close();
    }

    static void SumofSubsets(int i, int weight, int total) { 
        if (promising(i, weight, total) == true) {
            if (weight == d) { // termination condition
                flag = 1;
                for (int k = 1; k <= n; k++) {
                    if (soln[k] == 1)
                        System.out.print(arr[k] + " ");
                }
                System.out.println();
            } else {
                soln[i + 1] = 1;
                SumofSubsets(i + 1, weight + arr[i + 1], total - arr[i + 1]); //recursive calling of the function
                soln[i + 1] = 0;
                SumofSubsets(i + 1, weight, total - arr[i + 1]);
            }
        }
    }

    static boolean promising(int i, int weight, int total) { //this will return either true or false
        return (((total + weight) >= d) && ((weight == d) || (weight + arr[i + 1]) <= d));
    }
}
