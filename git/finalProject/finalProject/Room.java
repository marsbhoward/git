package finalProject;

public class Room 
{
	private String room;
	
	public Room(String room)
	{
		this.room = room;
	}
	
	public String getRoom()
	{
		return this.room;
	}
	public String toString()
	{
		return "Room " + this.room; 
	}
	public static void main(String args[])
	{
		Room startRoom= new Room("Start Room");
		System.out.println(startRoom.getRoom());
	}
}
