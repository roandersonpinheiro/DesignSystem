package com.roanderson.design_compose.utils

class IntegerQueue {
    private val elements: MutableList<Int> = mutableListOf()

    fun enqueue(element: Int) {
        elements.add(element)
    }

    fun dequeue(): Int? {
        return if (!isEmpty()) {
            elements.removeAt(0)
        } else {
            null
        }
    }

    fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    fun size(): Int {
        return elements.size
    }
}