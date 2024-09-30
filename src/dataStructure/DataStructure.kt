package dataStructure

object DataStructure {
    @JvmStatic
    fun main(args: Array<String>) {
        val biTree = BiTree(3,
            BiTree(4, BiTree(5), BiTree(6)),
            BiTree(3, BiTree(7)),
            )
        println(BiTree.PreOrderVisitor.visit(biTree))
    }
}