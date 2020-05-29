import java.lang.*;
import java.util.Scanner;
import java.util.Random;

class mergesort {
    static final int max = 10000000;
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
            a[i] = r.nextInt(100) + 1;
        }
        // mergeSortAlgo(0, n - 1);
        long StartTime = System.nanoTime();
        mergeSortAlgo(0, n - 1);
        long EndTime = System.nanoTime();
        long ElapsedTime = EndTime - StartTime;
        System.out.println("Sorted Array");
        // for(int i=0; i<n; i++)
        // System.out.println(a[i]);
        System.out.println("Time Complexity : " + ElapsedTime / 1000000);
        input.close();
    }

    static void mergeSortAlgo(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSortAlgo(low, mid);
            mergeSortAlgo(mid + 1, high);
            merge(low, mid, high);
        }
    }

    static void merge(int low, int mid, int high) {
        int b[] = new int[max];
        int h = low, i = low, j = mid + 1, k = 0;
        while (h <= mid && j <= high) {
            if (a[h] > a[j])
                b[i++] = a[j++];
            else
                b[i++] = a[h++];
            // System.out.println(a[h-1]+"vly");
        }
        if (h > mid) {
            for (k = j; k <= high; k++)
                b[i++] = a[j++];
        } else {
            for (k = h; k <= mid; k++)
                b[i++] = a[h++];
        }
        for (k = low; k <= high; k++) {
            a[k] = b[k];
        }
    }

}