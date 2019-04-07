package Four_Arithmetic_Operation;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
        System.out.print("题目数量：");
        int count = scan.nextInt();
        
		Create create = new Create();
		Calculate cal = new Calculate();
		String[] quizes = new String[count];
		String[] answers = new String[count];
		String[] useranswers = new String[count];
		int correctcount = 0, wrongcount = 0;
		int[] correct = new int[count];
		int[] wrong = new int[count];
		
		String quize, result;
		for(int i = 0; i < count; i++) {
			quize = create.create();
			quizes[i] = quize;
			answers[i] = cal.calculate(quize);
		}
		
		scan.nextLine();
		for(int i = 0; i < count; i++) {
			System.out.print(quizes[i]+"= ");
			useranswers[i] = scan.nextLine();
			if(answers[i].equals(useranswers[i])){
				correct[correctcount]=i;
				correctcount++;
			}
			else{
				wrong[wrongcount]=i;
				wrongcount++;
			}
		}
		
		System.out.println();
		System.out.print("Correct: " + correctcount + "(");
		for(int i = 0; i < correctcount; i++){
			System.out.print(correct[i]+1+" ");
		}
		System.out.println(")");
		
		System.out.print("Wrong: " + wrongcount + "(");
		for(int i = 0; i < wrongcount; i++){
			System.out.print(wrong[i]+1+" ");
		}
		System.out.println(")");
	}

}
