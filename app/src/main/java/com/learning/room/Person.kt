package com.learning.room

private class Person constructor(var firstName: String) {
//    class Customer public @Inject constructor(name: String) { ... }

    constructor(id: Int, name: String) : this(name) {
        //this ở đây gọi trực tiếp đến primary constructor
        // và truyền giá trị id cho primary constructor
    }

    constructor(id: Int, name: String, version: Int) : this(id, name) {
        //this ở đây gọi trực tiếp secondary constructor 2 tham số
        // và được coi là gọi gián tiếp primary constructor qua secondary constructor 2 tham số đó
    }


    fun doSomething(): String {
        return firstName;
    }

    init {

        print("Customer's name is $firstName")
    }

    class DontCreateMe private constructor() {

    }

    open class Base(p: Int)

    class Derived(p: Int) : Base(p)

    open class Base2(p: Int) {
        constructor(p: Int, t: String) : this(p)
        open fun v() {
            print("hi")
        }
        fun nv() {}

    }

    class Derived2(p: Int) : Base2(p, "Hello")

    class Hi : Base2 {
        /*mac dinh khi override thi se la open de tranh cac class khac override thi them tu khoa final*/
        final override fun v() {
            print("hihi")
        }

        constructor(p: Int) : super(p)
        constructor(p: Int, t: String) : super(p,t)
    }

    open class A {
        open fun f() { print("A") }
        fun a() { print("a") }
    }

    interface B {
        fun f() { print("B") } // interface members are 'open' by default
        fun b() { print("b") }
    }
    class C() : A(), B {
        // The compiler requires f() to be overridden:
        override fun f() {
            super<A>.f() // call to A.f()
            super<B>.f() // call to B.f()
        }

    }

    abstract class Base3 {
        abstract fun calculate()
    }

    class Invoice(id: Int) : Base3() {
        override fun calculate() {

        }
    }

    open class Base4 {
        open fun f() {}
    }

    abstract class Derived4 : Base4() {
        abstract override fun f()
    }

}