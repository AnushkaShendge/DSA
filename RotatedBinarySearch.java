import java.util.Scanner;

public class RotatedBinarySearch {
    public static int BinarySearch(int arr[] , int search , int f , int l){
        if(f > l){
            return -1 ;
        }
        int mid = (f + l) / 2;
        if(arr[mid] == search){
            return mid;
        }
        //left part is sorted
        if(arr[mid] > arr[f]){
            if(search >= arr[f]  && arr[mid] > search){
                return BinarySearch(arr, search, f, mid - 1);
            }

            else{
                return BinarySearch(arr, search, mid + 1, l);
            }
        }
        //Right part is sorted 
        else{
            if(search <= arr[l]  && arr[mid] < search){
                return BinarySearch(arr, search, mid + 1, l);
            }
            else{
                return BinarySearch(arr, search, f, mid - 1);
            }
        }
    }
    public static void main(String args[]) {

        int arr[] = {4, 5, 0, 1, 2, 3};
        Scanner sc = new Scanner(System.in);
        int search = sc.nextInt(); 
        System.out.println("Enter Element to Search: " + search);
        
        System.out.println("Search element found at index: " + BinarySearch(arr, search , 0 , 5));
    }  

}
