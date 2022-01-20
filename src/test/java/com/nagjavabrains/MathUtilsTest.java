package com.nagjavabrains;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
/**
 * 
 * @author nageswararaomothukuri
 *
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("MathUtils methods testing")
class MathUtilsTest {

	private MathUtils mathUtils;

	@BeforeAll
	void beforeAllMethod() {
		System.out.print("This needs to be called before All");
	}

	@BeforeEach
	void init() {
		mathUtils = new MathUtils();
	}

	@Nested
	@DisplayName("When Add methods test")
	class AddMethodsTest {

		@Test
		@DisplayName("Positive Numbers Testing")
		void positiveNumbersTesting() {
			assertEquals(4, mathUtils.sumOfNumbers(2, 2));
		}

		@Test
		@DisplayName("Negative Numbers Testing")
		void negativeNumbersTesting() {
			int expected = -4;
			int actual = mathUtils.sumOfNumbers(-2, -2);
			assertEquals(expected, actual,
					() -> "Should retrun the value:" + expected + " But retruned the value" + actual);
		}

	}

	@Test
	@Tag("Add")
	void testAdd() {

		int expected = 2;
		int actulaResult = mathUtils.sumOfNumbers(1, 1);
		assertEquals(expected, actulaResult, "Return the sum of the two numbers");

	}

	// @RepeatedTest(4)
	// void testCircleRadiusCalculation(RepetitionInfo repetitionInfo) {
	@Tag("CircleRadius")
	@Test
	void testCircleRadiusCalculation() {

		double actual = mathUtils.calculateCirleRadius(1);

		double expected = Math.PI;
		assertEquals(expected, actual, "Calculate the circle Radius");

	}

	@Test
	// @EnabledOnOs(OS.LINUX)
	void testDivideNumbers() {

		boolean isServerUp = false;

		Assumptions.assumeTrue(isServerUp);

		assertThrows(ArithmeticException.class, () -> mathUtils.divideNumbers(1, 0));

	}

	@Test
	@DisplayName("Test method for Display and Disabled annotations")
	@Disabled
	void testDisableAndDisplayNameAnnotations() {

		Assertions.fail("Test fail method to check Diabled and display annotations..");
	}

	@Test
	@DisplayName("Multiply Test method")
	void multiplyTest() {

		Assertions.assertAll(() -> assertEquals(4, mathUtils.multiply(2, 2)),
				() -> assertEquals(9, mathUtils.multiply(3, 3)), () -> assertEquals(-2, mathUtils.multiply(2, -1))

		);

	}
}
