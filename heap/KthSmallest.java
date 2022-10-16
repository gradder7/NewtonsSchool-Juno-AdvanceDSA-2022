
/*
 * Kth smallest element
 * easy
 * Time Limit: 2 sec
 * Memory Limit: 128000 kB
 * Problem Statement
 * Given an array arr[] and a number K where K is not greater than the size of
 * array, the task is to find the Kth smallest element in the given array. It is
 * given that all array elements are distinct.
 * 
 * Note: Do Not Use sort() STL function, Use heap data structure.
 * Input
 * The input line contains T, denoting the number of testcases. Each test case
 * consists of two lines. The first line of each test case contains two integers
 * N and K. Second-line contains N space-separated integer denoting elements of
 * the array.
 * 
 * Constraints:
 * 1 <= T <= 50
 * 1 <= N <= 10000
 * 1 <= K <= N
 * 1 <= arr[i] <= 1000000
 * Output
 * Corresponding to each test case, print the kth smallest element in a new
 * line.
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
            int latgestK = findKthLargest(arr, n, k);
            System.out.println(latgestK);
        }
    }

    // Time Complexity: Sorting the array + Picking Kth element from the start =
    // O(nlogn) + O(1) = O(nlogn)
    // public static int findKthLargest(int arr[],int n,int k){
    // Arrays.sort(arr);
    // return arr[k-1];
    // }

    // public static int findKthLargest(int arr[],int n,int k){
    // PriorityQueue<Integer> pq = new PriorityQueue<>();
    // for(int i=0;i<n;i++){
    // pq.add(arr[i]);
    // }
    // //0 1 2 3 4 5 6
    // //3 4 7 10 15 20 k=3
    // //i k(if k=3 we do k-1) due to indexing from 0
    // for(int i=0;i<k-1;i++){
    // pq.remove();
    // }
    // return pq.peek();
    // }

    // Time Complexity: Building max-heap of k elements + Inserting n-K elements to
    // the heap =
    // O(K) + O((n-K)logK) = O(K + (n-K)logK)
    public static int findKthLargest(int arr[], int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i < n; i++) {
            if (pq.peek() > arr[i]) {
                pq.remove();
                pq.add(arr[i]);
            }
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