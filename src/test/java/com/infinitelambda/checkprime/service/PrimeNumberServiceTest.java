package com.infinitelambda.checkprime.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.infinitelambda.checkprime.model.IsPrimeResult;
import com.infinitelambda.checkprime.model.NextPrimeResult;

@RunWith(MockitoJUnitRunner.class)
public class PrimeNumberServiceTest {

	@InjectMocks
	private PrimeNumberService primeNumberService;

	@Test
	public void checkPrime_whenNumberIsNotPrime_itReturnsObjectWithFalse() {
		int inputedNumber = 25;
		IsPrimeResult result = primeNumberService.checkNumberForPrime(inputedNumber);
		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(false, result.isPrime());
	}

	@Test
	public void checkPrime_whenNumberIsPrime_itReturnsObjectWithTrue() {
		int inputedNumber = 7;
		IsPrimeResult result = primeNumberService.checkNumberForPrime(inputedNumber);
		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(true, result.isPrime());
	}

	@Test
	public void checkPrime_whenNumberIsDivisibleByTwo_itReturnsObjectWithFalse() {
		int inputedNumber = 4;
		IsPrimeResult result = primeNumberService.checkNumberForPrime(inputedNumber);
		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(false, result.isPrime());
	}

	@Test
	public void checkPrime_whenNumberIsDivisibleByThree_itReturnsObjectWithFalse() {
		int inputedNumber = 9;
		IsPrimeResult result = primeNumberService.checkNumberForPrime(inputedNumber);
		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(false, result.isPrime());
	}
	
	@Test
	public void checkPrime_whenNumberIsNotPrimeAndFoundViaIPlusTwoCase_itReturnsObjectWithFalse() {
		int inputedNumber = 49;
		IsPrimeResult result = primeNumberService.checkNumberForPrime(inputedNumber);
		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(false, result.isPrime());
	}

	@Test
	public void checkPrime_whenNumberIsZero_itReturnsObjectWithFalse() {
		int inputedNumber = 0;
		IsPrimeResult result = primeNumberService.checkNumberForPrime(inputedNumber);
		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(false, result.isPrime());
	}

	@Test
	public void checkPrime_whenNumberIsOne_itReturnsObjectWithFalse() {
		int inputedNumber = 1;
		IsPrimeResult result = primeNumberService.checkNumberForPrime(inputedNumber);
		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(false, result.isPrime());
	}

	@Test
	public void checkPrime_whenNumberIsTwo_itReturnsObjectWithTrue() {
		int inputedNumber = 2;
		IsPrimeResult result = primeNumberService.checkNumberForPrime(inputedNumber);
		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(true, result.isPrime());
	}

	@Test
	public void checkPrime_whenNumberIsThree_itReturnsObjectWithTrue() {
		int inputedNumber = 3;
		IsPrimeResult result = primeNumberService.checkNumberForPrime(inputedNumber);
		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(true, result.isPrime());
	}

	@Test
	public void checkPrime_whenNumberIsIntegerMaxSize_itReturnsObjectWithTrue() {
		int inputedNumber = Integer.MAX_VALUE;
		IsPrimeResult result = primeNumberService.checkNumberForPrime(inputedNumber);
		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(true, result.isPrime());
	}

	@Test
	public void nextPrime_whenNumberIsZero_itReturnsObjectWithTwo() {
		int inputedNumber = 0;
		long expectedResult = 2l;
		NextPrimeResult result = primeNumberService.nextPrime(inputedNumber);
		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(expectedResult, result.getNextPrime());
	}

	@Test
	public void nextPrime_whenNumberIsOne_itReturnsObjectWithTwo() {
		int inputedNumber = 1;
		long expectedResult = 2l;
		NextPrimeResult result = primeNumberService.nextPrime(inputedNumber);
		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(expectedResult, result.getNextPrime());
	}

	@Test
	public void nextPrime_whenNumberIsPrime_itReturnsObjectWithSameNumber() {
		int inputedNumber = 2;
		long expectedResult = 2l;
		NextPrimeResult result = primeNumberService.nextPrime(inputedNumber);
		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(expectedResult, result.getNextPrime());
	}

	@Test
	public void nextPrime_whenNumberIsNotPrimeAndItIsEven_itReturnsObjectWithNextPrime() {
		int inputedNumber = 4;
		long expectedResult = 5l;
		NextPrimeResult result = primeNumberService.nextPrime(inputedNumber);
		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(expectedResult, result.getNextPrime());
	}

	@Test
	public void nextPrime_whenNumberIsNotPrimeAndItIsOdd_itReturnsObjectWithNextPrime() {
		int inputedNumber = 15;
		long expectedResult = 17l;
		NextPrimeResult result = primeNumberService.nextPrime(inputedNumber);
		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(expectedResult, result.getNextPrime());
	}

	@Test
	public void nextPrime_whenNumberIsNotPrime_itReturnsObjectWithNextPrime() {
		int inputedNumber = 25;
		long expectedResult = 29l;
		NextPrimeResult result = primeNumberService.nextPrime(inputedNumber);
		assertEquals(inputedNumber, result.getInputedNumber());
		assertEquals(expectedResult, result.getNextPrime());
	}

}
