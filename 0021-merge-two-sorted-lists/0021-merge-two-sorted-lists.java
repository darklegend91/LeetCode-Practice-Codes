import java.util.*;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        int len1 = 0, len2 = 0;

        ListNode curr = list1;
        while (curr != null) {
            len1++;
            curr = curr.next;
        }

        ListNode curr2 = list2;
        while (curr2 != null) {
            len2++;
            curr2 = curr2.next;
        }

        int[] arr = new int[len1 + len2];

        curr = list1;
        curr2 = list2;

        int index = 0;

        while (curr != null) {
            arr[index++] = curr.val;
            curr = curr.next;
        }

        while (curr2 != null) {
            arr[index++] = curr2.val;
            curr2 = curr2.next;
        }

        if (arr.length == 0)
            return null;

        Arrays.sort(arr);

        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }

        return head;
    }
}
