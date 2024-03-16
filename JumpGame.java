public class JumpGame {
    public static boolean canJmp(int nums[]) {
        int last = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= last) {
                last = i;
            }
        }
        return last == 0;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 1, 0, 0, 1 };
        System.out.println(canJmp(nums));
    }
}
