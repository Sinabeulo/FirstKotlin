package practice

// 3.1 const와 val의 차이
class Task(val name: String, _priority: Int = DEFAULT_PRIORITY) {
    companion object {
        // 코틀린에서 상수 (const) 를 사용하는 방법은 val 과 같이 사용해야한다.
        // const는 private, inline 과 같은 변경자이기 때문이다.
        const val MIN_PRIORITY = 1
        const val MAX_PRIORITY = 5
        const val DEFAULT_PRIORITY = 3
    }

    var priority = validPriority(_priority)
        set(value) {
            field = validPriority(value)
        }

    private fun validPriority(p: Int) = p.coerceIn(MIN_PRIORITY, MAX_PRIORITY)
}

// 3.2 사용자 정의 획득자와 설정자 생성하기 (속성에 get, set 함수 추가)
// 코틀린은 기본적으로 public이다.
class Task3_2(val name: String, var description: String) {
    var priority = 3
        set(value) {
            // field 식별자는 오직 사용자 정의 획득자나 설정자에서만 사용할 수 있다.
            field = value.coerceIn(1..9)
        }

    val isLowPriority
        get() = priority < 3

}

fun testCodeForTask3_2() {
    val task = Task3_2("practice", "description")
    task.description = "description2"
//    task.apply { priority = 13 }
    task.priority = 11

    println("task.priority : ${task.priority}")
}

class Building(val name: String, _residents: Int = 0, val area: Double) {
    var residents = _residents      // 초기화
        set(value) {
            // 속성 할당
            println("set...")
            field = value.coerceIn(1..100)
        }
}

fun testCodeForBuilding() {
    val building = Building("B123", 123, 123.0)
    println("building.residents > ${building.residents}")
    building.residents = 124
    println("building.residents > ${building.residents}")
}

// 3.4 데이터 클래스 정의
data class Duck(
    val name:String,
    var age: Int,
    var isHungry : Boolean = false
)

data class KingOfDuck(
    val duck: Duck, val nation: String
)

fun testCodeForDuck(){
    val d1 = Duck("Thunder", 12)
    val d2 = Duck("Thunder", 12)

    if(d1.equals(d2)){
        println("d1 equal with d2")
    }else{
        println("d1 not equal with d2")
    }

    if(d1.hashCode().equals(d2.hashCode())){
        println("hashcode d1 equal with d2")
    }else{
        println("hashcode d1 not equal with d2")
    }

    println("d1.toString() ${d1.toString()}")

    val d3 = d1.copy(age=12)    // copy 함수는 깊은 복사가 아닌 얕은 복사를 수행한다.

    // 동일한 데이터는 추가되지 않는다. 하지만 객체는 각각 다르다.
    val products = setOf(d1,d2,d3)
    println("products size : ${products.size}")

    println("d1 == d2: ${d1 == d2}, d1 === d2: ${d1 === d2}")




    val king1 = KingOfDuck(d1, "Atlantis")
    val king2 = king1.copy()

    println("king1 == king2: ${king1 == king2}, king1 === king2: ${king1 === king2}")
    println("king1.duck == king2.duck: ${king1.duck == king2.duck}, king1.duck === king2.duck: ${king1.duck === king2.duck}")
}

fun destructureUsingComponentFunctions(){
    val d1 = Duck("Sun",10000)
    val (name, age) = d1

    println("name: ${name}, age: ${age}")

}