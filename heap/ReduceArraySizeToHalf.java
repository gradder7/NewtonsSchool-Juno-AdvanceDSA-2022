
/*
 * Reduce Array Size to The Half
 * easy
 * Time Limit: 2 sec
 * Memory Limit: 128000 kB
 * Problem Statement
 * Given an integer array A of size N. You can choose a set of integers and
 * remove all the occurrences of these integers in the array. Find the minimum
 * size of the set so that at least half of the integers of the array are
 * removed.
 * Input
 * First line contains an integer N.
 * Next line contains N space separated integers denoting elements of array.
 * 
 * Constraints
 * 1 <= N <= 10^5
 * N is even.
 * 1 <= Ai<= 10^5
 * Output
 * Print a single integer - the minimum size of the set.
 * Example
 * Sample Input 1:
 * 4
 * 7 7 7 7
 * 
 * Output
 * 1
 * 
 * Explanation:
 * The only possible set you can choose is {7}. This will make the new array
 * empty.
 * 
 * Sample Input 2:
 * 8
 * 3 3 3 5 5 2 2 7
 * 
 * Output
 * 2
 * 
 * Explanation
 * Choosing {3, 7} will make the new array [5, 5, 5, 2, 2] which has size 5 (i.
 * e equal to half of the size of the old array).
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
        System.out.println(minSizeSet(arr, n));
    }

    public static int minSizeSet(int arr[], int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for (Integer b : map.values()) {
            pq.add(b);
        }
        int res = 0;
        int count = 0;
        while (res < n / 2 && !pq.isEmpty()) {
            res += pq.remove();
            count++;
        }
        return count;
    }
}