public class Recursion2 {
    public static void main(String[] args) {
        Recursion2 test = new Recursion2();
        int[] arr = new int[] { 2, 4, 8 };
        System.out.println(test.groupSum(0, arr, 10));
    }// end main

    public boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length)
            return (target == 0);
        if (groupSum(start + 1, nums, target - nums[start]))
            return true;
        if (groupSum(start + 1, nums, target))
            return true;
        return false;

    }
    public static void func5(int n) {
        if (n == 0 || n == 1)
        return;
        func5(n - 2);
        System.out.print(n + " ");
        func5(n - 2);
    }
    public static long func2(int n) {
        if (n == 1) return 1;
        if (n == 0) return 1;
        return func2(n-1) + func2(n-2);
    }
}// end class
