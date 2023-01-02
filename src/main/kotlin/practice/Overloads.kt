package practice

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.text.NumberFormat

@JvmOverloads
fun addProduct(name:String, price: Double = 0.0, desc: String? = null) =
    "Adding product with $name, ${desc ?: "None"}, and " +
            NumberFormat.getCurrencyInstance().format(price)

// 메서드 오버로딩
// 자바에서 메서드 오버로딩을 사용하려면 코틀린 함수에 @JvmOverloads 추가하면 된다.
@Test
fun `check all overloads`(){
    Assertions.assertAll("Overloads called from Kotlin",
        { println(addProduct("Name", 5.0, "Desc")) },
        { println(addProduct("Name", 5.0)) },
        { println(addProduct("Name")) }
    )
}

// 생성자 오버로딩
// constructor 키워드를 명시해야한다.
// 상위 클래스의 유사한 생성자를 호출하지 않고 가장 파라미터가 많은 생성자를 호출한다.
data class Product @JvmOverloads constructor(
    val name: String,
    val price: Double = 0.0,
    val desc: String? = null
)