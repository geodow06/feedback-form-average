package com.qa.average;

import static org.junit.Assert.assertArrayEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.average.service.AverageServiceImpl;
import com.qa.gateway.persistence.domain.FeedbackFormTrainee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AverageAPIApplicationTests {
	private AverageServiceImpl service;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void serviceTest() {
		service = new AverageServiceImpl();
		double[] expected = {1.5, 2.5};
		FeedbackFormTrainee form1 = new FeedbackFormTrainee();
		FeedbackFormTrainee form2 = new FeedbackFormTrainee();
		FeedbackFormTrainee form3 = new FeedbackFormTrainee();
		FeedbackFormTrainee form4 = new FeedbackFormTrainee();
		form1.setFormCount(1);
		form2.setFormCount(1);
		form3.setFormCount(2);
		form4.setFormCount(2);
		form1.setScore(1);
		form2.setScore(2);
		form3.setScore(2);
		form4.setScore(3);
		List<FeedbackFormTrainee> forms = new ArrayList<FeedbackFormTrainee>();
		forms.add(form1);
		forms.add(form2);
		forms.add(form3);
		forms.add(form4);
		List<Double> rawResults = service.getValue(forms);
		double[] formattedResults = new double[rawResults.size()];
		int i = 0;
		for (Double result : rawResults) {
			formattedResults[i] = (double) result;
			i++;
		}
		assertArrayEquals(expected, formattedResults, 0.001);
	}

}
