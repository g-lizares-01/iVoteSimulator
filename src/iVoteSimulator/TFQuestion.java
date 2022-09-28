package iVoteSimulator;
import java.util.ArrayList;

public class TFQuestion implements QuestionInterface {
	private String tfq;
	private ArrayList<String> tfqChoices;
	
	//Only one correct answer, out of 2 choices (yes/no or true/false)
	public boolean isSCQuestion()
	{
		return true;
	}
	
	public boolean isTFQuestion()
	{
		return true;
	}
	
	public TFQuestion()
	{
		this.tfq = "";
		this.tfqChoices = new ArrayList<String>();
	}
	
	public TFQuestion(String tfq, ArrayList<String> tfqChoices)
	{
		this.tfq = tfq;
		this.tfqChoices = tfqChoices;
	}
	
	public void setQuestion(String tfq)
	{
		this.tfq = tfq;
	}
	
	public String getQuestion()
	{
		return tfq;
	}
	
	public void setChoices(ArrayList<String> tfqChoices)
	{
		this.tfqChoices = tfqChoices;
	}
	
	
	public ArrayList<String> getChoices()
	{
		return tfqChoices;
		
	}
	
	public void displayPrompt(int numOfChoices)
	{
		System.out.println("\nThe students will be responding to a True or False Question.\n");
		System.out.println("Students will have two answers to select from.\n");
	}
	
	public void displayChoices(ArrayList<String> tfqChoices, int numOfChoices) 
	{
		for(int i = 0; i < numOfChoices; i++)
		{
			if(i == 0)
				System.out.println(tfqChoices.get(i) + ": True");
			else if(i == 1)
				System.out.println(tfqChoices.get(i) + ": False");
		}
	}
	
	public void displayQuestion()
	{
		System.out.println(getQuestion());
	}
	
}
