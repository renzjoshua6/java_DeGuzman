package designpatterns.behavioral.iterator

interface Iterator {
    operator fun hasNext(): Boolean
    operator fun next(): Any?
}