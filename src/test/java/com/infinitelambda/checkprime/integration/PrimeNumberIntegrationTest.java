package com.infinitelambda.checkprime.integration;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PrimeNumberIntegrationTest {

	@LocalServerPort
	private int port;

	private String uri;

	@PostConstruct
	public void init() {
		uri = "http://localhost:" + port;
	}

	@Test
	public void checkPrimeEndpoint_whenTheNumberIsBelowZero_theResponseIsNotAcceptable() {
		get(uri + "/prime-number/check/-5").then()
		.assertThat()
		.statusCode(is(equalTo(HttpStatus.NOT_ACCEPTABLE.value())))
		.body("fieldName", hasItem("checkNumberForPrime.inputNumber"))
		.body("message", hasItem("must be greater than or equal to 0"));
	}
	
	@Test
	public void nextPrimeEndpoint_whenTheNumberIsBelowZero_theResponseIsNotAcceptable() {
		get(uri + "/prime-number/next/-5").then()
		.assertThat()
		.statusCode(is(equalTo(HttpStatus.NOT_ACCEPTABLE.value())))
		.body("fieldName", hasItem("getNextPrime.inputNumber"))
		.body("message", hasItem("must be greater than or equal to 0"));
	}

	@Test
	public void checkPrimeEndpoint_whenNumberIsMissing_theResponseIsNotFound() {
		get(uri + "/prime-number/check/").then()
		.assertThat()
		.statusCode(is(equalTo(HttpStatus.NOT_FOUND.value())));
	}
	
	@Test
	public void nextkPrimeEndpoint_whenNumberIsMissing_theResponseIsNotFound() {
		get(uri + "/prime-number/next/").then()
		.assertThat()
		.statusCode(is(equalTo(HttpStatus.NOT_FOUND.value())));
	}

	@Test
	public void checkPrimeEndpoint_whenTheNumberIsPrime_theResponseIsOkAndThereIsBody() {
		get(uri + "/prime-number/check/5").then()
		.assertThat()
		.statusCode(is(equalTo(HttpStatus.OK.value())))
		.body("inputedNumber", is(equalTo(5)))
		.body("isPrime", is(equalTo(true)));
	}
	
	@Test
	public void nextPrimeEndpoint_whenTheNumberIsPrime_theResponseIsOkAndThereIsBody() {
		get(uri + "/prime-number/next/5").then()
		.assertThat()
		.statusCode(is(equalTo(HttpStatus.OK.value())))
		.body("inputedNumber", is(equalTo(5)))
		.body("nextPrime", is(equalTo(5)));
	}

	@Test
	public void checkPrimeEndpoint_whenTheNumberIsTooBig_theResponseIsBadRequest() {
		get(uri + "/prime-number/check/65747564869").then()
		.assertThat()
		.statusCode(is(equalTo(HttpStatus.BAD_REQUEST.value())));
	}
	
	@Test
	public void nextPrimeEndpoint_whenTheNumberIsTooBig_theResponseIsBadRequest() {
		get(uri + "/prime-number/next/65747564869").then()
		.assertThat()
		.statusCode(is(equalTo(HttpStatus.BAD_REQUEST.value())));
	}

	@Test
	public void checkPrimeEndpoint_whenTheNumberIsNotPrime_theResponseIsOkAndThereIsBody() {
		get(uri + "/prime-number/check/9").then()
		.assertThat()
		.statusCode(is(equalTo(HttpStatus.OK.value())))
		.body("inputedNumber", is(equalTo(9)))
		.body("isPrime", is(equalTo(false)));
	}
	
	@Test
	public void nextPrimeEndpoint_whenTheNumberIsNotPrime_theResponseIsOkAndThereIsBody() {
		get(uri + "/prime-number/next/9").then()
		.assertThat()
		.statusCode(is(equalTo(HttpStatus.OK.value())))
		.body("inputedNumber", is(equalTo(9)))
		.body("nextPrime", is(equalTo(11)));
	}

}
