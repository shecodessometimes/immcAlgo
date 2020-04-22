package immc;
public class map 
{
	private item[][] map;
	private int stolen;
	private int bought;
	private int initialItems;
	private int doorX;
	private int doorY;
	
	public map()
	{
		map=newMap();
		stolen=0;
		bought=0;
	}

	private item[][] newMap() 
	{
		//set number of items to what you need. only in this class, because it might change based on the map.
		initialItems=50;
		
		item cReg = new item("cash register");
		item door = new item("door");
		
		item[][] array = new item[][] {
		    {wall(), wall(), wall(), wall(), wall(), wall(), wall(), wall(), wall(), wall()},
		    {wall(), path(), path(), path(), path(), path(), path(), path(), path(), wall()},
		    {wall(), path(), hPhn(), hPhn(), hPhn(), hPhn(), hPhn(), hPhn(), path(), wall()},
		    {wall(), path(), path(), path(), path(), path(), path(), path(), path(), wall()},
		    {wall(), path(), hPhn(), hPhn(), hPhn(), hPhn(), hPhn(), hPhn(), path(), wall()},
		    {wall(), path(), path(), path(), path(), path(), path(), path(), path(), wall()},
		    {wall(), path(), path(), path(), hPhn(), path(), hPhn(), path(), hPhn(), wall()},
		    {wall(), path(), path(), path(), hPhn(), path(), hPhn(), path(), hPhn(), wall()},
		    {wall(), cReg, cReg, path(), path(), path(), hPhn(), path(), hPhn(), wall()},
		    {wall(), wall(), wall(), wall(), wall(), wall(), wall(), door, wall(), wall()},
		    {wall(), wall(), wall(), wall(), wall(), wall(), wall(), wall(), wall(), wall()},
		};
		
		doorX=7;
		doorY=9;
		
		return array;
	}
	
	private item wall() 
	{
		return new item("wall");
	}
	
	private item hPhn() 
	{
		return new item("bd D earbuds", 25, 44.6);
	}

	private item path() 
	{
		return new item("-");
	}

	public void addItem(int r, int c)
	{
		map[r][c].addItem();
	}
	
	public void removeItem(int r, int c, boolean damage)
	{
		//this part of the code is irrelevant for now, but it's here if we need it.
		if (map[r][c].currentItems()!=0)
		{
			if (damage)
			{
				stolen++;
			}
			else
			{
				bought++;
			}
		}
		
		//change number of items available. doesn't decrease if number of items is 0.
		map[r][c].removeItem();
	}
	
	public void removeItem(int r, int c)
	{
		map[r][c].removeItem();
	}
	
	public int getDoorX()
	{
		return doorX;
	}
	
	public int getDoorY()
	{
		return doorY;
	}

	public boolean onCashRegistar(int r, int c) 
	{
		if (map[r][c].getItemId()=="cash register")
		{
			return true;
		}
		return false;
	}
	
	public boolean pathAhead(int r, int c)
	{
		if (map[r][c].getItemId().equals("-"))
		{
			return true;
		}
		return false;
	}
	
	public boolean isWall(int r, int c) 
	{
		if (map[r][c].getItemId()=="wall")
		{
			return true;
		}
		return false;
	}
	
	public int getNumInitial()
	{
		return initialItems;
	}
	
	public int getNumStolen()
	{
		return stolen;
	}
	
	public int getNumBought()
	{
		return bought;
	}

	public void printMap() 
	{
		for (int r=0; r<map.length; r++)
		{
			for (int i = 0; i<17*10+1; i++)
			{
				System.out.print("-");
			}
			System.out.println();
			for (int c=0; c<map[0].length; c++)
			{
				if (map[r][c].equals(null))
				{
					System.out.print("|"+center("null"));
				}
				else
				{
					System.out.print("|"+center(map[r][c].toString()));
				}			}
			System.out.println("|");
		}
		for (int i = 0; i<17*10+1; i++)
		{
			System.out.print("-");
		}
		System.out.println();
	}
	
	public String center(String string)
	{
		int totalSpace=16;
		String newString="";
		if (string.length()<=totalSpace)
		{
			int firstHalf=(totalSpace-string.length())/2;
			for (int i = 0; i<firstHalf;i++)
			{
				newString+=" ";
			}
			newString+=string;
			for (int i = 0; i<totalSpace-string.length()-firstHalf;i++)
			{
				newString+=" ";
			}

		}
		else
		{
			newString=string.substring(0,totalSpace);
		}
		return newString;
	}
}
