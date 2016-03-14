
public class Room {
	private String name;
	private String items;
	private String directions;
	private double money;
	private boolean isVisited;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public String getDirections() {
		return directions;
	}
	public void setDirections(String directions) {
		this.directions = directions;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public boolean isVisited() {
		return isVisited;
	}
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	public Room(String name, String items, String directions, double money, boolean isVisited) {
		this.name = name;
		this.items = items;
		this.directions = directions;
		this.money = money;
		this.isVisited = isVisited;
	}
	public Room() {
		
	}
	
	
	
}
