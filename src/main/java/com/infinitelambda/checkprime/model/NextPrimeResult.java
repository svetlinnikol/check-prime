package com.infinitelambda.checkprime.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import net.jcip.annotations.ThreadSafe;

/**
 * Result of the get next prime endpoint.
 */
@ThreadSafe
@JsonPropertyOrder({ "inputedNumber", "nextPrime" })
public class NextPrimeResult {

	private final int inputedNumber;
	private final long nextPrime;

	public NextPrimeResult(int inputedNumber, long nextPrime) {
		this.inputedNumber = inputedNumber;
		this.nextPrime = nextPrime;
	}

	public int getInputedNumber() {
		return inputedNumber;
	}

	public long getNextPrime() {
		return nextPrime;
	}
}
