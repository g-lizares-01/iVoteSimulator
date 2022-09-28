package iVoteSimulator;
import java.util.ArrayList;

public interface AnswerInterface {
	
	//Will generate a student's response to the poll question
	public ArrayList<String> createStudentAnswer(QuestionInterface q);
	
}
