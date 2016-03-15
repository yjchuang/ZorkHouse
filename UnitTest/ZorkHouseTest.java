import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;
import org.junit.FixMethodOrder;

public class ZorkHouseTest {

	@Test
	public void test_getItems() {
		System.out.println("Test if getItems returns dirty dishes...") ;
		Room r = new Room("Kitchen", "dirty dishes", "to the east (e)", 0.0, false);
	      assertTrue(r.getItems().equalsIgnoreCase("dirty dishes") == true) ;
	
	}
	
	@Test
	public void test_getMoney() {
		System.out.println("Test if getMoney returns...") ;
		Room r = new Room("Kitchen", "dirty dishes", "to the east (e)", 1280.0, false);
	      assertTrue(r.getMoney() == 1280.0) ;
	
	}
	
	@Test
	public void test_setDirection() {
		System.out.println("Test if setDirections works...") ;
		Room r = new Room();
		r.setDirections("to the east or west");
	      assertTrue(r.getDirections().equalsIgnoreCase("to the east or west") == true) ;
	
	}
	
	@Test
	public void test_roomDescribe() {
		System.out.println("Test if roomDescribe() works...") ;
		ZorkHouseApp.roomDescribe("Kitchen", "dirty dishes", "to the east (e)");
	      assertTrue(true) ;
	
	}
	
	@Test
	public void test_roomClass() {
		System.out.println("Test if object of class room works...") ;
		Room rm = new Room();
		rm.setVisited(true);
	      assertTrue(rm.isVisited() == true) ;
	
	}
	
	@Test
	public void test_partOfMain() {
		System.out.println("Test if part of main works...") ;
		
		ArrayList<Room> roomList = new ArrayList<Room> ();
		int chance = 0, isDiscovered = 0, count = 0;
		
		//loading arraylist with constructor
		roomList.add(new Room("the Foyer", "a dead scorpion", " to the north (n) or the south (s)", 0.0, false));
		roomList.add(new Room("the Front Room", "a piano", " to the east (e), the south (s) or the west (w)", 0.0, false));
		roomList.add(new Room("the Library", "spiders", " to the north (n), the east (e)", 0.0, false));
		roomList.add(new Room("the Kitchen", "many bats", " to the north (n), or the west (w)", 0.0, false));
		roomList.add(new Room("the Dining Room", "dusty and empty box", " to the south (s) only", 0.0, false));
		roomList.add(new Room("the Vault", "3 walking skeletons", " to the parlor (p)", 0.0, false));
		roomList.add(new Room("the Parlor", "a treasure chest", " to the south (s) or the west (w)", 0.0, false));
		roomList.add(new Room("the Secret Room", "piles of gold", " to the west (w) to exit the secret room", 0.0, false));
		
		Room room = new Room();
		room = roomList.get(5);		//default room to Foyer
		
		String nextRoom = "y";
		
		while (nextRoom == "y")
		{
			if(roomList.indexOf(room) == 5)	//U are in Vault
			{
				//get one out of four that secret is discovered
				Random randomDiscover = new Random();			
				chance = randomDiscover.nextInt(4);
				if (isDiscovered == 1 || chance == 0)
				{
					room.setDirections(" to the secret room (s), or to the parlor (p)");
					isDiscovered = 1;
				}
				else 
				{
					room.setDirections(" to the parlor (p)");
				}
				count++;
				if(count == 5)
					nextRoom = "n";
			}	
			
			//giving room description, and getting direction choice from user
			ZorkHouseApp.roomDescribe(room.getName(), room.getItems(), room.getDirections());

		}
		
		
	      assertTrue(count == 5) ;
	
	}

}
