
/*
 * Minimum sum
 * easy
 * Time Limit: 2 sec
 * Memory Limit: 128000 kB
 * Problem Statement
 * You are given an integer array of size N such that 0 <= A[i] <= 9. You need
 * to form two numbers by concatenating these digits. All digits of given array
 * must be used to form the two numbers. Find the minimum possible sum of two
 * numbers that you found.
 * 
 * Note: Your number can contain leading zeroes but the sum cannot.
 * Input
 * First line contains an integer N - the size of array
 * Next line contains N space separated integers denoting elements of array.
 * 
 * Constraints
 * 1 <= N <= 10^5
 * 0 <= Ai<= 9
 * Output
 * Print the minimum sum that you obtain.
 * Example
 * Sample Input 1:
 * 6
 * 6 8 4 5 2 3
 * 
 * Output
 * 604
 * 
 * Explanation:
 * The minimum sum is formed by numbers 358 and 246
 * 
 * Sample Input 2:
 * 5
 * 5 3 0 7 4
 * 
 * Output
 * 82
 * 
 * Explanation
 * The minimum sum is formed by numbers 35 and 047.
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
        System.out.println(minSum(arr, n));
    }

    // public static long minSumArray(long[] arr,int n){
    // Arrays.sort(arr);

    // long a=0;
    // long b=0;
    // for(int i=0;i<n;i++){
    // //even index
    // if(i%2==0){
    // a = a*10+arr[i];
    // }
    // //odd index
    // else{
    // b= b*10+arr[i];
    // }
    // }
    // return a + b;
    // }

    public static Long minSum(int arr[], int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        for (int number : arr) {
            pq.add(number);
        }
        while (!pq.isEmpty()) {
            num1.append(pq.poll() + "");
            if (!pq.isEmpty()) {
                num2.append(pq.poll() + "");
            }
        }
        long sum = Long.parseLong(num1.toString()) + Long.parseLong(num2.toString());
        return sum;
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