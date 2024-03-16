public class minPageSearch {
    public static int max(int arr[]){
        int max = 0;;
        for(int i = 0 ; i < arr.length ; i++){
            max = arr[i];
            for(int j = i + 1; j < arr.length ; j++){
                if(max < arr[j]){
                    max = arr[j];
                }
            }
        }
        return max;
    }
    public static int sum(int arr[]){
        int sum = 0;
        for(int i =0 ; i < arr.length ; i++){
            sum += arr[i];
        }
        return sum;
    }
    public static int minPage(int arr[], int k){
        int min = max(arr);
        int max = sum(arr);
        int res = 0;
        while(min <= max){
            int mid = (min + max) / 2;
            if(isFiseble(arr , k , mid)){
                res = mid;
                max = mid - 1;
            }
            else{
                min = mid + 1;
            }
        }
        return res;

    }
    public static boolean isFiseble(int arr[] , int k , int res){
        int student = 1;
        int sum = 0;
        for(int i =0 ; i< arr.length ; i++){
            if(sum + arr[i] > res){
                student ++;
                sum = arr[i];
            }
            sum += arr[i];
        }
        return (student <= k);
    }
    public static void main(String args[]){
        int arr [] = { 10 , 5 , 20 };
        System.out.println("Minimum no. of pages 2 students can read is :" +minPage(arr, 2));
    }
    
}
