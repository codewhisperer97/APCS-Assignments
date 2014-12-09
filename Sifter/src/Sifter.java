import java.util.ArrayList;

public class Sifter
{
    private static ArrayList<String> list;
    
    public static void main(String[] args)
    {
        list = new ArrayList<String>();
        
        list.add("Radford");
        list.add("Wise");
        list.add("Buchman");
        list.add("Richmond");
        list.add("Dublin");
        list.add("Saltville");
        list.add("York");
        
        for(String s : list)
        {
            System.out.println(s);
        }
        
        while(!removeElement());
        
        System.out.println();
        for(String s : list)
        {
            System.out.println(s);
        }
    }
    
    private static boolean removeElement()
    {
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).length() < 7)
            {
                list.remove(i);
                return false;
            }
        }
        return true;
    }
}