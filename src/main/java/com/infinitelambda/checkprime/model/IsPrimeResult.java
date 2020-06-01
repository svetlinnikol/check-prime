package com.infinitelambda.checkprime.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import net.jcip.annotations.ThreadSafe;

/**
 * Result of the checkPrime endpoint.
 */
@ThreadSafe
@JsonPropertyOrder({ "inputedNumber", "isPrime" })
public class IsPrimeResult {
	
	private final int inputedNumber;
	private final boolean isPrime;

	public IsPrimeResult(int inputedNumber, boolean isPrime) {
		this.inputedNumber = inputedNumber;
		this.isPrime = isPrime;
	}

	public int getInputedNumber() {
		return inputedNumber;
	}

	@JsonProperty("isPrime")
	public boolean isPrime() {
		return isPrime;
	}
}
