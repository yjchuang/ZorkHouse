import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ZorkHouseApp {

	public static void main(String[] args) {
		
		double totalMoney = 0.0;
		int totalRoomEntered = 0;
		String totalItemsSeen = "";
		int isDiscovered = 0;
		int chance;
		
		Scanner sc = new Scanner(System.in);
		
		//all 8 rooms
		//Room room1 = new Room("the Foyer", "a dead scorpion", " to the north (n) or the south (s)", 0.0, false);
		//roomList.add(room1);
		
		ArrayList<Room> roomList = new ArrayList<Room> ();
		
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
		room = roomList.get(0);		//default room to Foyer
		
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
			}	
			
			//giving room description, and getting direction choice from user
			roomDescribe(room.getName(), room.getItems(), room.getDirections());
			
			if(room.isVisited() == false)			//first time in this room
			{
				//getting and storing money from each room
				Random rnd = new Random();
				room.setMoney((double) rnd.nextInt(1001));
			}
			
			//get direction from user
			String choice = sc.next();
			if (roomList.indexOf(room) == 0)		//U are in Foyer
			{
				if (choice.equals("n"))
				{
					room = roomList.get(1);			//Front room
					room.setVisited(true);
				}
				else								//south: you are exiting the house
				{
					System.out.println("You are exiting the house");
					for (int i = 0; i < 8; ++i)
					{
						if(roomList.get(i).isVisited() == true)
						{
							++totalRoomEntered;
							totalMoney += roomList.get(i).getMoney();
							totalItemsSeen += roomList.get(i).getItems() + ", ";
						}
					}
					System.out.printf("You entered total %d room \n", totalRoomEntered);
					
					System.out.println("You saw " + totalItemsSeen);
					
					System.out.printf("You accumulated $%.2f\n", totalMoney);
					
					Random random = new Random();
					
					chance = random.nextInt(4);
					
					if (chance == 3) 
					{
						System.out.println("You are followed by a ghost of Zork");
					}
					else 
					{
						System.out.println("You are safe...for now");
					}
					
					nextRoom = "n";
					//break;						//user wants to exit the house
				}
					
			}
			else if(roomList.indexOf(room) == 1)	//U are in Front Room
			{
				if (choice.equals("e"))
				{
					room = roomList.get(3);			//Kitchen
					room.setVisited(true);
				}
				else if (choice.equals("w"))
				{
					room = roomList.get(2);			//Library
					room.setVisited(true);
				}
				else								//south
				{
					room = roomList.get(0);			//Foyer
					room.setVisited(true);
				}
				
			}else if(roomList.indexOf(room) == 2)	//U are in Library
			{
				if (choice.equals("n"))
				{
					room = roomList.get(4);			//Dining Room
					room.setVisited(true);
				}
				else 								//east
				{
					room = roomList.get(1);			//Front Room
					room.setVisited(true);
				}
				
			}else if(roomList.indexOf(room) == 3)	//U are in Kitchen
			{
				if (choice.equals("w"))
				{
					room = roomList.get(1);			//Front Room
					room.setVisited(true);
				}
				else								//north
				{
					room = roomList.get(6);			//Parlor
					room.setVisited(true);
				}
				
			}else if(roomList.indexOf(room) == 4)	//U are in Dining Room
			{
				
				room = roomList.get(2);				//only south to Library
				room.setVisited(true);
				
			}else if(roomList.indexOf(room) == 5)	//U are in Vault
			{
				if (isDiscovered == 1 && choice.equals("s"))
				{
					room = roomList.get(7);			//to the secret room	
					room.setVisited(true);
				}
				else								//only to Parlor
				{
					room = roomList.get(6);	
					room.setVisited(true);
				}
				
				
			}else if(roomList.indexOf(room) == 6)	//U are in Parlor
			{
				if (choice.equals("s"))
				{
					room = roomList.get(3);			//Kitchen
					room.setVisited(true);
				}
				else 								//west
				{
					room = roomList.get(5);			//Vault
					room.setVisited(true);
				}
				
			}else if(roomList.indexOf(room) == 7)	//U are in the Secret room
			{
				room = roomList.get(5);				//west to the Vault
				room.setVisited(true);
			}
			else
			{
				System.out.println("Wrong room. Try again");
			}
		}
		
		sc.close();
	}
	
	
	public static void roomDescribe(String where, String stuff, String directions)
	{
		System.out.println("You are in " + where);
	
		System.out.println("You see " + stuff);
		
		System.out.println("You can go " + directions);
		
	}

}
