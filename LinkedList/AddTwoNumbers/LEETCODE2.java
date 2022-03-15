/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode head = new ListNode(), peek = head;
        
        int sum = 0, bonus = 0;
        
        while (true) {
            
            sum = bonus;
            
            if (l1 != null) {
                
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                
                sum += l2.val;
                l2 = l2.next;
            }
            
            peek.val = sum % 10;
            bonus = sum / 10;
            
            if (l1 != null || l2 != null) peek = (peek.next = new ListNode());
            else {
                
                if (bonus != 0) (peek.next = new ListNode()).val = bonus;
                break;
            }
        }
        
        return head;
    }
}