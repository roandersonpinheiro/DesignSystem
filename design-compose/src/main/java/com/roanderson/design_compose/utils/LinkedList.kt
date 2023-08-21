package com.roanderson.design_compose.utils

class Node(val value: Int, var next: Node? = null)

class LinkedList {
    private var head: Node? = null

    fun add(value: Int) {
        val newNode = Node(value)
        if (head == null) {
            head = newNode
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newNode
        }
    }

    fun display() {
        var current = head
        while (current != null) {
            println(current.value)
            current = current.next
        }
    }
}

fun main() {
    val linkedList = LinkedList()
    linkedList.add(1)
    linkedList.add(2)
    linkedList.add(3)

    linkedList.display()
}
