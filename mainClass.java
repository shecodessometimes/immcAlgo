package immc;

import java.util.ArrayList;
import java.util.Arrays;

public class mainClass 
{
	public static void main(String[] args) 
	{
		ArrayList<person> people = new ArrayList<person>();
		map currentMap = new map();
		
		currentMap.printMap();
		//each counter is approximately 1-2 minutes
		for (int i = 0; i<3; i++)
		{
			System.out.println("");
			System.out.println("Start of iteration "+i);
			for (person p:people)
			{
				//remove people from previous step
				currentMap.removeItem(p.getRow(), p.getCol());
				//perform action
				p.randomAction(currentMap);
				//delete person if finished
				if (currentMap.onCashRegistar(p.getRow(), p.getCol()))
				{
					people.remove(p);
				}
				//put person back in
				currentMap.addItem(p.getRow(), p.getCol());
			}
			newPeople(people, currentMap);
			System.out.println("");
			System.out.println("After iteration "+i);
			currentMap.printMap();
		}
	}

	private static void newPeople(ArrayList<person> people, map currentMap) 
	{
		int number = (int)(Math.random()*5);
		
		for (int i = 0; i<number; i++)
		{
			people.add(new person(currentMap.getDoorY(), currentMap.getDoorX()));
			currentMap.addItem(currentMap.getDoorY(), currentMap.getDoorX());
		}
	}

}
