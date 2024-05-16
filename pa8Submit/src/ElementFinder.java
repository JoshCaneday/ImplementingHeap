import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

public class ElementFinder {

	public static int Kth_finder(String filename, int K, String operation) {
		if (filename == null)
		{
			return -1;
		}
		Comparator<Integer> comparator;
		
		if (operation.equals("largest"))
		{
			comparator = new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o1 - o2;
				}
			};
		}
		else
		{
			comparator = new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			};
		}
		Heap<Integer, Integer> heap = new Heap<Integer, Integer>(comparator);
		int count = 0;
		try {
            File f = new File(filename);
            Scanner sc = new Scanner(f);
            
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split("\n");
                for (int i = 0; i < data.length; i++) {
                	String[] data2 = data[i].split(" ");
                	for(String e : data2)
                	{
                		heap.add(Integer.parseInt(e), count);
                		count++;
                	}
                	
                }
                // Add your code here
                
            }
            sc.close();
        } catch (FileNotFoundException e) {
            return -1;

        }
		if (K >= heap.size())
		{
			return -1;
		}
		for (int i = K-1; i > 0; i--)
		{
			heap.poll();
		}
		
		/** TODO **/
		return heap.peek().getKey();
	}
	
	/* Add any helper methods you find useful */
		
}
