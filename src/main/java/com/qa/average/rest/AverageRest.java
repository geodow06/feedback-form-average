package com.qa.average.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qa.average.service.AverageService;
import com.qa.gateway.persistence.domain.FeedbackFormTrainee;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class AverageRest {
	private AverageService src;
	
	@PostMapping("/getValue")
	public List<Double> getValue(List<FeedbackFormTrainee> forms){
		return src.getValue(forms);
	}
}
