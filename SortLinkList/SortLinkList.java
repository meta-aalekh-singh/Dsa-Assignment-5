
public class SortLinkList {
	node head = null;

	static class node {
		int sal;
		String name;
		int age;
		node next;

		public node(int sal,String name, int age) {
			this.sal = sal;
			this.name = name;
			this.age = age;
		}
	}
	/*
	 * Function to Apply Merge Sort on Linked List
	 * @param node a
	 * @param node b
	 */
	node sortedMerge(node a, node b) {
		node result = null;

		/* Base Cases */
		if (a == null)
			return b;
		if (b == null)
			return a;

		/* Pick either a or b, and recur */
		if (a.sal < b.sal) {
			result = a;
			result.next = sortedMerge(a.next, b);
		} else if (a.sal == b.sal) {
			if (a.age > b.age) {
				result = a;
				result.next = sortedMerge(a.next, b);
			} else {
				result = b;
				result.next = sortedMerge(a, b.next);
			}
		} else {
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		return result;
	}

	node mergeSort(node h) {
		// Base case : if head is null
		if (h == null || h.next == null) {
			return h;
		}

		// get the middle of the list
		node middle = getMiddle(h);
		node nextofmiddle = middle.next;

		// set the next of middle node to null
		middle.next = null;

		// Apply mergeSort on left list
		node left = mergeSort(h);

		// Apply mergeSort on right list
		node right = mergeSort(nextofmiddle);

		// Merge the left and right lists
		node sortedlist = sortedMerge(left, right);
		return sortedlist;
	}

	/*
	 * Function to get Middle of Linked List
	 * @param node
	 */
	public static node getMiddle(node head) {
		if (head == null)
			return head;

		node slow = head, fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	/*
	 * Function to push element in the Linked List
	 * @param new_data : New Salary
	 * @param new_age  : New Age
	 */

	void push(int new_data,String name, int new_age) {
		node new_node = new node(new_data,name, new_age);
		new_node.next = head;
		head = new_node;
	}
	
	/*
	 * Function to reverse the Linked List
	 * @param node
	 */
	node reverse(node n){
		node prev=null;
		node curr=n;
		node next=null;
		while(curr!=null){
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		n=prev;
		return n;
	}
	
	/*
	 * Function to Print the Linked List
	 * @param node 
	 */

	void printList(node headref) {
		if(headref==null)
			throw new AssertionError("EmptyList");
		System.out.print("*******************************************************************************************************************************************************");
		while (headref != null) {
			
			System.out.print("\nEmployee : " + headref.name + "  ");
			System.out.print("\t\tSalary : " + headref.sal + "  ");
			System.out.print("\t\tAge : " + headref.age + " ");
			System.out.println();
			headref = headref.next;
		}
	}

	public static void main(String... arg) {
		SortLinkList l1 = new SortLinkList();
		l1.push(15000,"Aalekh", 26);
		l1.push(14500,"Anshul", 24);
		l1.push(12000,"Rupal", 20);
		l1.push(20000,"Mohit", 24);
		l1.push(12000,"Yash", 22);
		l1.push(22000,"Ankur", 22);

		l1.head = l1.mergeSort(l1.head);
		l1.head=l1.reverse(l1.head);
		System.out.println("Sorted Linked List ");
		l1.printList(l1.head);
	}

}