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
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;
        while(l1 != null || l2 != null){
            int val = carry;
            if(l1 != null){
                val += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                val += l2.val;
                l2 = l2.next;
            }
            int digit = val%10;
            carry = val/10;
            ListNode node = new ListNode(digit);
            temp.next = node;
            temp = node;
        }
        if(carry != 0){
            ListNode node = new ListNode(carry);
            temp.next = node;
            temp = node;
        }
        return dummy.next;
    }
}








