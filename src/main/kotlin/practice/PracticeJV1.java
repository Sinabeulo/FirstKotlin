package practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

public class PracticeJV1 {
    @Test
    void supplyAllArguments() {
        System.out.println(OverloadsKt.addProduct("Name"));
        System.out.println(OverloadsKt.addProduct("Name", 5.0));
        System.out.println(OverloadsKt.addProduct("Name", 111, "Uhmm..."));

        // Practice1Kt 무조건 앞글자 대문자로 생성됨
    }

    @Test
    void checkOverloadedProductCtor() {
        assertAll("overloads called from Java",
                () -> System.out.println(new Product("A Name", 8.0, "Well")),
                () -> System.out.println(new Product("A Name", 8.0)),
                () -> System.out.println(new Product("A Name"))
        );
    }
}
