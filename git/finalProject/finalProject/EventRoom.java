package finalProject;

public class EventRoom extends Room{
	
	private boolean decision;
	
	public EventRoom (String Name, boolean decision)
	{
		super(Name);
		this.decision = false;
	}
	public void EventTrue()
	{
		this.decision= true;
	}
	public void EventFalse()
	{
		this.decision= false;
	}
	public boolean getDecision()
	{
		return this.decision;
	}
}
