package lt215;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};


        // int i = findKthLargest(nums, 2);
        // System.out.println(i);

        int i1 = findKthLargest1(nums, 2);
        System.out.println(i1);


    }


    /**
     * 	执行耗时:59 ms,击败了15.17% 的Java用户
     * 	内存消耗:50.1 MB,击败了25.24% 的Java用户
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> store = new PriorityQueue<>();
        for (int i : nums) {
            store.offer(i);
            if (store.size() > k) {
                store.poll();
            }
        }
        return store.peek();
    }

    /**
     * 	执行耗时:38 ms,击败了33.38% 的Java用户
     * 	内存消耗:48.5 MB,击败了98.00% 的Java用户
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest1(int[] nums, int k) {
        quickSort(nums,0,nums.length-1);
        System.out.println(nums);
        return nums[nums.length - k];
    }

    public static void quickSort(int[] nums, int left, int right) {
        if(left>right){
            return;
        }
        int pl = left, pr = right;
        //随机取支点 防止最差排序O(N2)
        int privot = findPrivot(nums,left,right);
        while (pl < pr) {
            while (pl < pr && nums[pr] > privot) {
                pr--;
            }
            while (pl < pr && nums[pl] <= privot) {
                pl++;
            }
            if(pl<pr){
                swap(nums, pl, pr);
            }

        }
        swap(nums,left,pr);
        quickSort(nums,left,pr-1);
        quickSort(nums,pr+1,right);
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static int findPrivot(int[] nums,int left,int right){

        int random = (int) (Math.random()*(right-left) + left);
        swap(nums,left,random);
        return nums[left];
    }


}
