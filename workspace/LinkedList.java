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
    // If the value is the head, set the head to the one that follows it
    if (head.getValue().equals(line) && !(head.getNext() == null))
    {
      head = head.getNext();
      length--;
      return head;
    } else if (head.getValue().equals(line) && head.getNext() == null)
    {
      head = null;
      length--;
      return null;
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
    values += curr.getValue();
    while(curr.getNext() != null)
    {
      curr = curr.getNext();
      values += curr.getValue();
    }

    return values; 
  }

  //precondition: the list has been initialized
  //postconditions: clears the list.
  public void clear()
  {
    head = null;
  }
}
