import java.util.*;
class TestperfomanceList
{
	public static void tList()
	{
		List <Integer> arr = new ArrayList<Integer>();
		List <Float> linklist = new LinkedList<Float>();
		
		for(int i=0;i<50000;i++)
		{
			arr.add(i+1);
			linklist.add((float)(i));
		}
		
		print(arr,linklist);
	}
	
	public static void print(List <Integer> arr,List <Float> linklist)
	{
		for(int i=0;i<50000;i++)
		{
			if(i % 100 == 0)
				System.out.println();
			System.out.print(arr.get(i+1));
		}
		for(int i=0;i<50000;i++)
		{
			if(i % 100 == 0)
				System.out.println();
			System.out.print(linklist.get(i+1));
		}
	}
	public static void main(String [] args)
	{
		tList();
	}
}
