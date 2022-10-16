
/*
 * Max in Queue
 * easy
 * Time Limit: 2 sec
 * Memory Limit: 128000 kB
 * Problem Statement
 * You have been given a sequence A of N digits. Each digit in this sequence
 * ranges from 1 to 10^9. You need to perform 2 types of operations on this
 * list:
 * 
 * Add(x): Add element x to the end of the list.
 * Max(list): Find the maximum element in the current sequence.
 * For each query of type 2, you need to print the result of that operation.
 * Input
 * The first line consists of a single integer N denoting the size of the
 * initial sequence. The next line consists of N space-separated integers
 * denoting the elements of the initial sequence. The next line contains a
 * single integer q denoting the number of queries. The next q lines contain the
 * details of the operation. The first integer type indicates the type of query.
 * If typei ==1, it is followed by another integer x and you need to perform an
 * operation of type 1 else operations of type 2
 * 
 * Constraints
 * 1 < = N < = 10^5
 * 1 < = Ai < = 10^9
 * 1 < = q < = 10^4
 * Output
 * For each operation of the second type, print a single integer on a new line.
 */
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    static int x;

    public static void main(String[] args) {
        // Your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int q = sc.nextInt();
        while (q-- > 0) {
            int op = sc.nextInt();
            if (op == 1) {
                x = sc.nextInt();
            }
            maxQueueFind(arr, op, x);
        }
    }

    public static void maxQueueFind(int arr[], int op, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        if (op == 1) {
            pq.add(x);
        } else
            System.out.println(pq.peek());

    }
}