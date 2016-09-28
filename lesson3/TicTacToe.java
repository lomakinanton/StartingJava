/*
	Реализована игра с полем 5х5, серия произвольная, без программирования ИИ(к сожалению).
	Ломакин А.К.
	В некоторых местах [x][y] будут поменяны местами и увеличены на 1, это сделано для улучшения интуитивности ввода координат.
*/
import java.util.*;
public class TicTacToe{
	
	
	char[][] field = new char[5][5];
	final char PLAYER_DOT = 'x';
	final char AI_DOT = 'o';
	final char EMPTY_DOT = '.';
	final byte dotsToWin=4;
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args){
		new TicTacToe().launchGame();
	}
	
	void launchGame(){
		initField();
		printField();
		boolean ai_turn=false;//человек всегда ходит первым.(Второй закон робототехники!:)
		while (checkWin(PLAYER_DOT)!=true && checkWin(AI_DOT)!=true && fieldIsFull()!=true){
			turn(ai_turn);
			printField();
			ai_turn=!ai_turn;
		}
	}
	
	void printField(){
		for (int x=0; x<field.length; x++){
			for (int y=0; y<field.length; y++){
				System.out.print(field[x][y]);
			}
			System.out.println();
		}
	}
	
	void initField(){
		for (int x=0; x<field.length; x++){
			for (int y=0; y<field.length; y++){
				field[x][y]=EMPTY_DOT;
			}
		}
	}
	
	void turn(boolean ai){
		int x, y;
		boolean r=true;
		if (ai){
			while (r){
				x=getRandom();
				y=getRandom();
				
				if (field[y][x]==EMPTY_DOT){
					r=false;
					field[y][x]=AI_DOT;
					x++;
					y++;
					System.out.println("AI:"+x+" "+y);
				}
			}
		}
		else{
			while (r){
				System.out.println("Enter X Y:");
				x = sc.nextInt();
				y = sc.nextInt();
				if (field[y-1][x-1]==EMPTY_DOT){
					r=false;
					field[y-1][x-1]=PLAYER_DOT;
				}
			}
		}
	}
	
	boolean checkWin(char dot){
		if (checkHorizontals(dot)) return true;
		if (checkVerticals(dot)) return true;
		if (checkDiagonals(dot)) return true;
		return false;
	}
	
	boolean fieldIsFull(){
		for (int x=0; x<field.length; x++){
			for (int y=0; y<field.length; y++){
				if (field[x][y]==EMPTY_DOT) return false;
			}
		}
		System.out.println("Field is full. Draw!");
		return true;
	}
	
	int getRandom(){
		int a;
		Random r = new Random();
		a = r.nextInt(field.length);
		return a;
	}
	
	boolean checkDiagonals(char dot){
		// Пробовал я по разному написать смещение диагоналей в цикле, никак не получилось, увы. Нужно больше программировать...
		// поэтому вот так, как есть. + На мой взгляд, такие вот простенькие циклы легче читать, чем один но с многократным(и не очевидным) смещением координат.
		
		//Диагонали вида |\|
		byte countInARow=0;
		for (int x=0; x<field.length; x++){
			if (field[x][x] == dot) countInARow++;
			else countInARow=0;
			if (countInARow == dotsToWin){
				System.out.println("Player "+dot+" won!(diag 1-3)");
				return true;
			}
		}
		
		//Диагонали вида |'\|
		countInARow = 0;
		for (int x=1; x<field.length; x++){
			if (field[x-1][x] == dot) countInARow++;
			else countInARow=0;
			if (countInARow == dotsToWin){
				System.out.println("Player "+dot+" won!(diag '1-3)");
				return true;
			}
		}
		
		//Диагонали вида |\'|
		countInARow = 0;
		for (int x=0; x<field.length-1; x++){
			if (field[x+1][x] == dot) countInARow++;
			else countInARow=0;
			if (countInARow == dotsToWin){
				System.out.println("Player "+dot+" won!(diag 1-3')");
				return true;
			}
		}
		
		//Диагонали вида |'/|
		countInARow=0;
		for (int x=1; x<field.length; x++){
			if (field[field.length-x][x] == dot) countInARow++;
			else countInARow=0;
			if (countInARow == dotsToWin){
				System.out.println("Player "+dot+" won!(diag '2-4)");
				return true;
			}
		}
		
		//Диагонали вида |/|
		countInARow=0;
		for (int x=0; x<field.length; x++){
			
			if (field[field.length-1-x][x] == dot) countInARow++;
			else countInARow=0;
			
			if (countInARow == dotsToWin){
				System.out.println("Player "+dot+" won!(diag 2-4)");
				return true;
			}
		}
		
		//Диагонали вида |/'|
		countInARow=0;
		for (int x=0; x<field.length-1; x++){
			
			if (field[field.length-2-x][x] == dot) countInARow++;
			else countInARow=0;
			
			if (countInARow == dotsToWin){
				System.out.println("Player "+dot+" won!(diag 2-4')");
				return true;
			}
		}
		return false;
	}
	
	boolean checkVerticals(char dot){
		byte countInARow=0;
		for (int x=0; x<field.length; x++){
			countInARow=0;
			for (int y=0; y<field.length; y++){
				if (field[y][x] == dot) countInARow++; else countInARow=0;
				if (countInARow == dotsToWin){
					System.out.println("Player "+dot+" won!(vert)");
					return true;
				}
			}
		}
		return false;
	}
	
	boolean checkHorizontals(char dot){
		byte countInARow=0;
		for (int y=0; y<field.length; y++){
			countInARow=0;
			for (int x=0; x<field.length; x++){
				if (field[y][x] == dot) countInARow++; else countInARow=0;
				if (countInARow == dotsToWin){
					System.out.println("Player "+dot+" won!(horiz)");
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	
}