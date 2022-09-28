package iVoteSimulator;

import java.util.ArrayList;
import java.util.Collections;

public class SCAnswers implements AnswerInterface {
	private ArrayList<String> scqChoices;
	public ArrayList<String> createStudentAnswer(QuestionInterface q)
	{
		//Create temporary list of answer choices to generate student answer
		scqChoices = q.getChoices();
		ArrayList<String> temp = scqChoices;
		
		//Determine whether or not to shuffle choices for T/F questions
		if(q.isTFQuestion())
		{
			int rndm = (int)(Math.round(Math.random()));
			if(rndm == 0)
				Collections.shuffle(temp);
		}
		else
			Collections.shuffle(temp);
		
		//System.out.println(temp);
		
		ArrayList<String> studentAnswer = new ArrayList<String>();		//New ArrayList to hold student answer

		//Student's answer is the first entry in temp
		studentAnswer.add(temp.get(0));
		
		return studentAnswer;
	}
}
