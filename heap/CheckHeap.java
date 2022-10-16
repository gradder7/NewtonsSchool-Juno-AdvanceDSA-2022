/*
 * Check Heap
 * easy
 * Time Limit: 2 sec
 * Memory Limit: 128000 kB
 * Problem Statement
 * Given an integer array of size N. Check whether the array represents a max-
 * heap. The max heap is in form of an array where ith node has its left child
 * at index 2*i+1 and right child at index 2*i +2 ( 0- based indexing).
 * Input
 * First line contains an integer N - the size of array
 * Next line contains N space separated integers denoting elements of array.
 * 
 * Constraints
 * 1 <= N <= 10^5
 * 1 <= Ai<= 10^5
 * Output
 * Print "YES" if the array represents a max- heap otherwise print "NO".
 * Example
 * Sample Input 1:
 * 6
 * 90 15 10 7 12 2
 * 
 * Output
 * YES
 * 
 * Explanation:
 * 90
 * / \
 * 15 10
 * / \ /
 * 7 12 2
 * It is a max- heap as every node is greater than all of its descendants.
 * 
 * Sample Input 2:
 * 6
 * 9 15 10 7 12 11
 * 
 * Output
 * NO
 * 
 * Explanation
 * 9
 * / \
 * 15 10
 * / \ /
 * 7 12 11
 * It is not a max- heap as 9 is less than its descendants (15, 10, 12, 11).
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
        if (checkMaxHeapIterative(arr, n)) {
            System.out.println("YES");
        } else
            System.out.println("NO");
    }

    public static boolean checkMaxHeap(int arr[], int i, int n) {
        // leaf Node starting index formula->
        // external node
        if (i >= (n - 1) / 2) { //
            return true;
        }

        if (arr[i] >= arr[2 * i + 1] && arr[i] >= arr[2 * i + 2] && checkMaxHeap(arr, 2 * i + 1, n)
                && checkMaxHeap(arr, 2 * i + 2, n)) {
            return true;
        }
        return false;
    }

    public static boolean checkMaxHeapIterative(int arr[], int n) {
        if (n <= 1) {
            return true;
        }
        // internal node
        for (int i = (n - 2) / 2; i >= 0; i--) {
            if (arr[2 * i + 1] > arr[i]) {
                return false;
            }

            if (2 * i + 2 < n && arr[2 * i + 2] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}