
/*
 * Virus Affinity
 * easy
 * Time Limit: 1 sec
 * Memory Limit: 128000 kB
 * Problem Statement
 * There are N types of virus also each virus has an affinity equal to A[i]. You
 * want to find the top 10 virus with the highest affinity.
 * 
 * Expected Time Complexity: O(N)
 * Input
 * First line contains an integer N.
 * Next line contains N space separated integers denoting elements of array.
 * 
 * Constraints
 * 10 <= N <= 10^7
 * 1 <= Ai <= 10^5
 * Output
 * Print the affinity of top 10 virus in sorted order.
 * Example
 * Sample Input 1:
 * 10
 * 1 2 3 4 5 6 7 8 9 10
 * 
 * Output
 * 1 2 3 4 5 6 7 8 9 10
 * 
 * Sample Input 2:
 * 15
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
 * 
 * Output
 * 6 7 8 9 10 11 12 13 14 15
 */
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    public static void main(String[] args) {
        // Your code here
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }
        for (int i = 0; i < n - 10; i++) {
            pq.remove();
        }
        while (!pq.isEmpty()) {
            System.out.print(pq.remove() + " ");
        }
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {

                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}