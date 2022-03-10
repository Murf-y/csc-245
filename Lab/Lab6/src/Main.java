
public class Main {
	public static void main(String[] args) {
		List myList = new List();
		myList.addElement(1);
		myList.addElement(2);
		myList.addElement(3);
		myList.addElement(4);
		myList.addElement(5);
		myList.addElement(6);
		myList.addElement(7);
		myList.displayList();
		myList.reverseList();
		myList.displayList();
	}
	
	
	
	public static String reverseString(String a) {
		if(a.length() <= 1) {
			return a;
		}
		return a.charAt(a.length()-1) + reverseString(a.substring(0, a.length() -1));
	}
	public static int binarySearch(int[] a, int i, int low, int high) {
		if(low >= high) {
			return -1;
		}
		int mid = (low + high)/2;
		
		if(a[mid] == i) {
			return mid;
		}
		else {
			// 1 2 3 4 5
			if(a[mid] > i) {
				high = mid - 1;
				return binarySearch(a, i, low, high);
			}else {
				low = mid + 1;
				return binarySearch(a, i, low, high);
			}
		}
	}
}
