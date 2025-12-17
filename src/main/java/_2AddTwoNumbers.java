
public class _2AddTwoNumbers {

    public static void main(String[] args) {
        int number1 = 2147483647;
        int number2 = 15;

        ListNode head1 = Solution.writeAsList(number1);
        ListNode head2 = Solution.writeAsList(number2);

        System.out.println("head1.toString() = " + head1);
        System.out.println("head2.toString() = " + head2);

        System.out.println("getNumberFromList(head1) = " + Solution.getNumberFromList(head1));
        System.out.println("getNumberFromList(head2) = " + Solution.getNumberFromList(head2));

        System.out.print("Solution.addTwoNumbers(head1, head2) = ");
        System.out.println("toString(Solution.addTwoNumbers(head1, head2)) = " + Solution.addTwoNumbers(head1, head2));
        System.out.println("toString(Solution.addTwoNumbersEffective(head1, head2)) = " + Solution.addTwoNumbersEffective(head1, head2));

    }

    public static class ListNode {

        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public String toString() {
            ListNode current;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for(current = this; current.next != null; current = current.next){
                sb.append(current.val).append(", ");
            }
            sb.append(current.val).append("]");
            return sb.toString();
        }
    }

    static class Solution {

        public static ListNode writeAsList(int number) {
            ListNode head = new ListNode(number % 10);
            ListNode current = head;

            for (int temp = number / 10; temp != 0; temp = temp / 10, current = current.next) {
                current.next = new ListNode(temp % 10);
            }

            return head;
        }

        public static int getNumberFromList(ListNode head) {
            int number = head.val;

            for (int temp = 10; head.next != null; temp *= 10) {
                head = head.next;
                number += head.val * temp;
            }
            return number;
        }

        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return writeAsList(getNumberFromList(l1) + getNumberFromList(l2));
        }

        public static ListNode addTwoNumbersEffective(ListNode l1, ListNode l2) {
            int temp = 0;
            ListNode head = new ListNode();
            ListNode current = head;

            while (l1 != null || l2 != null || temp != 0) {
                if (l1 != null) {
                    temp += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    temp += l2.val;
                    l2 = l2.next;
                }
                current.next = new ListNode(temp % 10);
                current = current.next;
                temp /= 10;
            }

            head = head.next;
            return head;
        }
    }

}
