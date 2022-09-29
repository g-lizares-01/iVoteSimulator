package iVoteSimulator;
import java.util.ArrayList;
import java.lang.Math;


public class VotingService {
	//Initial collecting off all students' answers
	public static ArrayList<ArrayList<String>> compileAnswers(QuestionInterface q, Student[] students, 
															int numOfStudents, ArrayList<ArrayList<String>> allAnswers)
	{
		System.out.println("\n(Collecting initial answers...)\n");
		for(int i = 0; i < numOfStudents; i++)
		{
			students[i].generateAnswers(q);
			allAnswers.add(students[i].getAnswers());
		}
		//System.out.println(allAnswers);
		return allAnswers;		//returns compiled list
	}
	
	
	//Accounts for any number of students resubmitting their answers, and stores their LAST submitted answer
	public static ArrayList<ArrayList<String>> duplicateAnswerCase(QuestionInterface q, Student[] students, int numOfStudents, 
													ArrayList<ArrayList<String>> allAnswers, int numOfResub)
	{
		System.out.println("Final call for any resubmissions!");
		//temp array holds the indexes of students in Student[] that will resubmit answers 
		int[] temp = new int[numOfResub];
		for(int i = 0; i < numOfResub; i++)
			temp[i] = (int)(Math.random() * numOfStudents) + 0;
		
		//update the students' answers
		for(int i = 0; i < numOfResub; i++)
		{
			students[temp[i]].generateAnswers(q);
			allAnswers.set(temp[i], students[temp[i]].getAnswers());
		}
		
		System.out.println("\n(Answers were resubmitted by students " + numOfResub + " time(s).)\n");
		return allAnswers;
	}
	
	public static void displayStats(Student[] students, ArrayList<ArrayList<String>> allAnswers, int numOfChoices)
	{
		System.out.println("\nFinal answer totals:");
		for(int i = 0; i < numOfChoices; i++)
		{
			int counter = 0;
			for(Student s : students)
			{
				if(s.getAnswers().contains(Character.toString((char)(65 + i))))
					counter++;
			}
			System.out.println(Character.toString((char)(65 + i)) + ": " + counter);
		}
	}

}
