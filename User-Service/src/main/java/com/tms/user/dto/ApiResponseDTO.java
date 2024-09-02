package com.tms.user.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data 
public class ApiResponseDTO 
{
	private ProjectDTO projectdto;
	private UserDTO userdto;
	private TaskDTO taskdto;
	private List<ProjectDTO> projectlist;
	
	public ApiResponseDTO(ProjectDTO projectdto, UserDTO userdto, TaskDTO taskdto) {
		super();
		this.projectdto = projectdto;
		this.userdto = userdto;
		this.taskdto = taskdto;
	}
	public ApiResponseDTO(ProjectDTO projectdto, UserDTO userdto) {
		super();
		this.projectdto = projectdto;
		this.userdto = userdto;
	}
	public ApiResponseDTO() {
		super();
	}
	public ApiResponseDTO(ProjectDTO projectdto, UserDTO userdto, TaskDTO taskdto, List<ProjectDTO> projectlist) {
		super();
		this.projectdto = projectdto;
		this.userdto = userdto;
		this.taskdto = taskdto;
		this.projectlist = projectlist;
	}
	
	
	
}
