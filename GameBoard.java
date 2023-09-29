import java.util.Random;
import java.util.Scanner;
//ID:201501423
//Name: Swastika Nayak

public class GameBoard {
	 final static int player1= 1;//defines player 1 value for gameboard
	 final static int player2 =2;//defines player 2 value for gameboard
	static  int[][] gamebd = new int[3][3];//creates a gameboard
public static void play(int mode){//this is doing the actual playing work
		if(mode==2)
			System.out.println("Player 1 is human and player 2 is computer");
		if(mode==3)
			System.out.println("Player 1 is computer and player 2 is human");
	for(int i=0;i<9;i++ ){
		int player;
		if(i%2==0)
			player=player1;
		else
			player=player2;
checkAndAssign(player,mode,i);
display();
if(checkIfGameDone()==true)		
	return;	
}		
	System.out.println("Game draw");
}
public static void display(){//it will display gameboard
	for(int j=0;j<3;j++){
		for(int k=0;k<3;k++){
			if(gamebd[j][k]==1)
			System.out.print("X ");
			else if(gamebd[j][k]==2)
				System.out.print("O ");	
			else
				System.out.print("- ");
		}
	System.out.println();
		}
}
public static boolean checkIfGameDone(){//this will return true if game is finished and print who  won
boolean a=checkDiagonal();
boolean b=false;
if(a==false)
	 b = checkSides(0)||checkSides(1)||checkSides(2);
	return a||b;	
}
public static boolean checkDiagonal(){//this will check if game is over because the diagonals give 3Xs or 3Os
if(gamebd[0][0]==gamebd[1][1]&&gamebd[1][1]==gamebd[2][2]&&gamebd[0][0]>0)
{
	if(gamebd[0][0]==player1)
		System.out.println("Player 1 won");
	else
		System.out.println("Player 2 won");
return true;		
}
if(gamebd[0][2]==gamebd[1][1]&&gamebd[1][1]==gamebd[2][0]&&gamebd[0][2]>0)
{
	if(gamebd[0][2]==player1)
		System.out.println("Player 1 won");
	else
		System.out.println("Player 2 won");
	return true;	
}
	return false;
}
public static boolean checkSides(int i){//this will check if game is over if any of the sides have 3 Xs or 3Os
	if(gamebd[i][0]==gamebd[i][1]&&gamebd[i][1]==gamebd[i][2]&&gamebd[i][0]>0){
		if(gamebd[i][0]==player1)
			System.out.println("Player 1 won");
		else
			System.out.println("Player 2 won");
	return true;	
	}
	 if(gamebd[0][i]==gamebd[1][i]&&gamebd[2][i]==gamebd[1][i]&&gamebd[0][i]>0){
		if(gamebd[0][i]==player1)
			System.out.println("Player 1 won");
		else
			System.out.println("Player 2 won");
	return true;	
	}
	return false;
}
public static String input(int mode,int i,int player){//this will give input as the pair of row and column of gameboard
	Scanner input = new Scanner(System.in);
	String inp = null;
	int a = 0,b=0;
	if(mode==1)
	 inp = input.nextLine();
	else if(mode==2)
	{
		if(i%2==0){
			inp=input.nextLine();
			}
		else{
		inp = searchSmart(player,mode,i);
		System.out.println(inp);
	}
		}
	else if(mode==3)
	{
		if(i%2==0){
			inp = searchSmart(player,mode,i);
			System.out.println(inp);
		}
		else
		{
			inp=input.nextLine();	
		}
			
	}
	return inp;
}
public static void checkAndAssign(int player,int mode,int i){//this will check for the necessary constraints from the input and give the input to gameboard
	boolean flag = false;
	String inp;
	if(mode==1||(mode==2&&i%2==0)||(mode==3&&i%2==1)){
	System.out.print("Enter your input Player "+ player);
	}
	else
		System.out.print("The inputs of computer based Player "+player+"\t");
	if((mode==2&&i==1&&gamebd[1][1]==0)||(mode==3&&i==0&&gamebd[1][1]==0)){
		inp=2+" "+2;
		System.out.println(inp);
	}
	else
 inp=input(mode,i,player);
	do{
    String[] temp = inp.split(" ");	
    if(!(Integer.parseInt(temp[0])>=1&&Integer.parseInt(temp[1])>=1&&Integer.parseInt(temp[0])<=3&&Integer.parseInt(temp[1])<=3))
	 {
	 System.out.println("Enter a valid input");
	 inp=input(mode,i,player);
     continue;
	}			
        if(gamebd[Integer.parseInt(temp[0])-1][Integer.parseInt(temp[1])-1]==0){
			gamebd[Integer.parseInt(temp[0])-1][Integer.parseInt(temp[1])-1]=player;
			flag=true;
	}
		else if(mode==1||(mode==2&&i%2==0)||(mode==3&&i%2==1)){
			System.out.print("Enter your input again Player "+player);
		 inp=input(mode,i,player);
		}
}while(flag==false);
}
public static String searchSmart(int player,int mode,int move){//This will smartly assign values to the computer based input
	boolean flag = false;
	String inp = null;
	int row=0,col=0;
	int row1=-1,col1=-1;
if(mode==3){
	if(move==2){
		if(gamebd[0][1]==2||gamebd[1][0]==2){
			inp=3+" "+3;
			return inp;
		}
		
		else if(gamebd[2][1]==2||gamebd[1][2]==2){
			inp=1+" "+1;
			return inp;
		}}
}
for(int i=0;i<3;i++){//checks if any of the rows have 2 computer moves and third empty so as to fill it and win
	int count=0;
	row1=-1;
	col1=-1;
	for(int j=0;j<3;j++){
		if(gamebd[i][j]==player){
			count++;
		}
		if(gamebd[i][j]==0)
			
		{
			row1=i;
			col1=j;
		}
	}

	if(count==2&&row1>=0&&col1>=0){
		//System.out.println("rowon");
		row=row1+1;
		col=col1+1;
		inp=row+" "+col;
		flag=true;
		return inp;
	}}
for(int j=0;j<3;j++){//checks if any of the columns have 2 computer moves and third empty so as to fill it and win

	int count=0;
	row1=-1;
	col1=-1;
	for(int i=0;i<3;i++){
		if(gamebd[i][j]==player){
			count++;
		}
		if(gamebd[i][j]==0)
		{
			row1=i;
			col1=j;
		}
	}
	if(count==2&&row1>=0&&col1>=0){
		row=row1+1;
		col=col1+1;
		inp=row+" "+col;
		flag=true;
		return inp;
	}}
//The below code checks if any of the diagonals have 2 computer moves and third empty so as to fill it or 2 human moves and third empty so as to block it 
int count=0;
int countopp=0;
row1=-1;
col1=-1;
for(int i=0;i<3;i++){	
if(gamebd[i][i]==player)
		count ++;	
if(gamebd[i][i]==0)
		row1=col1=i;
}
	if((count==2)&&row1>=0&&col1>=0)
	{
		col=row=(row1+1);
	inp=row+" "+col;
	flag=true;
	return  inp;
}
	row1=-1;
	col1=-1;
	for(int i=0;i<3;i++){	
		if(gamebd[i][i]!=player&&gamebd[i][i]>0)
				countopp ++;	
		if(gamebd[i][i]==0)
				row1=col1=i;
			}
	if((countopp==2)&&row1>=0&&col1>=0)
	{
		col=row=(row1+1);
	inp=row+" "+col;
	flag=true;
	return  inp;
}
	 count=0;
	 countopp=0;
	row1=-1;
	col1=-1;
	for(int i=2;i>=0;i--){
		if(gamebd[i][2-i]==player)
			count ++;
		if(gamebd[i][2-i]==0)
		{
			row1=i;
			col1=2-i;
		}
		}
		if((count==2)&&row1>=0&&col1>=0)
		{
			row=row1+1;
			col=col1+1;
		inp=row+" "+col;
		flag=true;
		return  inp;
	}
		row1=-1;
		col1=-1;
		for(int i=2;i>=0;i--){
			if(gamebd[i][2-i]!=player&&gamebd[i][2-i]>0)
			countopp++;
			if(gamebd[i][2-i]==0)
			{
				row1=i;
				col1=2-i;
			}
			}
			if((countopp==2)&&row1>=0&&col1>=0)
			{
				row=row1+1;
				col=col1+1;
			inp=row+" "+col;
			flag=true;
			return  inp;
		}
	for(int i=0;i<3;i++){//checks if any of the rows have 2 human moves and third empty so as to block it and not allow human to win
		 countopp=0;
		 row1=-1;
			col1=-1;
		for(int j=0;j<3;j++){
			if(gamebd[i][j]!=player&&gamebd[i][j]>0){
				countopp++;
			}
			if(gamebd[i][j]==0)
			{
				row1=i;
				col1=j;
			}
		}
		if(countopp==2&&row1>=0&&col1>=0){
			row=row1+1;
			col=col1+1;
			inp=row+" "+col;
			flag=true;
			return inp;
		}}
	for(int j=0;j<3;j++){//checks if any of the columns have 2 human moves and third empty so as to block human and not allow to win
		 countopp=0;
		 row1=-1;
			col1=-1;
		for(int i=0;i<3;i++){
			if(gamebd[i][j]!=player&&gamebd[i][j]>0){
				countopp++;
			}
			if(gamebd[i][j]==0)
			{
				row1=i;
				col1=j;
			}
		}
		if(countopp==2&&row1>=0&&col1>=0){
			row=row1+1;
			col=col1+1;
			inp=row+" "+col;
			flag=true;
			return inp;
		}}
if(flag==false){//Now since all cases are checked(of winning and not allowing human to win), computer will play a random move
Random rand = new Random();
int min=0;
int max=2;
int a,b;
do{
	 a = rand.nextInt(max-min+1)+min;
	 b = rand.nextInt(max-min+1)+min;
	 //System.out.println(a+""+b);
}while(gamebd[a][b]!=0);
inp=(a+1)+" "+(b+1);
}
return inp;
}
}
