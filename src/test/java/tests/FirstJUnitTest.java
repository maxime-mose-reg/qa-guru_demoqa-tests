package tests;

import org.junit.jupiter.api.*;

public class FirstJUnitTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Этот метод выполняется перед всеми тестами.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Этот метод выполняется после всех тестов.");
    }

    @BeforeEach
    void before() {
        System.out.println("    Этот метод выполняется перед каждым тестом.");
    }

    @AfterEach
    void after() {
        System.out.println("    Этот метод выполняется после каждого теста.");
    }

    @Test
    void firstTest() {
        System.out.println("        Этот первый тест.");
    }

    @Test
    void secondTest() {
        System.out.println("        Этот второй тест.");
    }
}
