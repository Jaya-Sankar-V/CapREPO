package com.tms.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.tms.user.dto.UserDTO;
import com.tms.user.dto.UserLoginDTO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceApplicationTests {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	private String getBaseUrl() {
		return "http://localhost:" + port + "/user/";
	}

	@Test
	@DisplayName("testing create method")
	void testCreateUser() {
		UserLoginDTO userdto = new UserLoginDTO( "Ned Stark", "Ned@123", "Ned@gmail.com");
		UserLoginDTO response = restTemplate
				.postForEntity(getBaseUrl().concat("createuser"), userdto, UserLoginDTO.class).getBody();

		assertNotNull(response);
		//assertEquals("Ned Stark", response.getUserName());
	}

	@Test
//	@Sql( statements = "insert into users(username,password,email,role) values('john','abc','abc@gmail.com','user');" ,executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
//	@Sql( statements = "delete from users where username='john'")
	void testGetUser()
	{
		UserDTO getResponse = restTemplate.getForEntity(getBaseUrl().concat("getuser/{id}"), UserDTO.class,2).getBody();
		
		assertEquals("John Snow", getResponse.getUserName());
		//assertNotNull(getResponse);
	}

//	@Test
//	void testUpdateUser()
//	{
//		UserDTO getResponse = restTemplate.getForEntity(getBaseUrl().concat("getuser/{id}"), UserDTO.class,2).getBody();
//		getResponse.setUserName("Shri Rama Krishna");
//		
//		//restTemplate.put(getBaseUrl().concat("update/{uid}"), getResponse,UserDTO.class, 2);
//		
//		HttpHeaders headers = new HttpHeaders();
//		HttpEntity<UserDTO> entity = new HttpEntity<UserDTO>(getResponse,headers);
//		
//		UserDTO putResponse = restTemplate.exchange(getBaseUrl().concat("update/{uid}"), HttpMethod.PUT, entity, UserDTO.class, 2).getBody();
//		
//		assertEquals("Shri Rama Krishna", putResponse.getUserName());
//	}

//	@Test
//	void testDeleteUser() {
//	    // Perform the delete operation
//	    ResponseEntity<Void> deleteResponse = restTemplate.exchange(
//	        getBaseUrl().concat("delete/{uid}"),
//	        HttpMethod.DELETE,
//	        null,
//	        Void.class,
//	        19
//	    );
	    //assertNull(deleteResponse);
	    //assertEquals(HttpStatus.NO_CONTENT, deleteResponse.getStatusCode());
	    //System.out.println(deleteResponse.getStatusCode());
//
//	    ResponseEntity<UserDTO> getResponse = restTemplate.getForEntity(
//	        getBaseUrl().concat("getuser/{uid}"),
//	        UserDTO.class,
//	        15
//	    );
//	    assertEquals(HttpStatus.NOT_FOUND, getResponse.getStatusCode());
//	}
}








//package com.tms.user;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.tms.user.controller.UserController;
//import com.tms.user.dto.UserDTO;
//import com.tms.user.dto.UserLoginDTO;
//import com.tms.user.service.UserService;
//
//@SpringBootTest
//public class UserControllerTest {
//
//    @Mock
//    private UserService userService;
//
//    @InjectMocks
//    private UserController userController;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testCreateUser() {
//        // Arrange
//        UserLoginDTO userLoginDTO = new UserLoginDTO("username", "password");
//        UserDTO userDTO = new UserDTO(1L, "username", "email@example.com", "role");
//
//        when(userService.createUser(any(UserLoginDTO.class))).thenReturn(userDTO);
//
//        // Act
//        UserDTO result = userController.createUser(userLoginDTO);
//
//        // Assert
//        assertEquals(userDTO, result);
//        verify(userService).createUser(userLoginDTO);
//    }
//
//    @Test
//    void testGetUserByUid() {
//        // Arrange
//        Long uid = 1L;
//        UserDTO userDTO = new UserDTO(uid, "username", "email@example.com", "role");
//
//        when(userService.getUserByUid(anyLong())).thenReturn(userDTO);
//
//        // Act
//        UserDTO result = userController.getUserByUid(uid);
//
//        // Assert
//        assertEquals(userDTO, result);
//        verify(userService).getUserByUid(uid);
//    }
//
//    @Test
//    void testGetAllUserByUid() {
//        // Arrange
//        List<UserDTO> users = Arrays.asList(
//                new UserDTO(1L, "username1", "email1@example.com", "role1"),
//                new UserDTO(2L, "username2", "email2@example.com", "role2")
//        );
//
//        when(userService.getAllUserByUid()).thenReturn(users);
//
//        // Act
//        List<UserDTO> result = userController.getAllUserByUid();
//
//        // Assert
//        assertEquals(users, result);
//        verify(userService).getAllUserByUid();
//    }
//
//    @Test
//    void testUpdateUser() {
//        // Arrange
//        Long uid = 1L;
//        UserLoginDTO userDTO = new UserLoginDTO("updatedUsername","some random password", "updatedEmail@example.com", "updatedRole");
//
//        when(userService.updateUser(anyLong(), any(UserDTO.class))).thenReturn(userDTO);
//
//        // Act
//        UserDTO result = userController.updateUser(uid, userDTO);
//
//        // Assert
//        assertEquals(userDTO, result);
//        verify(userService).updateUser(uid, userDTO);
//    }
//}


