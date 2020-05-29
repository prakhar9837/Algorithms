import java.util.*;

class quicksort {
    final static int max = 10000000;
    static int a[] = new int[max];
    static int n;

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of Array : ");
        n = input.nextInt();
        System.out.println("Enter the Objects : ");
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            // a[i] = input.nextInt();
            a[i] = r.nextInt(10) + 1;
        }
        // quickSortAlgo(0, n - 1);
        long StartTime = System.nanoTime();
        quickSortAlgo(0, n - 1);
        long EndTime = System.nanoTime();
        long ElapsedTime = EndTime - StartTime;
        System.out.println("Sorted Array");
        // for(int i=0; i<n; i++)
        // System.out.println(a[i]);
        System.out.println("Time Complexity : " + ((double) (ElapsedTime) / 1000000));
        input.close();
    }

    static void quickSortAlgo(int low, int high) {
        // int i,j,pivot,temp;
        if (low < high) {
            int i = low, j = high + 1, pivot = a[low], temp = 0;
            // i=low;
            // j=high+1;
            // pivot = a[low];
            while (true) {
                i++;
                while (a[i] < pivot && i < high)
                    i++;
                j--;
                while (a[j] > pivot && j > 0)
                    j--;
                if (i < j) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                } else
                    break;
            }
            // System.out.println("piv"+pivot);
            a[low] = a[j];
            a[j] = pivot;
            quickSortAlgo(low, j - 1);
            quickSortAlgo(j + 1, high);
        }
    }
}