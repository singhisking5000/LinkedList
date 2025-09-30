/*
Problem:  Write a program that keeps and manipulates a linked list of
	    String data. The data will be provided by the user one item at a time.
      The user should be able to do the following operations:
                     -add "String"
                                adds an item to your list (maintaining alphabetical order)
                     -remove "String"
                                if the item exists removes the first instance of it
                     -show
                                should display all items in the linked list
                     -clear
                               should clear the list
	Input:  commands listed above
	Output:  the results to the screen of each menu
	    choice, and error messages where appropriate.
*/

/*
 *  Starter Code Provided by Mr. Menchukov
 * 
 *  LinkedList Class Written By Jamshed Kalsi
 *  
 *  Part A:
 *  add() ----> Adds a string element to the list, sorted into alphabetical order
 *  remove() -> Removes a string element form the list (First instance of it if there are more than one)
 *  show() ---> Shows the elements and length of the list
 *  clear() --> Clears the list 
 * 
 *  Part B:
 *  reverse() --> Reverses the ENTIRE list
 *  nReverse() -> Reverses the first 'n' elements of the list
 */


public class LinkedList{
  //instance varialbes go here (think about what you need to keep track of!)
  private int length = 0;
  private ListNode head;
  //constructors go here
  LinkedList()
  {
    head = null;
  }
 
  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been added and returned
  public ListNode addAValue(String line)
  {
    // If its the first element
    if(head == null){
      head = new ListNode(line, null);
      length++;
      return head;
    }

    // If not, find the spot its supposed to go
    ListNode curr = head;
    while ((curr.getNext() != null) && curr.getNext().getValue().compareToIgnoreCase(line) <= 0)
    {
      // Keep going till you find the spot
      curr = curr.getNext();
    }
    // add the new node 
    curr.setNext(new ListNode(line, curr.getNext()));
    length++;
    return curr.getNext();
  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been deleted and returned.
  //if the value is not in the list returns null
  public ListNode deleteAValue(String line)
  {
    if (length <= 0)
    {
      return new ListNode("No Elements To Remove From", null);
    }
    if (!showValues().contains(" " + line + " "))
    {
      return new ListNode("Element Does Not Exist In The List", null);
    }
    // If the value is the head, set the head to the one that follows it
    if (head.getValue().equals(line) && !(head.getNext() == null))
    {
      ListNode deleted = head;
      head = head.getNext();
      length--;
      return deleted;
    } else if (head.getValue().equals(line) && head.getNext() == null)
    {
      // if the head is the one that follows, we 
      ListNode deleted = head;
      head = null;
      length--;
      return deleted;
    } else
    {
      // Our current position
      ListNode curr = head;
      while (!(curr.getNext().getValue().equals(line)) && curr.getNext() != null)
      {
        // Find our target to delete
        curr = curr.getNext();
      }
      if (curr.getNext() == null)
      {
        curr = null;
        return null;
      }
      ListNode removed = curr.getNext();
      curr.setNext(curr.getNext().getNext());
      length--;

      return removed;
    }
  }

  //precondition: the list has been initialized
  //postconditions: returns a string containing all values appended together with spaces between.
  public String showValues()
  {
    String values = "";
    if (head == null)
    {
      return "List is empty!";
    }

    ListNode curr = head;
    values += curr.getValue() + " ";
    while(curr.getNext() != null)
    {
      curr = curr.getNext();
      values += curr.getValue() + " ";
    }

    return ("Length: " + length + " -=-=-=- Values: " + values); 
  }

  //precondition: the list has been initialized
  //postconditions: clears the list.
  public void clear()
  {
    head = null;
    length = 0;
  }
  // 1 2 3 4 5 6 7 8
  // head => tail
  // 8 2 3 4 5 6 7 1


  /*                              
   *  !========== PART TWO ==========!
   */                             


  // Function that Reverses the ENTIRE list
  public void reverse()
  {
    // Declared these guys
    ListNode first = null;
    ListNode second = head;
    ListNode third = head.getNext();

    while (second != null)
    {
      System.out.println(second.getValue());
      second.setNext(first);
      first = second;
      second = third;
      if (third != null)
      {
        third = third.getNext();
      }
    }
    head = first;
  }

  // Function that reverses the first 'n' elements of the list
  public void nReverse(int n)
  {

  }

}
