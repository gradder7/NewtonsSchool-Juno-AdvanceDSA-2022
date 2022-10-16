/*
 * Minimum Cost of ropes
 * easy
 * Time Limit: 2 sec
 * Memory Limit: 128000 kB
 * Problem Statement
 * You are given N ropes of L[i] lengths, you need to connect these ropes into
 * one rope. The cost to connect two ropes is equal to sum of their lengths. The
 * task is to connect the ropes with minimum cost.
 * Input
 * The first line of input contains an integer T denoting the number of test
 * cases. The first line of each test case is N where N is the number of ropes.
 * The second line of each test case contains N input L[i],length of ropes.
 * 
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 <= N <= 10^5
 * 1 <= L[i] <= 10^5
 * Sum of N over all test cases does not exceed 5*10^5.
 * Output
 * For each testcase, print the minimum cost to connect all the ropes.
 * Example
 * Sample Input:
 * 2
 * 4
 * 4 3 2 6
 * 5
 * 4 2 7 6 9
 * 
 * Sample Output:
 * 29
 * 62
 * 
 * Explanation:
 * For example if we are given 4 ropes of lengths 4, 3, 2 and 6. We can connect
 * the ropes in following ways.
 * 1) First connect ropes of lengths 2 and 3. Now we have three ropes of lengths
 * 4, 6 and 5.
 * 2) Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6
 * and 9.
 * 3) Finally connect the two ropes and all ropes have connected.
 * 
 * Total cost for connecting all ropes is 5 + 9 + 15 = 29. This is the optimized
 * cost for connecting ropes. Other ways of connecting ropes would always have
 * same or more cost. For example, if we connect 4 and 6 first (we get three
 * strings of 3, 2 and 10), then connect 10 and 3 (we get two strings of 13 and
 * 2). Finally we connect 13 and 2. Total cost in this way is 10 + 13 + 15 = 38
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
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(minCostOfRopes(arr, n));
        }

    }

    // 4 3 2 6
    // 2 3 4 6 -> 2+3=>5 add 5 in Priority
    // 4 5 6 => 4+5=>9 add 9 in PriorityQueue
    // 6 9 => 15 add 15

    public static long minCostOfRopes(int arr[], int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer x : arr) {
            pq.add(x);
        }
        int ropeCost1 = 0;
        int ropeCost2 = 0;
        long sum = 0;
        long cost = 0;
        while (pq.size() != 1) {
            ropeCost1 = pq.remove();
            ropeCost2 = pq.remove();
            sum = ropeCost1 + ropeCost2;
            pq.add((int) sum);
            cost += sum;
        }
        return cost;
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