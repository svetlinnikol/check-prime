package com.infinitelambda.checkprime.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.infinitelambda.checkprime.service.PrimeNumberService;

@RunWith(MockitoJUnitRunner.class)
public class PrimeNumberControllerTest {

	@Mock
	private PrimeNumberService primeNumberService;

	@InjectMocks
	private PrimeNumberController primeNumberController;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(primeNumberController).build();
	}

	@Test
	public void checkPrime_whenNumberIsNotPresent_returnedStatusIsNotFound() throws Exception {
		 mockMvc.perform(get("/prime-number/check/")
				 .accept(MediaType.APPLICATION_JSON))
		 .andExpect(status().isNotFound());
	}

	@Test
	public void nextPrime_whenNumberIsNotPresent_returnedStatusIsNotFound() throws Exception {
		 mockMvc.perform(get("/prime-number/next/")
				 .accept(MediaType.APPLICATION_JSON))
		 .andExpect(status().isNotFound());
	}

	@Test
	public void checkPrime_whenAllValidationsPasses_thereIsResult() throws Exception {
		 mockMvc.perform(get("/prime-number/check/5")
				 .accept(MediaType.APPLICATION_JSON))
		 .andExpect(status().isOk());
	}

	@Test
	public void nextPrime_whenAllValidationsPasses_thereIsResult() throws Exception {
		 mockMvc.perform(get("/prime-number/next/5")
				 .accept(MediaType.APPLICATION_JSON))
		 .andExpect(status().isOk());
	}
}