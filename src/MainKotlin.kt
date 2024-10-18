object MainKotlin {
    @JvmStatic
    fun main(args:Array<String>) {
        val solution = Solution()
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    class Solution {
        fun hasCycle(head: ListNode?): Boolean {
            var node1 = head
            var node2 = head
            while (node1 != null && node2 != null) {
                node1 = node1.next
                node2 = node2.next
                if (node2 == null) {
                    break
                } else {
                    node2 = node2.next
                }
                if (node1 == node2) {
                    return true
                }
            }
            return false
        }
    }
}