package com.qa.average.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.qa.gateway.persistence.domain.FeedbackFormTrainee;

public class AverageServiceImpl implements AverageService {

	@Override
	public List<Double> getValue(List<FeedbackFormTrainee> forms) {
		ArrayList<ArrayList<Integer>> listListing = new ArrayList<ArrayList<Integer>>();
		int maxCount = 1;
		for (FeedbackFormTrainee form : forms) {
			if (form.getFormCount() > maxCount) {
				maxCount = form.getFormCount();
			}
		}
		for (int i = 0; i < maxCount; i++) {
			listListing.add(new ArrayList<Integer>());
		}
		for (FeedbackFormTrainee form : forms) {
			listListing.get(form.getFormCount() - 1).add(form.getScore());
		}
		List<Double> result = Arrays.asList(new Double[listListing.size()]);
		for (int i = 0; i < listListing.size(); i++) {
			ArrayList<Integer> list = listListing.get(i);
			double total = 0;
			for (Integer n : list) {
				total += (double) n;
			}
			result.set(i, total / ((double) list.size()));
		}
		return result;
	}

}
