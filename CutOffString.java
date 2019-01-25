public String withoutString(String base, String remove) {
  String result = "";
  
  char[] ch = base.toCharArray();
  char[] find = remove.toCharArray();
  
  int i=0;
  while(i<ch.length)
  {
    boolean flag = false;;
    
    if(Character.toLowerCase(ch[i])==Character.toLowerCase(find[0]))
    {
      flag = true;
      for(int j=0; j< find.length; j++ )
      {
        if( i+j<ch.length && Character.toLowerCase(ch[i+j]) != Character.toLowerCase(find[j]))
          flag = false;
      }
    }
    
    // increment i
    if(flag)
        i= i + find.length;
      else
      {
        result = result+ch[i];
        i++;
      }
    
  }
  
  return result;
}
