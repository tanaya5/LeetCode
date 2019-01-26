public Map<String, String> mapShare(Map<String, String> map) 
{
  Map<String, String> result  =  new HashMap<String,String>();
  if(map.containsKey("a") && map.containsKey("b"))
    map.remove("b");
  Iterator iterator = map.keySet().iterator();
  while(iterator.hasNext())
  {
    String key   = iterator.next().toString();
    String value = map.get(key).toString();
    if(key.equals("a"))
    {
      result.put("a",map.get(key));
      result.put("b",map.get(key));
    }
    else if(key.equals("c"))
    {
      
    }
    else
    {
      result.put(key,map.get(key));
    }
  }
  return result;
}
