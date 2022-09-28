package iVoteSimulator;
import java.util.ArrayList;

public interface QuestionInterface {
	
	//Helps determine how many answers to record per student
	public boolean isSCQuestion();
	
	//Helps determine method of selecting answers for T/F questions
	public boolean isTFQuestion();
	
	//Set question
	public void setQuestion(String q);
	
	//Retrieve question
	public String getQuestion();
	
	//Set answer choices
	public void setChoices(ArrayList<String> a);
	
	//Retrieve answer choices
	public ArrayList<String> getChoices();
	
	//Display various components of the question
	public void displayPrompt(int num);
	
	public void displayChoices(ArrayList<String> cl, int num);
	
	public void displayQuestion();
	
}
