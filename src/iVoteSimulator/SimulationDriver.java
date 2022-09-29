package iVoteSimulator;
import java.lang.Math;
import java.util.ArrayList;

public class SimulationDriver {
	
	//Generate/initialize needed values and other key items
	private final static int numOfStudents = (int)(Math.random() * 75) + 5;	//randomly selects # of students to poll
	private static Student[] students = new Student[numOfStudents];			//will hold students with their assigned ID numbers

	private final static int qType = (int)(Math.random() * 3) + 1;			//randomly selects type of question

	private static int numOfChoices = (int)(Math.random() * 4) + 4;			//randomly selects how many answer choices
	private static ArrayList<String> choices = new ArrayList<String>();		//will hold answer choices for each question
	private static ArrayList<ArrayList<String>> allAnswers = new ArrayList<ArrayList<String>>();
	private static int numOfResub = (int)(Math.random() * numOfStudents) + 0;	//randomly selects how many times students 
																						//will resubmit answers
																						//the same student may resubmit 
																								//their answer more than once

	public static void main(String[] args) {
		
		System.out.println("There will be " + numOfStudents + " students responding to the following poll.");
		
		//Generate Student ID Numbers and save 
		for(int i = 0; i < numOfStudents; i++)
		{
			students[i] = new Student(101 + i);
		}
		
		if (qType == 1)
		{		
			//Question
			String question = "\nStudents, please select as many options as you see fit.";
			
			//Create ArrayList of answer choices
			createChoiceList(choices, numOfChoices);
			
			//Create question, set parameters, print contents
			QuestionInterface q1 = createMCQ(question, choices);
			q1.displayPrompt(numOfChoices);
			q1.displayChoices(choices, numOfChoices);
			q1.displayQuestion();
			
			//Compile answers, taking resubmissions into account
			VotingService.compileAnswers(q1, students, numOfStudents, allAnswers);
			VotingService.duplicateAnswerCase(q1, students, numOfStudents, allAnswers, numOfResub);
			VotingService.displayStats(students, allAnswers, numOfChoices);
		}

		else if (qType == 2)
		{		
			//Question
			String question = "\nStudents, please select ONE option.";
			
			//Create ArrayList of answer choices
			for(int i = 0; i < numOfChoices; i++)
			createChoiceList(choices, numOfChoices);
			
			//Create question, set parameters, print contents
			QuestionInterface q2 = createSCQ(question, choices);
			q2.displayPrompt(numOfChoices);
			q2.displayChoices(choices, numOfChoices);
			q2.displayQuestion();
			
			//Compile answers, taking resubmissions into account
			VotingService.compileAnswers(q2, students, numOfStudents, allAnswers);
			VotingService.duplicateAnswerCase(q2, students, numOfStudents, allAnswers, numOfResub);
			VotingService.displayStats(students, allAnswers, numOfChoices);
		}

		else
		{
			numOfChoices = 2;
			
			//Question
			String question = "\nStudents, please select ONE option.";
			
			//Create ArrayList of answer choices
			createChoiceList(choices, numOfChoices);
			
			//Create question, set parameters, print contents
			QuestionInterface q3 = createTFQ(question, choices);
			q3.displayPrompt(numOfChoices);
			q3.displayChoices(choices, 2);
			q3.displayQuestion();

			//Compile answers, taking resubmissions into account
			VotingService.compileAnswers(q3, students, numOfStudents, allAnswers);
			VotingService.duplicateAnswerCase(q3, students, numOfStudents, allAnswers, numOfResub);
			VotingService.displayStats(students, allAnswers, numOfChoices);
		}
		
	}
	
	public static ArrayList<String> createChoiceList(ArrayList<String> choices, int numOfChoices)
	{
		//Create ArrayList of answer choices
		for(int i = 0; i < numOfChoices; i++)
		{
			choices.add(Character.toString((char)(65 + i)));
		}
		
		return choices;
	}

	//Methods to create each question type
	public static QuestionInterface createMCQ(String question, ArrayList<String> choices)
	{
		QuestionInterface q = new MCQuestion(question,choices);
		return q;
	}
	
	public static QuestionInterface createSCQ(String question, ArrayList<String> choices)
	{
		QuestionInterface q = new SCQuestion(question,choices);
		return q;
	}
	
	public static QuestionInterface createTFQ(String question, ArrayList<String> choices)
	{
		QuestionInterface q = new TFQuestion(question,choices);
		return q;
	}

}
