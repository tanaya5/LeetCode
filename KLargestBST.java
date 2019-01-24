class KthLargest {
    //inner tree class
    public class TreeNode
    {
        Node data;
        TreeNode left;
        TreeNode right;
        public TreeNode()
        {
            this.data = null;
        }
        public TreeNode(Node data)
        {
            this.data = data;
        }
    }
    
    //inner node class
    public class Node{
        int count;
        int val;
        public Node(int val, int count)
        {
            this.val = val;
            this.count = count;
        }
    }
    
    // Class Variables
    TreeNode root ;
    int k = 0;
    
    
    // insertion in tree
    public TreeNode insertNode(TreeNode root,Node node)
    {
        if(root == null)
        {
            root = new TreeNode(node);
        }
        else if(root.data.val > node.val)
        {
            root.data.count ++;
            root.left = insertNode(root.left, node);
        }
        else
        {
            root.data.count ++ ;
            root.right = insertNode(root.right , node);
        }
        return root;
    }
    
    
    // return Kth largest element
    public int searchKLarge(int kth , TreeNode root)
    {
        // step 1: find the difference b/w root:count and root:left:count
        int diff  = 0;
        if(root.left != null)
        {
            diff = root.data.count - root.left.data.count;
            
        }
        else
            diff = root.data.count ;
        
        // step 2: if diff is less than k them move to left else to right subtree
        if(diff == kth)
            return root.data.val;
        else if (diff < kth )
        {
            if(root.right != null)
                return searchKLarge(kth - root.right.data.count - 1 ,root.left);
            else
                return searchKLarge(kth - 1 ,root.left);
        }
        else
        {
            return searchKLarge(kth , root.right);
        }
       
    }
    

    public KthLargest(int k, int[] nums) {
        // this.root = new TreeNode();
        this.k = k;
        Node node;
        // inserting node
        for(int i = 0 ; i< nums.length ;i++)
        {
            node = new Node(nums[i],1);
            root = insertNode(root , node);
        }
        
        
    }
    
    public int add(int val) {
        Node node = new Node(val, 1);
        this.root = insertNode(root, node);
        return searchKLarge(k , root);
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
