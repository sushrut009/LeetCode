/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


class LinkList {
    ListNode first ;
    ListNode last ;
    
    public LinkList() {
        first = null ;
        last = null ;
    }
    
    public void insertFirst(int i ) {
	  ListNode obj = new ListNode(i);
	  if(first== null) { //This is the first object
		  last = obj ;
	  }
	  obj.next= first ;
	  first = obj ;
	}
    
    public boolean isEmpty() {
	  if(first == null) {
	    return true ;
	  } else {
		return false ;
	  }
	}
	
	public ListNode insertLast(int i) {
	  ListNode obj = new ListNode(i);
	  if(isEmpty()) {
		obj.next = first;
		first = obj;
		last =  obj;
		
	  } else {
	  last.next = obj ;
	  last = obj;
	  
	 }
	  return first ;
	}
    
    
    
}
class Solution {
    
    LinkList list = new LinkList();
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag=0 ;
        int sum=0 ;
        ListNode res= null ;
        while(l1 != null || l2 !=null) {
            if(l1 !=null && l2 !=null)  {
              sum = l1.val + l2.val + flag ;
              l1 = l1.next ; 
              l2 = l2.next ;
            } else if(l1==null && l2 !=null) {
              sum = l2.val +  flag ;
              l2 = l2.next ;
            } else { 
              sum = l1.val + flag ;
              l1 = l1.next ;
            }
                
            if(sum > 9)
                flag = 1;
            else 
                flag = 0;
            sum = sum % 10 ;  
            res = list.insertLast(sum);
        }
        
        if(flag == 1)
            res = list.insertLast(1);
        
        return res ;
    }
