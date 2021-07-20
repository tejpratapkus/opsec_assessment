package com.opsec.assessment.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.opsec.assessment.TestUtils;
import com.opsec.assessment.request.UserRequest;
import com.opsec.assessment.response.ApplicationResponse;
import com.opsec.assessment.service.IUserService;

@SpringBootTest
public class UserControllerTest {


	@InjectMocks
	private UserController controller;

	@Mock
	private IUserService service;

	@Test
	void test_createUser() {
		UserRequest request = TestUtils.getUserRequest();
		ApplicationResponse response = new ApplicationResponse(true, "Success", null);
		ResponseEntity<ApplicationResponse> responseEntity = null;
		Mockito.when(service.createUser(request)).thenReturn(response);
		responseEntity = controller.createUser(request);
		assertEquals(true, responseEntity.getBody().isStatus());
	}

	@Test
	void test_getUserById() {

		ApplicationResponse response = new ApplicationResponse(true, "Success", null);
		ResponseEntity<ApplicationResponse> responseEntity = null;
		Mockito.when(service.getUsers("1")).thenReturn(response);
		responseEntity = controller.getUsers("1");
		assertEquals(true, responseEntity.getBody().isStatus());
	}

	@Test
	void test_getUsers() {

		ApplicationResponse response = new ApplicationResponse(true, "Success", null);
		ResponseEntity<ApplicationResponse> responseEntity = null;
		Mockito.when(service.getUsers(null)).thenReturn(response);
		responseEntity = controller.getUsers(null);
		assertEquals(true, responseEntity.getBody().isStatus());
	}

	@Test
	void test_getUsersFalse() {

		ApplicationResponse response = new ApplicationResponse(true, "Success", null);
		ResponseEntity<ApplicationResponse> responseEntity = null;
		Mockito.when(service.getUsers(null)).thenReturn(response);
		responseEntity = controller.getUsers(null);
		assertEquals(true, responseEntity.getBody().isStatus());
	}

	@Test
	void test_updateUser() {

		UserRequest request = TestUtils.getUserRequest();
		ApplicationResponse response = new ApplicationResponse(true, "Success", null);
		ResponseEntity<ApplicationResponse> responseEntity = null;
		Mockito.when(service.updateUser("1", request)).thenReturn(response);
		responseEntity = controller.updateUser("1", request);
		assertEquals(true, responseEntity.getBody().isStatus());
	}

	@Test
	void test_deleteUser() {

		ApplicationResponse response = new ApplicationResponse(true, "Success", null);
		ResponseEntity<ApplicationResponse> responseEntity = null;
		Mockito.when(service.deleteUser("1")).thenReturn(response);
		responseEntity = controller.deleteUser("1");
		assertEquals(true, responseEntity.getBody().isStatus());
	}


}
