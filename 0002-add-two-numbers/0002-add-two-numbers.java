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

        ListNode l3 = new ListNode(0);

        ListNode curr = l3;

        int carry =0;

        while ( l1 != null || l2 != null)
        {
            int ele1 = 0;
            int ele2 = 0;

            if (l1 != null)
            {
                ele1 = l1.val;
            }
            if (l2 != null)
            {
                ele2 = l2.val;
            }

            int sum = ele1 + ele2 + carry;
            carry = sum/10;

            curr.next = new ListNode(sum%10);

            curr = curr.next;

            if (l1 != null) { l1 = l1.next ;}
            
            if (l2 != null) { l2 = l2.next; }

        }
        if (carry>0)
        {
            curr.next = new ListNode(carry);
        }
            return l3.next;
    }
}