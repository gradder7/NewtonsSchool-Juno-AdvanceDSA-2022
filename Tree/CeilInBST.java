/*
 * Ceil in BST
 * easy
 * Time Limit: 2 sec
 * Memory Limit: 128000 kB
 * Problem Statement
 * Given a BST and a number X, find Ceil of X.
 * Input
 * First line contains a single integer N.
 * second line contains N space- separated integer A[i].
 * Next line contains a single integer X.
 * Output
 * Print a single integer ceil of given number X.
 * 
 * Constraints:
 * 1<=N<=100000
 * 1<=X, A[i]<=1000000
 * Example
 * Sample Input 1:
 * 5
 * 4 5 8 9 13
 * 7
 * Sample Output 1:
 * 8
 * 
 * Explanation:
 * ceil of given number x is 8.
 */
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    public static void main(String[] args) {
        // Your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        double k = sc.nextInt();
        findCeil(arr, n, k);
    }

    public static void findCeil(int arr[], int n, double k) {
        double y = Math.ceil(k);
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= y) {
                res = arr[i];
                System.out.println(res);
                return;
            }
        }
        System.out.println(res);
    }
}