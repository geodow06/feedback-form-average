package com.qa.average.service;

import java.util.List;

import com.qa.gateway.persistence.domain.FeedbackFormTrainee;

public interface AverageService {
	
	public List<Double> getValue(List<FeedbackFormTrainee> forms);

}
