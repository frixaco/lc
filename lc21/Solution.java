package lc21;

public class Solution {

    public static void main(String[] args) {
        Solution lc21Solution = new Solution();

        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode result = lc21Solution.mergeTwoLists(list1, list2);
        while (result.next != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode result = new ListNode();

        // return 1->1->2->3->4(2)->4(1)
        // result: 1
        // l1: 1->2->4
        // l2: 1->3->4

        // return ->1->2->3->4(2)->4(1)
        // result: 1
        // l1: 1->2->4
        // l2: 3->4

        // return ->2->3->4(2)->4(1)
        // result: 2
        // l1: 2->4
        // l2: 3->4

        // return ->3->4(2)->4(1)
        // result: 3
        // l1: 4
        // l2: 3->4

        // return ->4(2)->4(1)
        // result: 4
        // l1: 4
        // l2: 4

        // return ->4(1)
        // result: 4 (l1.val) <===========
        // l1: 4 -----------------------||
        // l2: null => return l1 =======||
        if (list1.val < list2.val) { // 4 < 4
            result.val = list1.val; //
            list1 = list1.next; //
            result.next = mergeTwoLists(list1, list2); // merge()
        } else {
            result.val = list2.val; // result.val = 4
            list2 = list2.next; // list2 = null
            result.next = mergeTwoLists(list1, list2); // merge(4, null)
        }

        return result;
    }
}