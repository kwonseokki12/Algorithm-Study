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
            ListNode dummy = l1;
            boolean isRoundUp = false;
            ListNode prev = null;

            while (l1 != null && l2 != null) {
                if (isRoundUp) {
                    l1.val += 1;
                    isRoundUp = false;
                }

                if (l1.val + l2.val >= 10) {
                    l1.val = (l1.val + l2.val) % 10;
                    isRoundUp = true;
                } else {
                    l1.val = l1.val + l2.val;
                }

                prev = l1;
                l1 = l1.next;
                l2 = l2.next;
            }

            ListNode remain;
            if (l1 == null) {
                remain = l2;

                if (prev != null) {
                    prev.next = remain;
                }
            } else {
                remain = l1;
            }

            while (remain != null) {
                if (isRoundUp) {
                    remain.val += 1;
                    isRoundUp = false;
                }
                if (remain.val >= 10) {
                    isRoundUp = true;
                    remain.val = remain.val % 10;
                }

                prev = remain;
                remain = remain.next;
            }

            if (isRoundUp) prev.next = new ListNode(1);

            return dummy;
    }
}