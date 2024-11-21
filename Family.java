import javax.swing.JOptionPane;
public class Family
{
	public static void main(String[] args)
	{
		int date = 0,selection = 0;
		String name = " ", surname = " ",gender = " ";
		String[] mainMember = new String[1];
		int[] ages = new int[1];
		boolean addMember;
		Balance details = new Balance();
		
		name = JOptionPane.showInputDialog(null,"Please enter your name: ");
		surname = JOptionPane.showInputDialog(null,"Please enter your surname: ");
		date = Integer.parseInt(JOptionPane.showInputDialog(null,"What year were you born in ?"));
		gender = JOptionPane.showInputDialog(null,"What is your gender, press M for Male & F for female");
		selection = JOptionPane.showConfirmDialog(null,"Do you want to add members");
		addMember = (selection == JOptionPane.YES_OPTION);
		ages[0] = 2024-date;
		
		if(addMember == true)
		{
			JOptionPane.showMessageDialog(null,"You're "+name+" "+surname+" who is "+ages[0]+" years old and you have selected to add members\npress OK to continue");
			mainMember[0] = name+"\t"+surname+"\t"+ages[0]+"\t"+gender;
			members(mainMember,ages);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"You're "+name+" "+surname+" who is "+ages[0]+" years old and you have selected to not add members");
			mainMember[0] = name+"\t"+surname+"\t"+ages[0]+"\t"+gender;
			details.setDependants(mainMember,ages);
		}
	}
	public static void members(String[] mainMember, int[] ageMain)
	{
		String[] dependants = new String[10];
		int[] ages= new int[10];
		int counter = 1;
		String name = " ",surname = " ",gender = " ";
		int age = 0, date = 0, selection = 0;
		boolean addMember = false;
		Balance details = new Balance();
		
		ages[0] = ageMain[0];
		dependants[0] = mainMember[0];
		
		JOptionPane.showMessageDialog(null,
		"Additional Members"+
		"\n================================\n"+
		"Females > 18 R250 pm < 18 R160 pm\n"+
		"Males      > 18 R265 pm < 18 R175 pm"+
		"\n================================\n"+
		"press OK to continue");
		
		do
		{
			name = JOptionPane.showInputDialog(null,"Please enter your name: ");
			surname = JOptionPane.showInputDialog(null,"Please enter your surname: ");
			date = Integer.parseInt(JOptionPane.showInputDialog(null,"What year were you born in ?"));
			gender = JOptionPane.showInputDialog(null,"What is your gender, press M for Male & F for female");
			age = 2024 - date;
			dependants[counter] = name+"\t"+surname+"\t"+age+"\t"+gender;
			ages[counter]= age;
			counter++;
			selection = JOptionPane.showConfirmDialog(null,"Do you want to add another dependent");
			addMember = (selection == JOptionPane.YES_OPTION);
		}while(counter < 10 && addMember == true);
		details.setIndex(counter);
		details.setDependants(dependants, ages);
	}
}