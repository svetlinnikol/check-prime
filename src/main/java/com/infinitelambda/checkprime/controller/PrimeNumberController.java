package com.infinitelambda.checkprime.controller;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinitelambda.checkprime.controller.errorhandle.SimpleFieldError;
import com.infinitelambda.checkprime.model.IsPrimeResult;
import com.infinitelambda.checkprime.model.NextPrimeResult;
import com.infinitelambda.checkprime.service.PrimeNumberService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.jcip.annotations.ThreadSafe;

/**
 * Rest controller for checking if a number is prime and providing next prime.
 */
@RestController
@RequestMapping("prime-number")
@Validated
@ThreadSafe
public class PrimeNumberController {

	private final PrimeNumberService primeNumberService;

	@Autowired
	public PrimeNumberController(PrimeNumberService primeNumberService) {
		this.primeNumberService = primeNumberService;
	}

	@ApiOperation(value = "Check if number is prime.")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Shows if the number is prime.", response = IsPrimeResult.class),
		@ApiResponse(code = 406, message = "The inputed number is smaller than allowed", response = SimpleFieldError.class)
	})
	@GetMapping("/check/{number}")
	public IsPrimeResult checkNumberForPrime(@Min(0) @PathVariable("number") int inputNumber) {
		return primeNumberService.checkNumberForPrime(inputNumber);
	}

	@ApiOperation(value = "Returns next prime number or same if input is prime")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Returns prime number", response = NextPrimeResult.class),
		@ApiResponse(code = 406, message = "The inputed number is smaller than allowed", response = SimpleFieldError.class)
	})
	@GetMapping("/next/{number}")
	public NextPrimeResult getNextPrime(@Min(0) @PathVariable("number") int inputNumber) {
		return primeNumberService.nextPrime(inputNumber);
	}
}