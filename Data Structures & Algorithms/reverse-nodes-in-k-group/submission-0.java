class Solution {

    public ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode cur = head;

        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;
        ListNode cur = head;

        while (cur != null) {

            // Check whether k nodes are available
            ListNode nextGroup = cur;

            for (int i = 0; i < k; i++) {
                if (nextGroup == null) {
                    return dummy.next;
                }
                nextGroup = nextGroup.next;
            }

            // Reverse current group
            ListNode newHead = reverse(cur, k);

            // Connect previous group to reversed group
            groupPrev.next = newHead;

            // Old head becomes the tail
            cur.next = nextGroup;

            // Move to next group
            groupPrev = cur;
            cur = nextGroup;
        }

        return dummy.next;
    }
}