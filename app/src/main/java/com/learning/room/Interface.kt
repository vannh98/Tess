package com.learning.room

interface Interface {
    val prop: Int // abstract
    val post: String
        get() = "Any post"

    val propertyWithImplementation: String
        get() = "foo"

    fun foo() {
        print(prop)
    }
}