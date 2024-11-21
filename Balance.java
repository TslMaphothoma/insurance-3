import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;
public class Balance
{
	public static final String fileName = "C:\\Users\\TSLmaphothoma\\Documents\\Networking\\gitHub\\JOption\\receipt.txt";
	private int counter = 1,total = 0,count = 0;
	private String person = " ";
	private String[] members = new String[counter];
	private int[] ages = new int[counter];
	private char gender;
	
	public void setIndex(int counter)
	{
		this.counter = counter;
	}
	public void setDependants(String[] member, int[] ages)
	{
		members = member;
		this.ages = ages;
		determineAmount();
	}
	public void determineAmount()
	{
		for(int x = 0; x < counter; x++)
		{
			person = members[x];
			count = person.length();
			gender = person.charAt(count-1);
			if(gender == 'f')
			{
				if(ages[x] < 18)
				{
					members[x] = person + "\tR160 pm";
					total = total + 160;
				}
				else
				{
					members[x] = person + "\tR250 pm";
					total = total + 250;
					
				}
			}
			else if(gender == 'm')
			{
				if(ages[x] < 18)
				{
					members[x] = person + "\tR175 pm";
					total = total + 175;
				}
				else
				{
					members[x] = person + "\tR265 pm";
					total = total + 265;
				}
			}
		}
		System.out.println(
		"Name\tSurname\tAge\tGender\tAmount"+
		"\n=========================================================");
		for(int z = 0;z < counter; z++)
		{
			System.out.println(members[z]);
		}
		System.out.println(
		"\n==========================================================\n"+
		"  Total monthly payments of R"+total+
		"\n=========================================================\n");
		printReceipt(members, counter, total);
	}
	public void printReceipt(String[] membersFile, int counterFile,int totalFile)
	{
		int counter = 0,total= 0;
		String[] members = new String[counter];
		
		counter = counterFile;
		total = totalFile;
		members = membersFile;
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try
		{
			fw = new FileWriter(fileName,false);
			bw = new BufferedWriter(fw);
			
			bw.write("Name\tSurname\tAge\tAmount"+
			"\n===================================================\n");
			for(int x = 0;x < counter; x++)
			{
				bw.write(members[x]+"\n");
			}
			bw.write(
			"==================================================\n"+
			"Total monthly payments of R"+total+
			"\n==================================================\n");
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		finally
		{
			try
			{
				if(bw != null)
				{
					bw.close();
				}
				if(fw != null)
				{
					fw.close();
				}
			}
			catch(IOException nx)
			{
				nx.printStackTrace();
			}
		}
	}
}