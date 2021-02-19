package com.example.m6.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.m4.services.UserDetailsImpl;
import com.example.m6.request.CreateGroupRequest;
import com.example.m6.response.CreateGroupResponse;
import com.example.m6.service.GroupService;

@RestController
@RequestMapping("/api")
public class GroupController {
	

	@Autowired
	GroupService groupService;
	
	@PostMapping("/create")
	public ResponseEntity<CreateGroupResponse> registerUser(@Valid @RequestBody CreateGroupRequest request) {
		UserDetailsImpl user = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return groupService.processCreateGroup(user.getId(), request);
	}


}
