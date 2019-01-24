class KthLargest {
    int k;
    int[] nums;
    PriorityQueue<Integer> queue;

    // maintaining a queue of k size only
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        queue = new PriorityQueue(k);
        for(int i= 0 ; i <nums.length ;i++)
        {
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if(k > queue.size())
        {
            queue.add(val);
        }
        else if(val > queue.peek()){   
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
