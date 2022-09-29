package iVoteSimulator;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

public class MCAnswers implements AnswerInterface {
	private ArrayList<String> mcqChoices;
	
	public ArrayList<String> createStudentAnswer(QuestionInterface q)
	{
		//Create temporary list of answer choices to generate student answer
		mcqChoices = q.getChoices();
		ArrayList<String> temp = mcqChoices;
		Collections.shuffle(temp);
		
		ArrayList<String> studentAnswer = new ArrayList<String>();		//New ArrayList to hold student answer
		//Select random number (within # of question's answer choices) of answers for the student to select
		int numOfResponses = (int)(Math.random()*mcqChoices.size()) + 1;

		//Create array of student's answers, then sort the array
		for(int i = 0; i < numOfResponses; i++)
			studentAnswer.add(temp.get(i));
		
		Collections.sort(studentAnswer);
		
		return studentAnswer;
	}
	
}
