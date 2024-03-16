import java.util.Stack;

public class stkMarix {
    public static int[] preSmaller(int arr[] , int n){
        Stack<Integer> s = new Stack<>();
        s.push(arr[0]);
        int ps[] = new int[n];
        ps[0] = -1;

        for(int i=1 ; i< n ; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ps[i] = -1;
            }
            else{
                ps[i] = s.peek();
            }
            s.push(i);
        }
        return ps;
    }
    public static int[] nextSmaller(int arr[], int n) {
        Stack<Integer> st = new Stack<>();
        int ns[] = new int[n]; 
    
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                ns[st.pop()] = i;
            }
            st.push(i);
        }
        // remaining elements in stack have no samller element so they given with index 9 i.e -1
        while (!st.isEmpty()) {
            ns[st.pop()] = n;
        }
    
        return ns;
    }
    
    public static int Hiso(int arr[] , int n){
        int MaxArea = 0;
        int ns[] = nextSmaller(arr, n);
        int ps[] = preSmaller(arr, n);
        for(int i=0 ; i< n ; i++){
            int curr = (ns[i] - ps[i] -1)* arr[i];
            if(curr > MaxArea){
                MaxArea = curr;
            }
        }
        return MaxArea;
    }
    public static int binaryMatrix(int arr[][], int n){
        int curow[] = new int[n];
        int Max = Hiso(curow, n);
        for(int i= 1 ; i< arr.length ; i++){
            for(int j =0 ; j < arr[0].length ; j++){
                if(arr[i][j] == 1){
                    curow[j] += 1;
                }
                else{
                    curow[j] = 0;
                }
            }
        }
        int curAns= Hiso(curow, n);
        if(curAns > Max){
            Max = curAns;
        }
        return Max;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 1, 1, 1, 0},
            {1, 0, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 0},
        };
        
        int result = binaryMatrix(matrix, 6);
        System.out.println("Maximum Rectangle Area in Binary Matrix : " + result);
    }

}
