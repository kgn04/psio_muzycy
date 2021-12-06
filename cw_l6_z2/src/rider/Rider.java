package rider;

public class Rider {
	
	private String przekaski;
	private String hotel;
	private boolean handsNeeded;
	private String stageSize;
	private int priority;
	
	public Rider(String przekaski, String hotel, boolean handsNeeded, String stageSize, int priority) {
		
		this.przekaski = przekaski;
		this.hotel = hotel;
		this.handsNeeded = handsNeeded;
		this.stageSize = stageSize;
		this.priority = priority;
		
		
	}
	
	//drukowanie konkretnego rideru
	public void drukuj(Rider rider) {
		
		
		System.out.println("Rider:");
		System.out.println("Przekaski: " + rider.getPrzekaski());
		System.out.println("Standard hotelu: " + rider.getHotel());
		System.out.println("Czy potrzebni handzi? " + rider.isHandsNeeded());
		System.out.println("Rozmiar sceny: " + rider.getStageSize());
		System.out.println("Priorytet: " + rider.getPriority());
		
		
	}
	
	
	
	
	
	

	public String getPrzekaski() {
		return przekaski;
	}

	public void setPrzekaski(String przekaski) {
		this.przekaski = przekaski;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public boolean isHandsNeeded() {
		return handsNeeded;
	}

	public void setHandsNeeded(boolean handsNeeded) {
		this.handsNeeded = handsNeeded;
	}

	public String getStageSize() {
		return stageSize;
	}

	public void setStageSize(String stageSize) {
		this.stageSize = stageSize;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
