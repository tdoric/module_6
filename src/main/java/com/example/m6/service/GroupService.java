package com.example.m6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.m1.dao.GroupDao;
import com.example.m1.model.Group;
import com.example.m6.exception.ErrorExc;
import com.example.m6.request.CreateGroupRequest;
import com.example.m6.response.CreateGroupResponse;

@Service
public class GroupService {
	
	@Autowired
	GroupDao groupDao;
	
	
	public ResponseEntity<CreateGroupResponse> processCreateGroup(Integer userId,CreateGroupRequest request) throws ErrorExc{
		Group group = new Group();
		group.setUserId(userId);
		group.setGroupname(request.getGroupname());
		try {
			groupDao.createGroup(group);
		}catch (DuplicateKeyException e) {
			throw new ErrorExc("Group exist!");
		}
		
		return ResponseEntity.ok(new CreateGroupResponse("Crate group successfully!"));
	}

}
