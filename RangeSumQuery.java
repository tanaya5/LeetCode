class NumMatrix {
    int[][] tree;
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
       this.matrix = matrix;
        int m = matrix.length , n=0;
        if(m!=0 )
        {
            n = matrix[0].length;
        }
        
        tree = new int[m][n];
        for(int i =0; i < m ; i++)
        {
            tree[i][0] = matrix[i][0];
            for(int j= 1 ; j< n; j++)
            {
                tree[i][j] = tree[i][j-1] + matrix[i][j];
            }
        }
        
    }
    
    public void update(int row, int col, int val) {
       int diff =  val - matrix[row][col];
        matrix[row][col] = val;
       // System.out.println(diff);
       for(int i = col ; i < tree[0].length ; i++)
       {
           tree[row][i] += diff;
       }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        if(row1 < tree.length && row2 < tree.length && col1 < tree[0].length && col2< tree[0].length)
        {
            if(col1 == 0)
            {
                for(int i = row1 ; i <= row2 ; i++)
                {
                    // System.out.println(tree[i][col2]);
                    sum = sum + tree[i][col2];
                }
            }
            else
            {
                for(int i = row1 ; i<= row2 ; i++)
                {
                    sum = sum + tree[i][col2] - tree[i][col1-1];
                }
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
