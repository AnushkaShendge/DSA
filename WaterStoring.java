public class WaterStoring {
    public static int MaxArea(int height[]){
        int maxArea = 0;
        int left = 0 ;
        int right = height.length - 1;
        while(left < right){
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int currArea = w * h;
            maxArea = Math.max(maxArea, currArea);
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
    }
    public static void main(String args[]){
        int arr[] = {6,2,5,4,5,1,6};

        System.out.println("Maximum Area of water stroting histo is " +MaxArea(arr));
    }

}
