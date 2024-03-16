import java.util.Arrays;

public class BinarySearch {
    public static int Search(int arr[] , int search , int f , int l){
        int mid = (f + l)/2;
        if(f > l){
            return  -1;
        }
        if(arr[mid] == search){
            return mid;
        }
        else if( arr[mid] > search){
            return Search(arr, search, f, mid - 1);
        }
        else{
            return Search(arr, search, mid + 1, l);
        }
    } 

   public static void main(String args[]) {
        int arr[] = {11, -1, 3, -4, 10, 7};
        int search = 7;
        System.out.println("Element to Search: " + search);
        Arrays.sort(arr);
        
        int f = 0;
        int l = arr.length - 1; // Use the length of the sorted array
        System.out.println("Search element found at index: " + Search(arr, search, f, l));
    
         /*  better way than recursive :
         while (f <= l) {
            int mid = (f + l)/ 2; // Calculate the middle index
            if (arr[mid] == search) {
                System.out.println("Search element found at index: " + mid);
                break;
            } else if (arr[mid] < search) {
                f = mid + 1;
            } else {
                l = mid - 1;
            }
        }

        if (f > l) {
            System.out.println("Search element not found");
        }
    }*/
    }
}
 