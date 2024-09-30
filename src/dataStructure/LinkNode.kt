package dataStructure

class LinkNode(var value: Int, var next: LinkNode? = null) {
    override fun toString(): String {
        var content = "[$value"
        var node = next
        while (node != null) {
            content += ", ${node.value}"
            node = node.next
        }
        content += "]"
        return content
    }
}
