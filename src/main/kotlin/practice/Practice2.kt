package practice;

import kotlin.math.pow

// about nullable, non-null
fun practice1() {
    var name: String

    name = "Dolly"
    //name = null // can not be assigned non-null type String

    var address: String?
    address = null // can be assigned null with question mark

    var age: Int?
    age = null

}

class Person(
    val first: String,
    val middle: String?,
    val last: String
)

// var / val & smartCast
fun practice2() {
    // val : 불변의 데이터 (immutable type)
//    val p = Person(first = "North", middle = null, last = "West")

    // var : 가변의 데이터 (mutable type)
    var p = Person(first = "North", middle = null, last = "West")
//    val p = Person(first = "South", middle = "Center", last = "East")

    // 가변 변수는 smartCast를 할 수 없다.
    if (p.middle != null) {
//        val middleNameLength = p.middle.length      // because 'p.middle' is a complex expression
        val middleNameLength = p.middle!!.length      // !! : non-null 로 취급하거나 exception 을 발생한다.
        // !! 가 하나라도 있다면 코드 스멜이다. code smell : 잠재적으로 문제가 있는 코드
        println("p's middleNameLength : " + middleNameLength)
    }
}

// ?. / ?: (Elvis Operator) operator
fun practice3() {
    var p = Person(first = "North", middle = null, last = "West")
//    val middleNameLength = p.middle?.length   // null
    val middleNameLength = p.middle?.length ?: 0    // null 일 경우 치환 가능
    println("p's middleNameLength : " + middleNameLength)

    val p1 = p as? Person
}

// 코틀린에서는 명시적으로 변환해주어야한다. 왜냐, Int, Long ,... 다 클래스이기 때문에
fun kotlinNotOfferSuggestive() {
    val intVar: Int = 3
    //val longVar: Long = intVar // error
    val longVar: Long = intVar.toLong()

    // 하지만 + operator 는 자동으로 변환 후 연산을 수행한다.
    // intVar 이 .toLong() 으로 변환되고 더해진다.
    // 디컴파일 해보니까 .toLong() --> (long)intVar (java file)
    val longSum = 3L + intVar
}

fun getBinaryString() {
    val binary: String = 42.toString(2)

    if (binary == "101010") {
        println("42 is 101010")
    } else {
        println("42 is not 101010")
    }

}

// 소수점 있는 자료형은 안됨 (Double, Float)
// 숫자를 2,3,8,10 진법으로 출력하기
fun printNumberAsString(number: Int) {
    val binary: String = number.toString(2)
    val ternary: String = number.toString(3)
    val octa: String = number.toString(8)
    val decimal: String = number.toString(10)
    val string: String = number.toString()

    println("binary : $binary")
    println("ternary : $ternary")
    println("octa : $octa")
    println("decimal : $decimal")
    println("string : $string")
}

fun printAllRadixByNumber(number: Int) {
    (Character.MIN_RADIX..Character.MAX_RADIX).forEach { radix ->
        println("$radix: ${number.toString(radix)}")
    }
}

fun intPow(number: Int, time: Int) {
//    var result: Int? = number.toDouble().pow(time).toInt()
//    result = null

    val result: Int = number.toDouble().pow(time).toInt()


    println("$number^$time=${number.toDouble().pow(time).toInt()}")
    println("$result")
}


// 확장함수
// infix 함수는 두개의 변수 사이에 오는 함수를 정의한다.
// ex) <val1> infix fun <val2>
infix fun Int.`**`(x: Int) = toDouble().pow(x).toInt()
infix fun Long.`**`(x: Int) = toDouble().pow(x).toLong()
infix fun Double.`**`(x: Int) = pow(x)
infix fun Float.`**`(x: Int) = pow(x)


fun doubleToInt(number: Double) {
    val intVal: Int = number.toInt()
    println("$number -> $intVal (double)->(int)")
}

fun infixPowTest() {
    println("2 `**` 0 = ${2 `**` 0}")
    println("2 `**` 1 = ${2 `**` 1}")
    println("2 `**` 2 = ${2 `**` 2}")
}

fun shiftExample(number: Int, shiftIdx: Int) {

    println(
        "left shifts >> $number shl $shiftIdx " +
                "= ${number shl shiftIdx} (${(number shl shiftIdx).toString(2)})"
    )

    println(
        "right shifts >> $number shr $shiftIdx " +
                "= ${number shr shiftIdx} (${(number shr shiftIdx).toString(2)})"
    )

    println(
        "unsigned right shifts >> $number ushr $shiftIdx " +
                "= ${number ushr shiftIdx} (${(number ushr shiftIdx).toString(2)})"
    )
}

fun getMiddleNumber() {
    val high = (0.99 * Int.MAX_VALUE).toInt()
    val low = (0.75 * Int.MAX_VALUE).toInt()

    val mid1 = (high + low) / 2
    val mid2 = (high + low) ushr 1


    println("mid1 $mid1 (${mid1.toString(2)})(${mid1 !in low..high})")
    println("mid2 $mid2 (${mid2.toString(2)})(${mid2 in low..high})")
}

fun bitMaskExample() {
    val n1 = 0b0000_1100        // 십진수 12
    val n2 = 0b0001_1001        // 십진수 25

    val n1_and_n2 = n1 and n2
    val n1_or_n2 = n1 or n2
    val n1_xor_n2 = n1 xor n2

    println("n1_and_n2 : $n1_and_n2")   // 0b0000_1000  -> 8
    println("n1_or_n2 : $n1_or_n2")     // 0b0001_1101  -> 29
    println("n1_xor_n2 : $n1_xor_n2")   // 0b0001_0101  -> 21
}

fun createMapUsingInfixToFunction() {
    val map = mapOf("a" to 1, "b" to 2, "c" to 2)
    println("map $map")
}

fun createAPairFromConstructVsToFunction() {
    val p1 = Pair("a", 1)
    val p2 = "a" to 1
    println("p1 first: ${p1.first}, second: ${p1.second}")
    println("p2 first: ${p2.first}, second: ${p2.second}")
}

fun destructuringAPair() {
    val pair = "a" to 1
    val (x, y) = pair

    if (x == "a") {
        println("x is a")
    } else {
        println("x is not a")
    }

    if (y == 1) {
        println("y is 1")
    } else {
        println("y is not 1")
    }
}