package sampleproject;

public class Sampleclass {
	
	// Variables Declarations
	private int[] data;
	private int manyItems;
	
	//Class Constructors
	public Sampleclass()
	{
		int INITIAL_CAPACITY = 10;
		manyItems = 0;
		data = new int[INITIAL_CAPACITY];

	}

	public Sampleclass(int initialCapacity)
	{
		if(initialCapacity < 0)
			throw new IllegalArgumentException
			("initialCapacity is negative: " + initialCapacity);
		manyItems = 0;
		data = new int[initialCapacity];

	}
	
	
	//Class Methods
	public void add(int element)
	{
		if(!contains(element))
		{
			if(manyItems == data.length)
			{
				//Double the capacity and add 1; this works even if manyItems is 0.
				ensureCapacity(manyItems*2 + 1);
			}

			data[manyItems] = element;
			manyItems++;

		}

	}

	public void addAll(Sampleclass addend)
	{
		// If addend is null, then a NullPointerException is thrown.
		// In the case that the total number of items is beyond Integer.MAX_VALUE, there will
		// be an arithmetic overflow and the set will fail


		ensureCapacity(manyItems + addend.manyItems);

		System.arraycopy(addend.data, 0, data, manyItems, addend.manyItems);
		manyItems += addend.manyItems;
		printSet();
		for(int index = 0; index < manyItems; index++)
		{

			for(int comIndex = index + 1; comIndex < manyItems; comIndex++)
			{
				if(data[index] == data[comIndex])
				{
					System.out.println("comparing " + data[index] + " and " + data[comIndex]);
					System.out.println("removing " + data[comIndex]);
					remove(data[comIndex]);

				}
			}
		}


	}
	
	public Object clone()
	{
		//Clone and Sampleclass object.
		Sampleclass answer;

		try
		{
			answer = (Sampleclass) super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			// This exception should not occur. But if it does, it would probably indicate a
			// programming error that made super.clone unavailable. The most common
			// error would be forgetting the "Implements Cloneable"
			// clause at the start of this class.
			throw new RuntimeException
			("This class does not implement Cloneable.");

		}

		answer.data = (int []) data.clone();
		return answer;

	}
	
	public boolean contains(int target)
	{
		// Postcondition: The return value is true if
		// target is in the set; otherwise the return value is false

		boolean answer;
		int index;

		answer = false;
		for(index = 0; index < manyItems; index++)
			if(target == data[index])
				answer = true;
		return answer;

	}

	public void ensureCapacity(int minimumCapacity)
	{
		int biggerArray[];

		if (data.length < minimumCapacity)
		{
			biggerArray = new int[minimumCapacity];
			System.arraycopy(data, 0, biggerArray, 0, manyItems);
			data = biggerArray;

		}

	}

	public int getCapacity()
	{
		return data.length;
	}

	public boolean remove(int target)
	{
		int index; // The location of target in the data array

		// First, set index to the location of target in the data array,
		// which could be as small as 0 or as large as mandyItems-1.
		// If target is not in the array, then index will be set equal to manyItems.
		for (index = 0; (index < manyItems) && (target != data[index]); index++)
			// No work is needed in the body of this for-loop.
			;

		if (index == manyItems)
			// The target was not found, so nothing was removed.
			return false;
		else
		{ // The target was found at data[index].
			manyItems--;
			data[index] = data[manyItems];
			return true;
		}

	}
	
	public int size()
	{
		return manyItems;

	}

	public void trimToSize()
	{
		int trimmedArray[];

		if (data.length != manyItems)
		{
			trimmedArray = new int[manyItems];
			System.arraycopy(data, 0, trimmedArray, 0, manyItems);
			data = trimmedArray;

		}

	}
	public void printSet()
	{
		int index;
		for(index = 0; index < manyItems; index++)
			System.out.println(data[index]);
	}

	public static void main(String[] args) {	
		
		Sampleclass sc = new Sampleclass();
		sc.printSet();


	}

}
