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
		System.out.println("请输入本次题目数：");
		int num = sc.nextInt();
		for(int i=0; i<num; i++) {
			creatArith();//产生运算式
		}
}
	
	//产生随机数
	public static int getNumber(){  
		int number = 0;  
		Random num = new Random();  
		number = num.nextInt(100+1);  
		return number;  
		} 
	
	
	//随机产生运算符号
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
	
	//产生运算式
	static ScriptEngine js = new ScriptEngineManager().getEngineByName("JavaScript");
	public static  void creatArith() throws ScriptException{
		ArrayList<String> arithList = new ArrayList<String>();//运算式		
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
