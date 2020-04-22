package immc;

public class item 
{
	private int numberOfItems;
	private String itemId;
	private double popularity;
	
	public item(String givenItem) 
	{
		itemId=givenItem;
		numberOfItems=0;
		popularity=0;
	}
	
	public item(String givenItem, int givenNumber, double  givenPopularity) 
	{
		numberOfItems=givenNumber;
		itemId=givenItem;
		popularity=givenPopularity;
	}
	
	public void addItem()
	{
		numberOfItems++;
	}
	
	public void removeItem()
	{
		if (numberOfItems!=0)
		{
			numberOfItems--;
		}
	}
	
	public String getItemId()
	{
		return itemId;
	}
	
	public String toString()
	{
		if (itemId.contentEquals("cash register"))
		{
			return itemId;
		}
		return itemId+" "+numberOfItems;
	}

	public int currentItems() 
	{
		return numberOfItems;
	}
}
