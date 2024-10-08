package com.tms.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.user.dto.ApiResponseDTO;
import com.tms.user.dto.UserDTO;
import com.tms.user.dto.UserLoginDTO;
import com.tms.user.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
@Validated
public class UserController 
{
	@Autowired
	private UserService service;
	
	
	@PostMapping("/createuser")
	public UserDTO createUser(@Valid @RequestBody UserLoginDTO userLoginDTO)
	{
		return service.createUser(userLoginDTO);
	}
	
	@GetMapping("/getuser/{userId}")
	public UserDTO getUserByUid(@PathVariable Long userId)
	{
		return service.getUserByUid(userId);
	}
	
	@GetMapping("getalluser")
	public List<UserDTO> getAllUserByUid()
	{
		return service.getAllUserByUid();
	}
	
	@GetMapping("/getuserproject/{userId}")
	public ApiResponseDTO getUserProjectById(@PathVariable Long userId)
	{
		return service.getUserProjectByUid(userId);
	}
	
	@GetMapping("/getpid/{projectId}")
	public List<UserDTO> getUserByPid(@PathVariable Long projectId)
	{
		return service.getUserByProjectId(projectId);
	}
	
	@GetMapping("/email/{email}")
	public UserDTO getUserByEmail(String email)
	{
		return service.getUserByEmail(email);
	}
	
	@PutMapping("/update/{userId}")
	public UserDTO updateUser(@Valid @PathVariable Long userId,@RequestBody UserLoginDTO userDTO)
	{
		return service.updateUser(userId, userDTO);
	}
	
	@PutMapping("/updatetid/{userId}/{taskId}/{projectId}/{taskStatus}")
	public void updateTid(@Valid @PathVariable("userId") Long userId,@PathVariable("taskId") Long taskId,@PathVariable("projectId") Long projectId,@PathVariable String taskStatus)
	{
	    service.updateTid(userId, taskId,projectId,taskStatus);
	}
	
	@DeleteMapping("/delete/{userId}")
	public void deleteUser(@PathVariable Long userId)
	{
		service.deleteUser(userId);
	}
	
	@PutMapping("/updatetstatus/{userId}")
	public void updateTstatus( @PathVariable Long userId,@RequestBody UserDTO userDTO)
	{
		service.updateTstatus(userId, userDTO);
	}
}

