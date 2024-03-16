public class sortColours {
    public static int[] sort(int nums[]) {
        int f = 0;
        int l = nums.length - 1;
        int i = 0;
        while (i <= l) {
            if (nums[i] == 0) {
                swap(nums, i, f);
                f++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, l);
                l--;
            } else {
                i++;
            }
        }
        return nums;
    }

    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 0, 2, 1, 2, 0 };
        int res[] = sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(res[i]);
        }

    }
}