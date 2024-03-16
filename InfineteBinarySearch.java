import java.util.Scanner;

public class InfineteBinarySearch {

    public static int birnarySearch(int arr[] , int search , int f , int l){
        if(f > l){
            return -1 ;
        }
        int mid = (f + l) / 2;
        if(arr[mid] == search){
            return mid;
        }
        else if(arr[mid] > search){
            return birnarySearch(arr, search, f, mid - 1);
        }
        else{
            return birnarySearch(arr, search, mid + 1, l);
        }
    }
    public static int infiniteSearch(int arr[] , int search){
        int f = 0 ;
        int l = 1 ;
        while(arr[l] < search){
            f = l ;
            l = 2 * l ;
        }
        return birnarySearch(arr, search, f , l);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int search = sc.nextInt();
        int arr[] = new int[1000];
        System.out.println("Enter the Search element : " +search);
        for (int i = 0 ; i < 1000 ; i++){
            arr[i] = 2 * i;
        }
        System.out.println("Search element at index :" +infiniteSearch(arr, search));
    }
    
}
