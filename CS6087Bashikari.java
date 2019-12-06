import java.io.File;
import java.util.*;

public class CS6087Bashikari {

	public static String[] putInHashTable(String[] hashTable, String line, int m) {
		
		long h = 0;
		int code = 0;
		
	    h = line.hashCode();
	    
	    if(h < 0) 
	    {
	    	h = h * -1;
	    }
	    
	    h = h % m;
	    
	    code = (int) h;
	    
	    while(hashTable[code] != null) 
	    {
	    	code++;	
	    }
	    
	    hashTable[code] = line;
	    
	    //System.out.println("The hash code for " + line + " is: " + code);
		
		return hashTable;
	}
	
	public static boolean doesExist(String[] hashTable, int m, String query) {
		
		boolean exist = false;
		long codeValue = 0;
		int codeValue2 = 0;
		String queryTest = new String();
		
		codeValue = query.hashCode();
		//System.out.println("codeValue = " + codeValue);
		if(codeValue < 0)
		{
			codeValue = codeValue * -1;
		}
		codeValue2 = (int) codeValue;
		//System.out.println("codeValue2 before % m = " + codeValue2);
		codeValue2 = codeValue2 % m;
		//System.out.println("codeValue2 after % m = " + codeValue2);
		
		queryTest = hashTable[codeValue2];
		
		while (queryTest != query && queryTest != null)
		{
			if(codeValue2 == m)
			{
				codeValue2 = 0;
			} else {
				codeValue2++;
			}
			
			if (queryTest.equals(query)) 
			{
				//System.out.println("The value for code " + codeValue2 + " is: " + hashTable[codeValue2]);
				exist = true;
				//break;
			}
			
			//System.out.println("queryTest = " + queryTest + ".");
			//System.out.println("query = " + query + ".");
			
			queryTest = hashTable[codeValue2];
		}
		
		return exist;
	}
	
	public static int findHashCode(String[] hashTable, int m, String query) {
		
		long codeValue = 0;
		int codeValue2 = 0;
		
	    //for (int i = 0; i < hashTable.length; i++)
	    //	System.out.println("key = " + i + " value = " + hashTable[i]);
		
		codeValue = query.hashCode();
		//System.out.println("codeValue = " + codeValue);
		if(codeValue < 0)
		{
			codeValue = codeValue * -1;
		}
		codeValue2 = (int) codeValue;
		//System.out.println("codeValue2 before % m = " + codeValue2);
		codeValue2 = codeValue2 % m;
		//System.out.println("codeValue2 after % m = " + codeValue2);
		
		if(hashTable[codeValue2] == null)
		{
			System.out.println("The hash code for " + query + " does not exist.");
		} else if (hashTable[codeValue2] != query)
		{
			while(hashTable[codeValue2] != query && hashTable[codeValue2] != null) 
			{
				if (codeValue == m) {
					codeValue2 = 0;
				}else {
					codeValue2++;
				}
			}
			if(hashTable[codeValue2] == query)
			{
				System.out.println("The hash code for " + query + " is: " + codeValue2);
			}else if (hashTable[codeValue2] == null) {
				//System.out.println("The hash code for " + query + " does not exist.");
			}
		}
		
		/*
		for(int i = 0; i < m; i++)
		{
			if(hashTable[i] == query)
			{
				codeValue = i;
				System.out.println("The hash code for " + query + " is: " + codeValue);
			}
		}
		*/
		
		codeValue2 = codeValue2 - 1;
		
		return codeValue2;
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(new File("inputData7B.txt"));
		String[] list = new String[41];
		String[] hashTable = new String[41];
	    int j = 0;
	    int codeValue = 0;
	    int m = hashTable.length;
	    boolean existBoston = false;
	    boolean existBrussels = false;
	    boolean existShanghai = false;
	        
	    while (in.hasNextLine())
	    {
	        list[j] = in.nextLine();
	        hashTable = putInHashTable(hashTable, list[j], m);
	        j++;
	    }
	    
	    //for (int i = 0; i < hashTable.length; i++)
	    //	System.out.println("key = " + i + " value = " + hashTable[i]);	    
		
	    System.out.println("---------Assignment Output---------");
		//what is the table size you used?
		System.out.println("The size of the hash table is: " + m);
		
		//what is the hash code for these: Boston, Brussels, and Pleasantville?
		codeValue = findHashCode(hashTable, m, "Boston");
		System.out.println("The hash code for Boston is " + codeValue);
		codeValue = findHashCode(hashTable, m, "Brussels");
		System.out.println("The hash code for Brussels is " + codeValue);
		codeValue = findHashCode(hashTable, m, "Pleasantville");
		System.out.println("The hash code for Pleasantville is " + codeValue);
		
		//is Boston Found?		
		existBoston = doesExist(hashTable, m, "Boston");
		if(existBoston == true)
		{
			System.out.println("Boston has been found.");
		} else {
			System.out.println("Boston has not been found.");
		}
		//is Brussels found?
		existBrussels = doesExist(hashTable, m, "Brussels");
		if(existBrussels == true)
		{
			System.out.println("Brussels has been found.");
		} else {
			System.out.println("Brussels has not been found.");
		}
		//is Shanghai found?
		existShanghai = doesExist(hashTable, m, "Shanghai");
		if (existShanghai == true)
		{
			System.out.println("Shanghai has been found.");
		} else {
			System.out.println("Shanghai has not been found.");
		}
		
		//test
		/*
		if(hashTable[10].equals("Boston"))
		{
			System.out.println("Code 10 = Boston");
		}
		
		if(hashTable[12].equals("Brussels"))
		{
			System.out.println("Code 12 = Brussels");
		}
		
		if(hashTable[3].equals("Pleasantville"))
		{
			System.out.println("Code 3 = Pleasantville");
		}
		*/
		
		in.close();
	}
}
