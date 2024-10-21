import collections.*

object MainKotlin {
    @JvmStatic
    fun main(args:Array<String>) {
        val treeNode = NonLeafTreeNode(1)
        treeNode.add(LeafTreeNode(2))
        treeNode.add(LeafTreeNode(3))
        treeNode.add(LeafTreeNode(4))
    }
}