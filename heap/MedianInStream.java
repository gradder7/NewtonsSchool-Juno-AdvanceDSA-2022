/*
 * Find median in a stream
 * medium
 * Problem Statement
 * Given an input stream of N integers. The task is to insert these numbers into
 * a new stream and find the median of the stream formed by each insertion of X
 * to the new stream.
 * 
 * Note: Median is the middle value in an ordered integer list. If the size of
 * the list is even, there is no middle value. So the median is the mean of the
 * two middle values.
 * Input
 * User Task:
 * Since this will be a functional problem, you don't have to take input. You
 * just have to complete the function
 * getMedian() that takes X as parameter.
 * 
 * Constraints:
 * 1 <= N <= 10^5
 * 1 <= X <= 10^5
 * Output
 * You need to return the median.
 */
// Function to getMedian
 //max heap
  static PriorityQueue<Integer> leftHalfofSmaller = new PriorityQueue<>(Collections.reverseOrder());
  //min heap
  static PriorityQueue<Integer> rightHalfofGreater = new PriorityQueue<>();
  //function to calculate median
  public static double getMedian(int X)
    {
       // Your code here
       //function for insert go for its defination
       insertInPq(X);
       //even
       if(leftHalfofSmaller.size()==rightHalfofGreater.size()){
          return (leftHalfofSmaller.peek()+rightHalfofGreater.peek())/2.0;
       } else
       //odd 
       return leftHalfofSmaller.peek();
    }

    public static void insertInPq(int x){
       if(leftHalfofSmaller.isEmpty() || leftHalfofSmaller.peek()>=x){
          leftHalfofSmaller.add(x);
       }
       else{
          rightHalfofGreater.add(x);
       }
       //even
       if(leftHalfofSmaller.size()>rightHalfofGreater.size()+1){
          rightHalfofGreater.add(leftHalfofSmaller.remove());
       }
       //odd
       else if (leftHalfofSmaller.size()<rightHalfofGreater.size()){
          leftHalfofSmaller.add(rightHalfofGreater.remove());
       }
    }