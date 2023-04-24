class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0){
            return;
        }
        //从后往前比对
        int end = nums1.length-1;
        int i=m-1;
        int j=n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>=nums2[j]){
                nums1[end] = nums1[i];
                i--;
            }else{
                nums1[end] = nums2[j];
                j--;
            }
            end--;
        }
        //num1走完了，num2还没走完
        while(i<0 && j>=0){
            nums1[end] = nums2[j];
            j--;
            end--;
        }
    }
}
