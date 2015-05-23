import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Solution {
    private static int listLength = 0;
	private static ListIterator<Integer> frontItr = null;

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	LinkedList<Integer> intList = new LinkedList<Integer>();
    	 
    	int m = 0;
    	int ithFromBack = -1;
         try { 
            Scanner sc = new Scanner(System.in);     
           	m = sc.nextInt();
            while (sc.hasNextInt()) {
                intList.add(sc.nextInt());
                listLength++;
                if ( listLength == m ) {
                	// Get list iterator
                	ithFromBack++;
                	frontItr = intList.listIterator(ithFromBack);
                } else if (listLength > m) {
                	ithFromBack++;
            		frontItr = intList.listIterator(ithFromBack);
                }
            }
            if ( listLength > m) {
            	Integer item = frontItr.next();
            	System.out.println(item);
            	//System.out.println(mthFromLastInt);
            } else {
            	System.out.println("NIL");
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
