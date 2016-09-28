/**
*Created by Lomakin Anton on 23.08.2016
*/
import java.util.Scanner;
public class MainClass{   //declaration of class
	public static void main(String[] args){
		
		//пункт 2 домашнего задания(инициализация переменных всех рассмотренных типов)	
		byte a=-10;
		short b=21;
		int c=250;
		int d=700;
		float e=120.0f;
		double f=15.72d;
		boolean g=false;
		char h='z';
		long j=15000L;
		float year;
		boolean leap;
		
		System.out.println(sumVar(a, b, c, d));
		System.out.println(checkSum(a,b));
		
		
		year=scanYear();
		leap=checkLeapYear(year);
		if(leap){
			System.out.println("Високосный!");
		}
		else{
			System.out.println("Не високосный!");
		}
			
		
		 
	}
	//Пункт 3 домашнего задания(вычислить по формуле)
	public static int sumVar(byte a, short b, int c, int d){
		
		
		return a * (b + (c / d));
	}
	
	//Пункт 4 домашнего задания(проверить лежит ли сумма двух чисел в пределах [10:20])
	public static boolean checkSum(byte a, short b){
		
		if((a+b)>=10 && (a+b)<=20){
			return true;
		}
		else{
			return false;
		}
	}
	//проверим, является ли год високосным
	public static boolean checkLeapYear(float year){
		boolean result=false;
		
		
		
		if((year/100)%1==0){ //делится на 100 без остатка, но это еще ничего не значит. Он и на 400 может делиться.
			if((year/400)%1==0){ //делится на 400 без остатка, значит високосный
				result=true;
			}
			else{//делится на 100, но не делится на 400. Значит не високосный
				result=false;
			}
		}
		else if((year/4)%1==0){ //не делится на 100, тем более на 400, но делится на 4. Значит високосный, иначе нет.
				result=true;
			}
		
		
		
		return result;
	}
	
	public static short scanYear(){
		
		Scanner in = new Scanner(System.in);
		System.out.println("Введите год:");
		short year = in.nextShort();
		return year;
	}
	}