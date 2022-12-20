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