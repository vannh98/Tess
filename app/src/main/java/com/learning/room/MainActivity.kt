package com.learning.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() , Interface{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DataManagerKt.isTokenExpired()
        reformat("")
        reformat("", true, true, false, '_')
        reformat("", wordSeparator = '_')

        val l = mutableListOf("2", "", "")
        l.swap2(0, 2)

        // Now, to use this function:
        val (result, status) = function()
        Log.e("result: ", result.toString())
        Log.e("status: ", status.toString())


        val (name, age, province) = Person("Hado", 22)

        println("Name: $name") //print: Name: Hado
        println("Age: $age") //print: Age: 22
        println("Province: $province") //print: Province: Ha Noi


        val plane1 = Fly("Ha Noi")

        plane1 flyTo "Ho Chi Minh" //print: The plane fly from Ha Noi to Ho Chi Minh

        plane1.flyTo("Ho Chi Minh") //print: The plane fly from Ha Noi to Ho Chi Minh

        multiPrint(prefix = "Start", "a", "b", "c", suffix = "End")

        doSomethingWithNumber(1000, ::processWithResult)

        fun processWithResult(result: String?) : Unit {
            // do something with result
        }

        doSomethingWithNumber(1000, fun(result: String?) {
            // do something with result
        })
    }


    fun doSomething(matter: String): String {
        return ""
    }

    fun getInfo(): String = "Hello world..."

    fun getInfo2(): String {
        return "Hello world..."
    }

    fun printArea(width: Int, height: Int): Unit {
        fun calculateArea(width: Int, height: Int): Int = width * height
        val area = calculateArea(width, height)
        println("The area is $area")
    }

    fun reformat(age: Int, somethingUnknown: String = "hello") {
        var birthMonth: Int = 8

        fun localRefomat() {
            birthMonth = 5

            //không sử dụng được variable birthYear
        }

        var birthYear: Int = 1995
    }

    open class A {
        open fun foo(i: Int = 10) {}
    }

    class B : A() {
        override fun foo(i: Int) {}  // no default value allowed
    }

    fun reformat(
        str: String,
        normalizeCase: Boolean = true,
        upperCaseFirstLetter: Boolean = true,
        divideByCamelHumps: Boolean = false,
        wordSeparator: Char = ' '
    ) {

    }

    fun printHello(name: String?): Unit {
        if (name != null)
            println("Hello ${name}")
        else
            println("Hi there!")
        // `return Unit` or `return` is optional
    }

    fun printHello2(name: String?) {

    }

    fun MutableList<Int>.swap(index1: Int, index2: Int) {
        val tmp = this[index1] // 'this' corresponds to the list
        this[index1] = this[index2]
        this[index2] = tmp
    }

    fun <T> MutableList<T>.swap2(index1: Int, index2: Int) {
        val tmp = this[index1] // 'this' corresponds to the list
        this[index1] = this[index2]
        this[index2] = tmp
    }


    data class Result(val result: Int, val status: Int)

    fun function(): Result {
        // computations

        return Result(1, 2)
    }

    data class Person(var name: String, var age: Int) {
        var province: String = "Ha Noi"

        operator fun component3(): String {
            return province
        }
    }


//    fun <T> singletonList(item: T): List<T> {
//        // ...
//    }
//
//    fun <T> T.basicToString() : String {  // extension function
//        // ...
//    }
//    val l = singletonList<Int>(1)
//
//    fun <T : Comparable<T>> sort(list: List<T>) {
//        // ...
//    }
//    sort(listOf(1, 2, 3)) // OK. Int is a subtype of Comparable<Int>
//    sort(listOf(HashMap<Int, String>())) // Error: HashMap<Int, String> is not a subtype of Comparable<HashMap<Int, String>>


    class Fly(var currentPlace: String) {
        //        Function là member của một class hoặc là extension của class
//        Function chỉ có một param duy nhất
//        Function được mark bằng infix ở đầu function
        infix fun flyTo(nextPlace: String) {
            println("The plane fly from $currentPlace to $nextPlace")
        }

    }

    fun add(vararg array: Int): Int {
        var s = 0
        for (i in array) {
            s += i
        }
        return s
    }

    fun multiPrint(prefix: String, vararg strings: String, suffix: String) {

    }


    fun doSomethingWithNumber(number: Int, receiver: (String?) -> Unit) {
        var result: String? = null
        //...do complex work with number

        receiver(result)
    }

    fun processWithResult(result: String?) : Unit {
        // do something with result
    }

    override val prop: Int = 123

}