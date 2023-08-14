package com.roanderson.design_compose.utils

class Node(var data: Int) {
    var prev: Node? = null
    var next: Node? = null
}

class DoublyLinkedList {
    var head: Node? = null
    var tail: Node? = null
    
    fun append(data: Int) {
        val newNode = Node(data)
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            newNode.prev = tail
            tail?.next = newNode
            tail = newNode
        }
    }
    
    fun remove(data: Int) {
        var current = head
        while (current != null) {
            if (current.data == data) {
                val prevNode = current.prev
                val nextNode = current.next
                
                prevNode?.next = nextNode
                nextNode?.prev = prevNode
                
                if (current == head) {
                    head = nextNode
                }
                
                if (current == tail) {
                    tail = prevNode
                }
                
                return
            }
            current = current.next
        }
    }
    
    fun display() {
        var current = head
        while (current != null) {
            print("${current.data} ")
            current = current.next
        }
        println()
    }
}

fun main() {
    val list = DoublyLinkedList()
    list.append(1)
    list.append(2)
    list.append(3)
    
    println("Initial list:")
    list.display()
    
    list.remove(2)
    
    println("List after removing 2:")
    list.display()
}
