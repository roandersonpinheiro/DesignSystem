package com.roanderson.design_compose.utils

class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BinaryTree {
    var root: TreeNode? = null

    fun insert(value: Int) {
        root = insertRec(root, value)
    }

    private fun insertRec(currentNode: TreeNode?, value: Int): TreeNode {
        if (currentNode == null) {
            return TreeNode(value)
        }

        if (value < currentNode.value) {
            currentNode.left = insertRec(currentNode.left, value)
        } else if (value > currentNode.value) {
            currentNode.right = insertRec(currentNode.right, value)
        }

        return currentNode
    }

    fun search(value: Int): Boolean {
        return searchRec(root, value)
    }

    private fun searchRec(currentNode: TreeNode?, value: Int): Boolean {
        if (currentNode == null) {
            return false
        }

        if (value == currentNode.value) {
            return true
        }

        return if (value < currentNode.value) {
            searchRec(currentNode.left, value)
        } else {
            searchRec(currentNode.right, value)
        }
    }
}

fun main() {
    val tree = BinaryTree()
    tree.insert(5)
    tree.insert(3)
    tree.insert(8)
    tree.insert(1)
    tree.insert(4)

    println(tree.search(4)) // Output: true
    println(tree.search(7)) // Output: false
}
