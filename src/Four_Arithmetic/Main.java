package Four_Arithmetic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {
	private static final String Calculator = null;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("�����뱾����Ŀ����");
		int num = sc.nextInt();
		for(int i=0; i<num; i++) {
			creatArith();//��������ʽ
		}
}
	
	//���������
	public static int getNumber(){  
		int number = 0;  
		Random num = new Random();  
		number = num.nextInt(100+1);  
		return number;  
		} 
	
	
	//��������������
	public static char getOperator(){  
		char operator = 0;  
		Random ran = new Random();  
		int i = ran.nextInt(4);  
		switch(i){  
			case 0:  
		    	operator = '+';  
		        break;  
		    case 1:  
		        operator = '-';  
		        break;  
		    case 2:  
		        operator = '*';  
		        break;  
		    case 3:  
		        operator = '/';  
		        break;  
		}  
		return operator;  
	} 
	
	//��������ʽ
	static ScriptEngine js = new ScriptEngineManager().getEngineByName("JavaScript");
	public static  void creatArith() throws ScriptException{
		ArrayList<String> arithList = new ArrayList<String>();//����ʽ		
		String arr = "";
		for(int j=0;j<3;j++){
			int number = getNumber();
			String operator = String.valueOf(getOperator());
			arr += number + operator;
			}
			arr =arr.substring(0,arr.length()-1);
			
	    Object obj = js.eval(arr);
	    int result = Integer.parseInt(obj.toString());
	    if(result < 100 && result > 0) {
	    	System.out.println(arr+"=");
	    }
			
	}
	
}
