public class RemoveNthFromEnd {
  //Approach : 
  // Traverse the list and store the references to nodes in a hash map 
  // Return the element at Length - N  index 
  public void RemoveNthElemFromEnd(ListNode head , int n) {
    ListNode current = head ;
    HashMap<Integer,ListNode> hm = new HashMap<Integer,ListNode>(); 
    int length = 0;  // Holds the length of the list
    while(current != null) {
      hm.put(length, current);
      current = current.getNext();
      length++ ;
    }
  //Handle special cases ------------------------------------------------------------------------
    if( n== 1) {
      if(length == 1) {
        head = null ; 
        return head ;
      }
      hm.get(length-2).next = null ;
      return head ;
    }
    if( n == length ) {
      head =hm.get(1);
      return head;
    }
  //  Special Cases End ---------------------------------------------------------------------------
  // The hashMap has indices(keys) from 0 to length-1 
		
  //System.out.println(length );
    int index = length - n ; 
    hm.get(index-1).setNext(hm.get(index+1));
  //System.out.printf("%dth element from the end of the list has value %d" ,n , hm.get(index).getData());
  }
}  
