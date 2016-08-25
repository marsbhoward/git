package finalProject;

import java.util.ArrayList;

 public class Player 
{
	public ArrayList<Player> players;
	public int score;
	private int id;
	private int rank = id+1;
	public String name;

	
	public Player(String name ,int score,int rank,int id)
	{
		this.name = name;
		this.score= score;
		this.rank = rank;
		this.id= id;	
	}
	public String getName()
	{
		return this.name;
	}
	public int getScore()
	{
		return this.score;
	}
	public int getRank()
	{
		return this.rank;
	}
	
	public void CompareRank(Player players)
	{
		if (this.score> players.score & this.rank >= players.rank)
		{
			this.rank = this.rank - 1;
			players.rank = players.rank+1;
		}
		  else if(this.score == players.score)
		  {
			  if (this.id < players.id)
			  {
				  this.rank=this.rank-1;
				  players.rank= players.rank+1;
			  }
			  else if(this.id > this.id)
			  {
				  this.rank = this.rank+1;
				  players.rank = players.rank- 1;
			  }
		  }
	}
	public int getId()
	{
		return this.id;
	}
	public void AddId()
	{
		this.id= this.id+1;
	}
	public String toString()
	{
		if (this.score > 1000) 
			{
			return this.score +"   "+ this.rank+"    "+ this.name; 
			}
		else
		{
			return this.score +"    "+ this.rank+"    "+ this.name;
		}
	}
	public static void main(String args[])
	{
		Player Player1= new Player("Mars",450,1,0);
		Player Player2= new Player("Howard",450,2,1);
		Player Player3= new Player("Dave",550,3,2);

		System.out.println(Player1);
		System.out.println(Player1.name);
		Player2.CompareRank(Player1);
		Player3.CompareRank(Player2);
		Player3.CompareRank(Player1);
		System.out.println(Player1);
		System.out.println(Player2);
		System.out.println(Player3);
	}
}
