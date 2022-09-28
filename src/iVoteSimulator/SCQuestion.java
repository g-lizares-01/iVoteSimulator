package iVoteSimulator;
import java.util.ArrayList;

//For questions with one correct answer
public class SCQuestion implements QuestionInterface {

	private String scq;
	private ArrayList<String> scqChoices;
	
	//Only one correct answer, out of multiple choices
	public boolean isSCQuestion()
	{
		return true;
	}

	public boolean isTFQuestion()
	{
		return false;
	}
	
	public SCQuestion()
	{
		this.scq = "";
		this.scqChoices = new ArrayList<String>();
	}
	
	public SCQuestion(String scq, ArrayList<String> scqChoices)
	{
		this.scq = scq;
		this.scqChoices = scqChoices;
	}
	
	public void setQuestion(String scq)
	{
		this.scq = scq;
	}
	
	public String getQuestion()
	{
		return scq;
	}
	
	public void setChoices(ArrayList<String> scqChoices)
	{
		this.scqChoices = scqChoices;
	}
	
	
	public ArrayList<String> getChoices()
	{
		return scqChoices;
		
	}
	
	public void displayPrompt(int numOfChoices)
	{
		System.out.println("\nThe students will be responding to a Single Choice Question.\n");
		System.out.println("Students will have " + numOfChoices + " answers to select from.\n");
	}
	
	public void displayChoices(ArrayList<String> scqChoices, int numOfChoices) 
	{
		for(int i = 0; i < numOfChoices; i++)
		{
			if(i < (numOfChoices - 2))
				System.out.print(scqChoices.get(i) + ", ");
			else if(i == (numOfChoices - 2))
				System.out.println(scqChoices.get(i) + ", or " + scqChoices.get(i + 1));
		}
	}
	
	public void displayQuestion()
	{
		System.out.println(getQuestion());
	}
	
}
