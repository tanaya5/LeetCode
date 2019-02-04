class Solution {
    public int kEmptySlots(int[] flowers, int k) {
      // creating days array
        int res = Integer.MAX_VALUE;
        int[] days = new int[flowers.length + 1];
        for(int i = 1 ; i<days.length ;i++)
        {
            days[flowers[i-1]] = i;
        }
        
        // sliding window
        int left = 1 , right = 1+ k + 1;
        for(int i = 2; i < days.length && right< days.length ; i++)
        {
            if(i == right)
            {
                // found subarray
                res = Math.min(res , Math.max(days[left], days[right]));
                left = i;
                right = left + k + 1;
            }
            else if(days[i] < days[left] || days[i] < days[right])
            {
                left = i;
                right = left + k +1;
            }
        }
        
        if(res == Integer.MAX_VALUE)
            return -1;
        else return res;
    }
}
