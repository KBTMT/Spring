package com.service.spring.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.model.TestDAO;
import com.service.spring.model.TestService;

@Service
public class TestServiceImpl implements TestService{
 
	@Autowired
	private TestDAO testDAO;
}
