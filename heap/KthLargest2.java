
/*
 * Kth largest element
 * easy
 * Time Limit: 2 sec
 * Memory Limit: 128000 kB
 * Problem Statement
 * Given an array arr[] of N positive integers and a number K. The task is to
 * find the kth largest element in the array.
 * 
 * Note: DO NOT USE sort() stl.
 * Input
 * First line of input contains number of testcases. For each testcase, there
 * will be a single line of input containing number of elements in the array and
 * K. Next line contains N elements.
 * 
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 10^4
 * 1 <= arr[i] <= 10^5
 * 1 <= K <= N
 * Output
 * For each testcase, print a single line of output containing the kth largest
 * element in the array.
 * Example
 * Sample Input:
 * 2
 * 5 3
 * 3 5 4 2 9
 * 5 5
 * 4 3 7 6 5
 * 
 * Sample Output:
 * 4
 * 3
 * 
 * Explanation:
 * Testcase 1: Third largest element in the array is 4.
 * Testcase 2: Fifth largest element in the array is 3.
 */
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    public static void main(String[] args) {
        // Your code here
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int latgestK = kthLargestMaxHeap(arr, n, k);
            System.out.println(latgestK);
        }
    }

    public static int kthLargest(int arr[], int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 3 5 4 2 9
        // 4 5 9
        //
        // 1st way
        // for(int i=0;i<k;i++){
        // pq.add(arr[i]);
        // }

        // for(int i=k;i<n;i++){
        // if(pq.peek()<arr[i]){
        // pq.remove();
        // pq.add(arr[i]);
        // }
        // }

        // 2nd way
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.peek();
    }

    public static int kthLargestMaxHeap(int arr[], int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }
        // 4 3 7 6 5
        // 7 6 5 4 3 k=5
        // 0 1 2 3 4
        // length =k-1=>4
        //
        int length = k - 1;
        while (length-- > 0) {
            pq.remove();
        }
        return pq.peek();
    }

    // fast reader
    static class FastReader {

        BufferedReader br;

        StringTokenizer st;

        public FastReader()

        {

            br = new BufferedReader(

                    new InputStreamReader(System.in));

        }

        String next()

        {

            while (st == null || !st.hasMoreElements()) {

                try {

                    st = new StringTokenizer(br.readLine());

                }

                catch (IOException e) {

                    e.printStackTrace();

                }

            }

            return st.nextToken();

        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble()

        {

            return Double.parseDouble(next());

        }

        String nextLine()

        {

            String str = "";

            try {

                if (st.hasMoreTokens()) {

                    str = st.nextToken("\n");

                }

                else {

                    str = br.readLine();

                }

            }

            catch (IOException e) {

                e.printStackTrace();

            }

            return str;

        }

    }
}