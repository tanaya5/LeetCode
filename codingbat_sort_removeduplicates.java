int[] sort(int[] a) {
  int newsize = 0;
  int[] temp = new int[a.length];
  insertSort(a);
  int last = Integer.MIN_VALUE;
  for(int i =0 ; i<a.length ; i++)
  {
    if(last != a[i])
    {
      temp[newsize] = a[i];
      newsize++;
      last = a[i];
    }
  }
  int[] res = new int[newsize];
  for(int i = 0; i< newsize ; i++)
  {
    res[i] = temp[i];
  }
  return res;
}
public void insertSort(int[] a)
{
  for(int i = 0; i <a.length -1 ;i++)
  {
    for(int j = i+1 ; j< a.length ; j++)
    {
      if(a[i] > a[j] )
      {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
      }
    }
  }
}
