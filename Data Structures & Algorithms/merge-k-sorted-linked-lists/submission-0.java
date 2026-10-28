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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);

        ListNode ans = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        while (!pq.isEmpty()) {
            ListNode a = pq.poll();

            ans.next = a;
            ans = ans.next;

            if (a.next != null) {
                pq.offer(a.next);
            }
        }
        return dummy.next;
    }
}
