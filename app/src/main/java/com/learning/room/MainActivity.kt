package com.learning.room

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"
class MainActivity : AppCompatActivity(), Interface {
    var isEmpty: Boolean = false
        get() {         //
            return field  // hàm 'getter' mặc định
        }               //
        set(value) {
            field = value
        }
    var isEmpty2: Boolean = false
        get() = 1 == 0    // hàm 'getter' tự định nghĩa
        set(value) {              //
            print("Setter: $value") //hàm 'setter' tự định nghĩa
            field = value           //
        }
    val isEmpty3 get() = 1 == 0

    var setterVisibility: String = "abc"
        private set(value) {
            field = value
        } // hàm 'setter' có modifier là 'private' và việc implement là mặc định

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val a: Int = 10000
        print(a === a) // Prints 'true'
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a
        print(boxedA === anotherBoxedA) // !!!Prints 'false'!!!

        val a2: Int = 127
        print(a2 === a2) // Prints 'true'
        val boxedA2: Int? = a2
        val anotherBoxedA2: Int? = a2
        print(boxedA2 === anotherBoxedA2) // !!!Prints 'true'!!!

        val b: Byte = 1
        val i: Int = b.toInt() //compiler báo lỗi: type mismatch

        val c: Char = 'a'

        var s: String = "hello"
        s[0] // 'h'

        val s3 = "abc"
        val str = "$s3.length is ${s3.length}"

        val aa: Array<Int> = arrayOf(1, 2, 3, 4) // [1,2,3,4]
        var aa1: Array<Int> = Array(3, { it ->
            it * 3
        }) //[0,3,6,9]

        var ba: String? = "hello"

        val la: Int = if (ba != null) ba.length else -1

        val lb = ba?.length ?: -1

        val listWithNulls: List<String?> = listOf("A", null)
        for (item in listWithNulls) {
            item?.let { println(it) } // chỉ thực hiện với các giá trị khác null
        }
        // check kiểu dữ liệu
        if (s is String) {

        }

        var y = 1
        val t: String = y as String

        val t1: String? = y as? String

//        if (ss is String) {
//            print(ss.length) // x được tự động cast thành kiểu String
//        }
//
//        if (ss !is String) return
//        print(ss.length) // x được tự động cast thành kiểu String
//
//        if (ss !is String || ss.length == 0) return // x được tự động cast thành kiểu String

        var result2: Boolean = false
        var ssss: Int = if (result2) 1 else 0

        var r: Int = if (result2) {
            print("ok")
            1
        } else {
            print("fail")
            0
        }

//        when (x) {
//            1 -> print("x == 1")
//            2 -> print("x == 2")
//            else -> {
//                print("x chả bằng 1 cũng méo bằng 2")
//            }
//        }
//        when (x) {
//            0, 1 -> print("x == 0 or x == 1")
//            else -> print("ngược lại")
//        }
//
//        when (x) {
//            parseInt(s) -> print("s encodes x")
//            else -> print("s does not encode x")
//        }
//
//        var result1 = when (s) {
//            is String -> s.startsWith("prefix")
//            else -> false
//        }
//
//        var l: Int = when (s) {
//            "hello" -> 0
//            "hi" -> 1
//            else -> 2
//        }
//
//        val validNumbers = arrayOf(11, 13, 17, 19)
//        when (x) {
//            in 1..10 -> print("x is in the range")
//            in validNumbers -> print("x is valid")
//            !in 10..20 -> print("x is outside the range")
//            else -> print("none of the above")
//        }

        for (i in DateRange(1, 10)) {
            print(i) //1..10
        }

        var array: Array<Int> = arrayOf(1, 2, 5, 6, 7)
        for (i in array) {
            // do something
        }

        for (i in array.indices) {
            print(array[i]) //13268
        }

        for (pair in array.withIndex()) {
            println("element at ${pair.index} is ${pair.value}")
        }

        //result
        //element at 0 is 1
        //element at 1 is 3
        //element at 2 is 2
        //element at 3 is 6
        //element at 4 is 8


//        for (int i = 1; i <= 11 ; i++) {
//            //...
//        }
        for (i in 1..11) {

        }

//        for (int i = 1; i <= 11 ; i+=2) {
//            //...
//        }

        for (i in 1..11 step 2) {

        }

//        for (int i = 10; i>=0;i--) {
//            //...
//        }

        for (i in 11 downTo 1) {

        }

//        for (String s : arrayList) {
//            //...
//        }


//        for (item: Int in ints){
//
//        }

        var x = 0
        while (x > 0) {
            x--
        }

        do {
//            val y = retrieveData()
        } while (y != null) // y is visible here!


        loop@ for (i in 1..100) {
            for (j in 1..100) {
                if (j > 2) break@loop
            }
        }
//        Mặc định, nếu không có label @loop, break sẽ thoát ra khỏi vòng lặp gần nhất, vòng lặp j.
//        Với label @loop, break@loop sẽ thoát ra cả 2 vòng lặp. Tương tự như vậy,
//        continue cũng có thể dung label để đi đến bước tiếp theo của vòng lặp

        var ints: Array<Int> = arrayOf(0, 1, 3, 5, 6)

        ints.forEach lit@{
            if (it == 0) return@lit
            print(it)
        }
//        1356

        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return // non-local return directly to the caller of foo()
            print(it)
        }
        println("this point is unreachable")
//        12

        listOf(1, 2, 3, 4, 5).forEach lit@{
            if (it == 3) return@lit // local return to the caller of the lambda - the forEach loop
            print(it)
        }
        print(" done with explicit label")

//        1245 done with explicit label

        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@forEach // local return to the caller of the lambda - the forEach loop
            print(it)
        }
        print(" done with implicit label")
//        1245 done with implicit label


        listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
            if (value == 3) return  // local return to the caller of the anonymous function - the forEach loop
            print(value)
        })
        print(" done with anonymous function")
//        1245 done with anonymous function

        run loop@{
            listOf(1, 2, 3, 4, 5).forEach {
                if (it == 3) return@loop // non-local return from the lambda passed to run
                print(it)
            }
        }
        print(" done with nested loop")
//        12 done with nested loop

//        var user: User = User("nam", 22)

        lateinit var className: String


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

        fun processWithResult(result: String?): Unit {
            // do something with result
        }

        doSomethingWithNumber(1000, fun(result: String?) {
            // do something with result
        })
    }

    open class Foo {
        open val x: Int = 5
    }

    class Bar1 : Foo() {
        override val x: Int = 10
    }

    interface Foo2 {
        val count: Int
    }

    class Bar12(override val count: Int) : Foo2

    class Bar22 : Foo2 {
        override var count: Int = 0
    }

    class DateRange(start: Int, val end: Int) {
        var current = start

        operator fun iterator(): Iterator<Int> {
            return object : Iterator<Int> {
                override fun next(): Int {
                    val result = current
                    current++
                    return result
                }

                override fun hasNext(): Boolean {
                    return current <= end
                }
            }
        }
    }

    @Deprecated(SUBSYSTEM_DEPRECATED)
    fun deprecated() {

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

    fun processWithResult(result: String?): Unit {
        // do something with result
    }

    override val prop: Int = 123

}