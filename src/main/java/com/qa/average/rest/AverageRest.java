package com.qa.average.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.average.service.AverageService;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class AverageRest {
	private AverageService src;
	private RestTemplate rest;
	
	
}
