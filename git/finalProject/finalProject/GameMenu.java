package finalProject;

import java.util.ArrayList;
import java.util.Scanner;


public class GameMenu 
{
	public ArrayList<Player> players;
	public ArrayList<Room> rooms;
	public ArrayList<EventRoom> eventRooms;
	private Scanner s;
	private int id = 0;
	private int score;
	public int i = 0;
	
	public static void main(String[] args)
	{
		int x = 0;
		GameMenu cm = new GameMenu();
		do 
		{
			x = cm.startMenu();
			cm.processInput(x);
		}	while (x != 3);
	}
	public GameMenu()
	{
		s = new Scanner(System.in);
		players = new ArrayList<Player>();
		rooms = new ArrayList<Room>();
		eventRooms = new ArrayList<EventRoom>();
		
	}
	
	public int startMenu()
	{
		System.out.println("Welecome to The Hollow Journey!");
		System.out.println("Try to get the perfect score of 3000!");
		System.out.println("1. Play");
		System.out.println("2. Scores");
		System.out.println("3. Exit");
		System.out.println("Please Select an option: ");
		int selection = s.nextInt();
		rooms.add(new Room("Start Room"));//0
		rooms.add(new Room("Sword Room"));//1
		eventRooms.add(new EventRoom("Skelenton Room",false));//0
		rooms.add(new Room("Treasure Room"));//2
		
		while(selection < 1 || selection > 3)
			{
			System.out.println("Invalid selection, please try again: ");
			selection =s.nextInt();
			}
		return selection;
	}
	
