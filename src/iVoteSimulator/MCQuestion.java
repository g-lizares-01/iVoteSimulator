package iVoteSimulator;

//Questions with multiple answers
//public class MCQuestion implements QuestionInterface {
//	
//	private String mcq;
//	private String[] mcqChoices;
//	
//	//MCQuestion != SQQuestion
//	public boolean isSCQuestion()
//	{
//		return false;
//	}
//	
//	public MCQuestion()
//	{
//		this.mcq = "";
//		this.mcqChoices = new String[0];
//	}
//	
//	public MCQuestion(String mcq, String[] mcqChoices)
//	{
//		this.mcq = mcq;
//		this.mcqChoices = mcqChoices;
//	}
//	
//	public void setQuestion(String mcq)
//	{
//		this.mcq = mcq;
//	}
//	
//	public String getQuestion()
//	{
//		return mcq;
//	}
//	
//	public void setChoices(String[] mcqChoices)
//	{
//		this.mcqChoices = mcqChoices;
//	}
//	
//	public String[] getChoices()
//	{
//		return mcqChoices;
//	}

import java.util.ArrayList;

public class MCQuestion implements QuestionInterface {
	
	private String mcq;
	private ArrayList<String> mcqChoices;
	
	//MCQuestion != SQQuestion
	public boolean isSCQuestion()
	{
		return false;
	}
	public boolean isTFQuestion()
	{
		return false;
	}
	
	public MCQuestion()
	{
		this.mcq = "";
		this.mcqChoices = new ArrayList<String>();
	}
	
	public MCQuestion(String mcq, ArrayList<String> mcqChoices)
	{
		this.mcq = mcq;
		this.mcqChoices = mcqChoices;
	}
	
	public void setQuestion(String mcq)
	{
		this.mcq = mcq;
	}
	
	public String getQuestion()
	{
		return mcq;
	}
	
	public void setChoices(ArrayList<String> mcqChoices)
	{
		this.mcqChoices = mcqChoices;
	}
	
	public ArrayList<String> getChoices()
	{
		return mcqChoices;
	}
	
	public void displayPrompt(int numOfChoices)
	{
		System.out.println("\nThe students will be responding to a Multiple Choice Question.\n");	
		System.out.println("Students will have " + numOfChoices + " answers to select from.\n");
	}
	
	public void displayChoices(ArrayList<String> mcqChoices, int numOfChoices) 
	{
		for(int i = 0; i < numOfChoices; i++)
		{
			if(i < (numOfChoices - 2))
				System.out.print(mcqChoices.get(i) + ", ");
			else if(i == (numOfChoices - 2))
				System.out.println(mcqChoices.get(i) + ", and " + mcqChoices.get(i + 1));
		}
	}
	
	public void displayQuestion()
	{
		System.out.println(getQuestion());
	}
	
}
