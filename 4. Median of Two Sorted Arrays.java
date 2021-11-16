class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length, n = nums2.length;
        int[] M = nums1;
        int[] N = nums2;
        int start = 0, end = m;
        int x, y;
        while (start <= end) {
            x = start + (end - start) / 2;
            y = (m + n + 1) / 2 - x;
            int xLeft = x == 0 ? Integer.MIN_VALUE : M[x - 1];
            int xRight = x == m ? Integer.MAX_VALUE : M[x];
            int yLeft = y == 0 ? Integer.MIN_VALUE : N[y - 1];
            int yRight = y == n ? Integer.MAX_VALUE : N[y];
            if (xLeft <= yRight && yLeft <= xRight) {
                if ((m + n) % 2 == 0)
                    return (double) (Math.max(xLeft, yLeft) + Math.min(xRight, yRight)) / 2;
                else 
                    return (double)Math.max(xLeft, yLeft);
            } else if (xRight < yLeft) {
                start = x + 1;
            } else if (xLeft > yRight) {
                end = x - 1;
            }
        }
        return 0.0;
    }
}
