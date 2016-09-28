/**
*Created by Lomakin Anton on 23.08.2016
*/
import java.util.Scanner;
public class MainClass{   //declaration of class
	public static void main(String[] args){
		
		//����� 2 ��������� �������(������������� ���������� ���� ������������� �����)	
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
			System.out.println("����������!");
		}
		else{
			System.out.println("�� ����������!");
		}
			
		
		 
	}
	//����� 3 ��������� �������(��������� �� �������)
	public static int sumVar(byte a, short b, int c, int d){
		
		
		return a * (b + (c / d));
	}
	
	//����� 4 ��������� �������(��������� ����� �� ����� ���� ����� � �������� [10:20])
	public static boolean checkSum(byte a, short b){
		
		if((a+b)>=10 && (a+b)<=20){
			return true;
		}
		else{
			return false;
		}
	}
	//��������, �������� �� ��� ����������
	public static boolean checkLeapYear(float year){
		boolean result=false;
		
		
		
		if((year/100)%1==0){ //������� �� 100 ��� �������, �� ��� ��� ������ �� ������. �� � �� 400 ����� ��������.
			if((year/400)%1==0){ //������� �� 400 ��� �������, ������ ����������
				result=true;
			}
			else{//������� �� 100, �� �� ������� �� 400. ������ �� ����������
				result=false;
			}
		}
		else if((year/4)%1==0){ //�� ������� �� 100, ��� ����� �� 400, �� ������� �� 4. ������ ����������, ����� ���.
				result=true;
			}
		
		
		
		return result;
	}
	
	public static short scanYear(){
		
		Scanner in = new Scanner(System.in);
		System.out.println("������� ���:");
		short year = in.nextShort();
		return year;
	}
	}