	public void processInput(int selection)
	{
		if (selection ==1)
		{
			CreateGame();
		}
		else if (selection ==2)
		{
			displayPlayers();
		}
	}
	public void displayPlayers()
	{
		int z = 0;
		if(id ==0)
		{
			System.out.println("You are the first to Play!");
		}
		else
			System.out.println(" Score "+"  Rank "+" Name");
			for(i = 0; i< players.size();i++)	
			{		
				
				for (z=(i-1);z>=0;z--)
				{
					players.get(i).CompareRank(players.get(z));			
				}
				
			}
			
			for(i = 0; i< players.size();i++)	
			{
				if (i == 9|| i !=10 & i != 0 & i%10 ==0)
				{
					System.out.println(" Score "+"  Rank "+" Name");
				}
			System.out.println((i+1) + ".)" + players.get(i));
			}
			
			System.out.println("type (ok) then Press enter to continue");
			String emp = s.next();
		}
	public void CreateGame()
	{
		System.out.println("Please enter your Name");
		String Name = s.next();
		int rank = id+1;
		
		this.score= 3000;
		
		
		players.add(new Player(Name,score,rank,id));
		this.id = this.id +1;
		StartGame();
		
		
	}
	public void StartGame()
	{	
		Room CurrentRoom= rooms.get(0);
		int c=players.size()-1;
		int lastChoice ;
		
		System.out.println(CurrentRoom);
		System.out.println("");
		System.out.println("You enter the cave and navigate to a fork in the path");
		System.out.println("Do you choose to take the left path or the right");
		System.out.println("");
		System.out.println("1. Left");
		System.out.println("2. Right");
		
		int choice = s.nextInt();
		while(choice < 1 || choice > 2)
			{
			System.out.println("Invalid selection, please try again: ");
			choice =s.nextInt();
			}
		if(choice == 1)
		{
			
			CurrentRoom= rooms.get(1);
			if (players.get(i).name.length()% 2== 0)
			{
				players.get(c).score =(players.get(c).score- 50);
			}
		}
		else 
		{
			CurrentRoom = rooms.get(1);
			if (players.get(i).name.length()% 2!= 0)
			{
				players.get(c).score =(players.get(c).score- 50);	
			}
		}
		lastChoice = choice;
		
		
		System.out.println(CurrentRoom);
		System.out.println("The path you have chosen shrinks and you body begins to be contricted,"); 
		System.out.println("but you continue to push through the jagged rocks.");
		System.out.println("");
		System.out.println("");
		System.out.println("Your perseverance pays off and as you pass though the opening closes behind you");
		System.out.println("You gaze around the room and see an altar with a sword stuck in the ground.");
		System.out.println("You feel the power radiating from sword and you feel the urge to grab it.");
		System.out.println("What will you do?");
		System.out.println("");
		if (lastChoice ==1)
		{
			System.out.println("1. Proceed");
			System.out.println("2. Take the Sword");
		}
		else 
		{
			System.out.println("2. Take the Sword");	
			System.out.println("3. Try to read the words on the alter");
		}
		
		choice = s.nextInt();
		if (lastChoice ==1)
		{
		while(choice < 1 || choice > 2)
			{
			System.out.println("Invalid selection, please try again: ");
			choice =s.nextInt();
			}
		}
		else if (lastChoice ==2)
		{
		while(choice < 2 || choice > 3)
			{
			System.out.println("Invalid selection, please try again: ");
			choice =s.nextInt();
			}
		}
		if(choice == 1)
		{
			CurrentRoom= eventRooms.get(0);
		}
		else if (choice == 2)
		{	
			players.get(c).score =(players.get(c).score- 100);
			CurrentRoom= eventRooms.get(0);
		}
		else if(choice == 3)
		{
			System.out.println("You touch the words as you attempt to decipher the meaning and the sword begins to glow...");
			System.out.println("You pick up the sword and continue on");
			System.out.println("type (ok) then Press enter to continue");
			String emp = s.next();
			CurrentRoom= eventRooms.get(0);
		}
		lastChoice = choice;
		
		
		System.out.println(CurrentRoom);
		System.out.println("");
		System.out.println("You proceed up a stairway into room filled with bones.");
		System.out.println("as you approach the center of the room an animated skeleton runs to meet you");
		System.out.println("before the skeleton reaches you, you decide to..");
		System.out.println("");
		if (lastChoice ==1)
		{
			System.out.println("1. Do nothing");
			System.out.println("2. Attack");
		}
		else if (lastChoice ==2)
		{
			System.out.println("1. Do nothing");
			System.out.println("3. Smash the skeleton's skull!");	
			System.out.println("4. Cleave the skeleton in two with the sword!");
		}
		else
		{
			System.out.println("1. Do nothing");	
			System.out.println("4. Cleave the skeleton in two with the sword!");
		}
		
		choice = s.nextInt();
		if (lastChoice ==1)
		{
		while(choice < 1 || choice > 2)
			{
			System.out.println("Invalid selection, please try again: ");
			choice =s.nextInt();
			}
		}
		else if (lastChoice ==2)
		{
		while(choice < 1 ||choice==2|| choice >4)
			{
			System.out.println("Invalid selection, please try again: ");
			choice =s.nextInt();
			}
		}
		else 
		{
			while(choice < 1 ||choice ==2|| choice ==3 || choice > 4)
			{
			System.out.println("Invalid selection, please try again: ");
			choice =s.nextInt();
			}
		}
		
		if(choice == 1& lastChoice == 1 ||choice == 1& lastChoice == 3)
		{
			System.out.println(choice);
			System.out.println("The skelenton falls before you, turning into a pile of bones");
			CurrentRoom= rooms.get(2);
		}
		else if(choice == 1 & lastChoice == 2)
		{
			players.get(c).score =(players.get(c).score- 2500);
			System.out.println("The skeleton runs to meet you and bites your neck!");
			System.out.println("You fall to the ground in shock as it devours you.");
			System.out.println("");
			System.out.println("");
			System.out.println("You did not survive the hollow");
			System.out.println("The End");
			System.out.print(players.get(c).name);
			System.out.println(players.get(c).score);
			System.out.println("type (ok) then Press enter to continue");
			String emp = s.next();
			choice = 0;
			
		}
		else if (choice == 2||choice == 3)
		{	
			System.out.println("You thrust out both your arms and the skull turns to dust");
			System.out.println("");
			System.out.println("type (ok) then Press enter to continue");
			String emp = s.next();
			System.out.println("You feel a pain in your arm and look to see your viens glowing red!");
			eventRooms.get(0).EventTrue();
			players.get(c).score =(players.get(c).score- 300);
			
			CurrentRoom= rooms.get(2);
		}
		else if(choice == 4& lastChoice == 2)
		{
			System.out.println("You fling the sword taking off the skelenton's head but dropping the weapon in the process!");
			System.out.println("");
			System.out.println("type (ok) then Press enter to continue");
			String emp = s.next();
			System.out.println("The bones beneath your feet begin to tremble. They rise upright and form numerous skelentons that surround you!");
			System.out.println("What will you do next?");
			System.out.println("1. Do nothing");
			System.out.println("2. Go for the sword");
			System.out.println("3. Attack with your hands");
			int choice2 = s.nextInt();
			while(choice2 < 1 || choice2 >3)
			{
			System.out.println("Invalid selection, please try again: ");
			choice2 =s.nextInt();
			}
			if (choice2 == 1)
			{
				choice = 0;
				players.get(c).score =(players.get(c).score- 2000);
				System.out.println("You become swarmed and fall. the flesh is ripped from your body until your bones become one with the room");
				System.out.println("");
				System.out.println("");
				System.out.println("The End");
				System.out.println("You did not survive the hollow");
				System.out.println(players.get(c).name);
				System.out.println("score: "+ players.get(c).score);
				System.out.println("type (ok) then Press enter to continue");
				emp = s.next();
			}
			
			else if (choice2 == 2) 
			{
				System.out.println("You grab the sword and start hacking away at the bones.");
				System.out.println("It seems the more you slash away the more enemies appear");
				System.out.println("1. fight the skelentons with your bare hands");
				System.out.println("2. Keep hacking away");
				int choice3 = s.nextInt();
				while(choice3 < 1 || choice3 >2)
				{
				System.out.println("Invalid selection, please try again: ");
				choice3 =s.nextInt();
				}
				if (choice3 ==1)
				{
					System.out.println("You strike again and again as the bones collapse by your might.");
					System.out.println("You thrust out both your arms and the chamber goes silent as you smash the last skull to dust");
					System.out.println("");
					System.out.println("type (ok) then Press enter to continue");
					emp = s.next();
					System.out.println("You feel a pain in your arm and look to see your viens glowing red!");
					eventRooms.get(0).EventTrue();
					players.get(c).score =(players.get(c).score- 700);
				}
				else 
				{
					System.out.println("You keep cutting down the skelentons as fast as they appear until the chamber goes silent");
					players.get(c).score =(players.get(c).score- 300);
					CurrentRoom= rooms.get(2);
				}
			}
			else if (choice2 == 3)
			{
				System.out.println("You strike again and again as the bones collapse by your might.");
				System.out.println("You thrust out both your arms and the chamber goes silent as you smash the last skull to dust");
				System.out.println("");
				System.out.println("type (ok) then Press enter to continue");
				emp = s.next();
				System.out.println("You feel a pain in your arm and look to see your viens glowing red!");
				eventRooms.get(0).EventTrue();
				players.get(c).score =(players.get(c).score- 500);
			}
				
		}
		else if (choice == 4 & lastChoice ==3)
		{	
			System.out.println("You swing your sword with all your might taking off the skelenton's head!");
			System.out.println("");
			System.out.println("type (ok) then Press enter to continue");
			String emp = s.next();
			System.out.println("The bones beneath your feet begin to tremble. They rise upright and form numerous skelentons that surround you!");
			System.out.println("It seems the more you slash away the more enemies appear");
			System.out.println("You become swarmed and fall. the flesh is ripped from your body until your bones become one with the room");
			choice = 0;
			players.get(c).score =(players.get(c).score- 2000);
			System.out.println("");
			System.out.println("The End");
			System.out.println("You did not survive the hollow");
			System.out.println(players.get(c).name);
			System.out.println("score: "+ players.get(c).score);
			System.out.println("type (ok) then Press enter to continue");
			emp = s.next();
		}
		lastChoice = choice;
		if (lastChoice !=0)
		{
			System.out.println("");
			System.out.println(CurrentRoom);
			System.out.println("");
			System.out.println("you take a key out of the pile of bones and continue down the path.");
			System.out.println("Light begins to emit from the end of the dim trail and you follow it until you reach an iron gate");
			System.out.println("You use the key and enter the room after lifting the gate");
			System.out.println("You are amazed by the fortune of treasures and trinkets placed just infront of the exit");
			System.out.println("");
			System.out.println("1. Take as much treasure as you can carry and leave");
			System.out.println("2. Just leave it isnt worth the risk");
	
			choice = s.nextInt();
			while(choice < 1 || choice > 2)
				{
				System.out.println("Invalid selection, please try again: ");
				choice =s.nextInt();
				}
			if (eventRooms.get(0).getDecision()==true)
			{
				if (choice ==1)
				{
					System.out.println("You gather as much as you can carry and head for the exit");
					System.out.println("You are stopped in your tracks and begin to writhe in pain");
					System.out.println("");
					System.out.println("Your arm burns red and your viens feel set ablaze");
					System.out.println("The last thing you see is the light eclipsed by falling rocks.");
					players.get(c).score =(players.get(c).score- 1000);
					System.out.println("");
					System.out.println("");
					System.out.println("The End");
					System.out.println("You did not survive the hollow");
					System.out.println(players.get(c).name);
					System.out.println("score: "+ players.get(c).score);
					System.out.println("type (ok) then Press enter to continue");
				String emp = s.next();
				}
				else 
				{
					players.get(c).score =(players.get(c).score- 200);
					System.out.println("The End");
					System.out.println("Congratulations! you survived the hollow!");
					System.out.println("");
					System.out.println("");
					System.out.println(players.get(c).name);
					System.out.println("score: "+ players.get(c).score);
					System.out.println("type (ok) then Press enter to continue");
					String emp = s.next();
				}
			}
			else
			{
				if (choice ==1)
				{
					
					System.out.println("The End");
					System.out.println("Congratulations! you survived the hollow!");
					System.out.println("");
					System.out.println("");
					System.out.println(players.get(c).name);
					System.out.println("score: "+ players.get(c).score);
					System.out.println("type (ok) then Press enter to continue");
					String emp = s.next();
				}
				else
				{
					players.get(c).score =(players.get(c).score- 500);
					System.out.println("The End");
					System.out.println("Congratulations! you survived the hollow!");
					System.out.println("");
					System.out.println("");
					System.out.println(players.get(c).name);
					System.out.println("score: "+ players.get(c).score);
					System.out.println("type (ok) then Press enter to continue");
					String emp = s.next();
				}
			}
			eventRooms.get(0).EventFalse();
		}
	}
}