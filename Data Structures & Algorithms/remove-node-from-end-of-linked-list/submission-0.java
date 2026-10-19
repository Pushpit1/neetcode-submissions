class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = head;

        while (cur != null) {
            i++;
            cur = cur.next;
        }

        cur = dummy;

        for (int j = 0; j < i - n; j++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;

        return dummy.next;
    }
}