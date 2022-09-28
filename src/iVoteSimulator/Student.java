package iVoteSimulator;
import java.util.ArrayList;

public class Student {
	//ID number for each student
	private int id;
	private ArrayList<String> answers;
	
	//Student object constructors
	public Student()
	{
		this.id = 0;
	}
	public Student(int id)
	{
		this.id = id;
	}
	
	//Set student's ID number
	public void setId(int id)
	{
		this.id = id;
	}
	
	//Get student's ID number
	public int getId()
	{
		return id;
	}
	
	public ArrayList<String> getAnswers()
	{
		return answers;
	}
	
	public void generateAnswers(QuestionInterface q)
	{
		if(!q.isSCQuestion())
		{
			AnswerInterface mca = new MCAnswers();
			answers = mca.createStudentAnswer(q);
		}
		else
		{
			AnswerInterface sca = new SCAnswers();
			answers = sca.createStudentAnswer(q);
		}
	}
	
	public void displayAnswers()
	{
		System.out.println("Student's answer: " + getAnswers());
	}
}
