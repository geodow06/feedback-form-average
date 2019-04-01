package com.qa.average.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.average.service.AverageService;
import com.qa.gateway.persistence.domain.FeedbackFormTrainee;

@CrossOrigin
@RestController
public class AverageRest {
	
	@Autowired
	private AverageService src;
	
	@PostMapping("/getValue")
	public List<Double> getValue(@RequestBody List<FeedbackFormTrainee> forms){
		return src.getValue(forms);
	}
}
