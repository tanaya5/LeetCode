public int sumNumbers(String str) {
  char[] ch = str.toCharArray();
  String result = "";
  int sum = 0;
  boolean flag = false;
  for(char c : ch)
  {
    if(Character.isDigit(c))
    {
      flag = true;
      result = result + c;
    }
    else if(flag)
    {
      flag = false;
      sum = sum + Integer.parseInt(result);
      result="";
    }
      
  }
  
  if(!result.equals(""))
    sum = sum + Integer.parseInt(result);
  return sum;
}
