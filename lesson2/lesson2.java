import java.util.Arrays;
import java.util.Scanner;

class lesson2{
	public static void main(String[] args) {
		int[] arr={1,0,1,0,1};				//Пункт 1. Создать массив из единичек и нулей.
		int[] otherArr=new int[8];			//Массив для пункта 3
		int z=0;  							//Счетчик для пункта 3
		int[] mas = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 }; //массив для пункта 4, и пусть будет для пункта 5
		
		
		
		// Пункт 2. Поменять местами единички и нули
		System.out.println("Point#2");	
		for(int i=0; i<arr.length; i++){ 	
			if(arr[i]==1){
				arr[i]=0;
			}
			else{    						
				arr[i]=1;
			}
			
			System.out.println(arr[i]);	
		}									
		System.out.println("Point#3");	
		
		//пункт 3. заполнить числовой ряд;
		for(int i=1;i<=22;i=i+3){ 				 
			otherArr[z]=i;			
			System.out.println(otherArr[z]);
			z++;
		}
		
		
		//пункт 4. Увеличить все что меньше 6 в 2 раза
		System.out.println("Point#4");	
		for(int i=0; i<mas.length; i++){ 
			if(mas[i]<6){
				mas[i]=mas[i]*2;
				System.out.println(mas[i]);
			}
			else{
				System.out.println(mas[i]);
			}
		}
		
		
		//Пункт 5. Найти макс и мин среди значений массива.	
		//Я использовал старый массив, вместо создания нового.
		minmaxArray(mas);
		
		
		//Пункт 6. Консольный калькулятор
		System.out.println("Point#6");		
		
		int[] nums = scanNum(); //сканируем числа
		char arithmetic = scanArithmetic(); //сканируем арифметичское действие
		doIt(nums, arithmetic); //выполняем
		
	}	
	
	public static int[] scanNum(){
		int a;  
		int b;	
		int[] arr = new int[2];
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a:");
		a = in.nextInt();
		System.out.println("Enter b:");
		b = in.nextInt();
		
		arr[0]=a;
		arr[1]=b;
		
		return arr;
		
	}
	public static char scanArithmetic(){
		
		char a;  //Для 6 задания
		
		
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter arithmetic:");
		a = in.next().charAt(0);
		
		
		return a;
		
	}
	public static void doIt(int[] nums, char arithmetic){
		switch(arithmetic){
			
			case '*':
			System.out.println(nums[0]*nums[1]);
			break;
			case  '+':
			System.out.println(nums[0]+nums[1]);
			break;
			case '-':
			System.out.println(nums[0]-nums[1]);
			break;
			case '/':
			if(nums[1]==0){
				System.out.println("zero divide!!!!!!11");
			}
			else{
				System.out.println(nums[0]/nums[1]);	
			}	
		}
		
		
		
	}
	public static void minmaxArray(int[] arr){
		System.out.println("Point#5");	
		Arrays.sort(arr);					//есть способ лучше.
		System.out.println("Max: "+arr[arr.length-1]);
		System.out.println("Min: "+arr[0]);
	}
	
}