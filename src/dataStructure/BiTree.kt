package dataStructure

class BiTree(var value: Int, var left: BiTree? = null, var right: BiTree? = null) {
    override fun toString(): String {
        return StringGenerator.generate(this)
    }

    abstract class Visitor {
        protected abstract fun iterVisit(biTree: BiTree, list: MutableList<Int>)

        fun visit(biTree: BiTree) : MutableList<Int> {
            val list: MutableList<Int> = mutableListOf()
            iterVisit(biTree, list)
            return list
        }
    }

    object PreOrderVisitor : Visitor() {
        override fun iterVisit(biTree: BiTree, list: MutableList<Int>) {
            list.add(biTree.value)
            biTree.left?.let { iterVisit(it, list) }
            biTree.right?.let { iterVisit(it, list) }
        }
    }

    object StringGenerator {
        private fun iterGenerate(biTree: BiTree?) : String {
            biTree?.let {
                return if(biTree.left == null && biTree.right == null) {
                    biTree.value.toString()
                } else {
                    "(${biTree.value}, ${iterGenerate(biTree.left)}, ${iterGenerate(biTree.right)})"
                }
            } ?: return ""
        }

        fun generate(biTree: BiTree) : String {
            return if(biTree.left == null && biTree.right == null) {
                "BiTree(${biTree.value})"
            } else {
                "BiTree(${iterGenerate(biTree)})"
            }
        }
    }
}