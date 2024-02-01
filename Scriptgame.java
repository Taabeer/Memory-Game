import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Scriptgame 
{
	public Linkedlist characterlines;
	public Linkedlist cuelines;
	public Linkedlist fullscript;
	public void script(String searchword,Linkedlist characterlines,Linkedlist cuelines,Linkedlist fullscript) throws FileNotFoundException 
	{
		File script= new File("script.txt");
		FileReader fr= null;
		fr=new FileReader(script);
		BufferedReader br= new BufferedReader(fr);
		String str=null;
		String currentdata=null;
		int fullscriptlength=0;
		try 
		{
			while ((str=br.readLine())!=null)
			{
				fullscript.insert(fullscript, str);
			}
			fullscriptlength= fullscript.length(fullscript);
			Node createcharcue=new Node(null);
			createcharcue=fullscript.head;
			searchword=searchword+":";
			for (int i=0;i<fullscriptlength;i++) 
			{
				 currentdata=createcharcue.getData();
				 if (currentdata.contains(searchword)) 
				 {
					 characterlines.insert(characterlines, currentdata);
			    	 String cue=fullscript.positionfinder(fullscript, i-1);
			    	 cuelines.insert(cuelines, cue);
			     } 
				 createcharcue=createcharcue.getNext();
			}
			createcharcue=fullscript.head;
		}	
		catch (IOException ex) 
		{
			Logger.getLogger(Linkedlist.class.getName()).log(Level.SEVERE,null,ex);
		}
		
		String oldline;
		String changedline;
		int characterlineslength=characterlines.length(characterlines);
		Node modifycharlines=new Node(null);
		modifycharlines=characterlines.head;
			for (int x=0;x<characterlineslength;x++)
			{
				oldline=characterlines.positionfinder(characterlines, x);
				changedline=oldline.replaceAll(searchword, "");
				changedline=changedline.trim();
				modifycharlines.setData(changedline);
				modifycharlines=modifycharlines.getNext();
			}
		String searchstagedirection=":";
		int cuelineslength=cuelines.length(cuelines);
		Node modifyqlines=new Node(null);
		modifyqlines=cuelines.head;
			for (int x=0;x<cuelineslength;x++)
			{
				String currentcuedata=modifyqlines.getData();
				if (!currentcuedata.contains(searchstagedirection))
				{
				String oldirection=currentcuedata;
				String newdirection=("Stage direction: "+oldirection);
				modifyqlines.setData(newdirection);
				}
				modifyqlines=modifyqlines.getNext();
			}			
	} 
	public static int Levenshtein_distance(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        char[] input = str1.toCharArray(); 
    	char [] charline=str2.toCharArray();
        int distance=0;
        int lengthString1= str1.length();
        int lengthString2=str2.length();
    	char[]inputfinarray= new char [lengthString1+1];
    	inputfinarray[0]='\s';
    	char[]charlinefinarray= new char [lengthString2+1];
    	charlinefinarray[0]='\s';
        for (int i=1;i<=lengthString1;i++) 
        {
        	inputfinarray[i]=input[i-1];
        }
        for (int i=1;i<=lengthString2;i++) 
        {
        	charlinefinarray[i]=charline[i-1];
        }
        for (int i = 0; i <= lengthString1; i++) 
        {
        	dp[i][0]=i;
        }
        for (int i=0;i<=lengthString2;i++) {
        	dp[0][i]=i;
        }
        
        for (int row=1; row<lengthString1+1;row++) 
        {
        	for (int col=1;col<lengthString2+1;col++) 
        	{
        		if (inputfinarray[row]==charlinefinarray[col]) 
        		{
        			dp[row][col]=dp[row-1][col-1];
        		}
        		else 
        		{
        			int replace= dp[row-1][col-1];
        			int delete= dp[row-1][col];
        			int insert= dp[row][col-1];
        			int smallest= Math.min(replace, delete);
        			int confirmsmallest=Math.min(smallest, insert);
        			dp[row][col]= confirmsmallest+1;
        		}
        	}
        	
        }
        distance= dp[dp.length-1][dp[0].length-1];
        return distance;
	}	
	public static void main(String[] args) throws InterruptedException, IOException
    { 
		Scriptgame scriptgame= new Scriptgame();
		Linkedlist fullscript=new Linkedlist();
		Linkedlist characterlines=new Linkedlist();
		Linkedlist cuelines=new Linkedlist();
		Linkedlist incorrectlines=new Linkedlist();
		String line=null;
		JOptionPane.showMessageDialog(null, "Welcome to the script game");
		JOptionPane.showMessageDialog(null, "Please copy and paste your script into the script.txt file");
		String searchword= JOptionPane.showInputDialog("What character are you playing?");
		scriptgame.script(searchword, characterlines, cuelines, fullscript);
		while (fullscript.isEmpty(fullscript)==true) 
		{
			JOptionPane.showMessageDialog(null, "Script error, please ensure that your script is pasted correctly on the file titled script.txt");
		}
		while (characterlines.isEmpty(characterlines)==true) 
		{
			String retrysearchword= JOptionPane.showInputDialog("That character is not in the script. Please retype what character you are playing");
			scriptgame.script(retrysearchword, characterlines, cuelines, fullscript);
		}
		int charlinelength= characterlines.length(characterlines);
		JOptionPane.showMessageDialog(null, "You will be presented with your cue line, you must then type your character line");
		boolean contplaying=true;
		while (contplaying==true) 
		{
			for (int i=0;i<charlinelength;i++) 
			{
					line= JOptionPane.showInputDialog(cuelines.positionfinder(cuelines, i));
					String correctline= characterlines.positionfinder(characterlines, i);
					int Levenshteindistance= Levenshtein_distance(line, correctline);
					if (line.equals(characterlines.positionfinder(characterlines, i))) 
					{
						JOptionPane.showMessageDialog(null, "Correct, good job!");
					}
					else if (correctline.length()>5&&Levenshteindistance<3) 
					{
							JOptionPane.showMessageDialog(null, "There was a minor typo in the line you typed. It will still be counted as correct.");
						
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Incorrect :(");
						JOptionPane.showMessageDialog(null, "The correct line is: "+characterlines.positionfinder(characterlines, i));
						String correct="Your cue line-  "+cuelines.positionfinder(cuelines, i)+"\n"+"Your character line-  "+characterlines.positionfinder(characterlines, i);
						if (incorrectlines.duplicateCheck(incorrectlines, correct)==false) 
						{
							incorrectlines.insert(incorrectlines, correct);
						}
					}
			}			
			JOptionPane.showMessageDialog(null, "You can choose to play another round of the game");
			String cont= JOptionPane.showInputDialog("Would you like to play another round? Type yes or no");
			if (cont.equals("yes")||cont.equals("YES")||cont.equals("Yes"))
			{
				contplaying=true;
			}
			else if (cont.equals("no")||cont.equals("NO")||cont.equals("No")) 
			{
				JOptionPane.showMessageDialog(null, "Thank you for playing the script game");
				JOptionPane.showMessageDialog(null, "You can access a revision resource named incorrect.txt");
				JOptionPane.showMessageDialog(null, "Here, you will find a list of character and cue lines");
				JOptionPane.showMessageDialog(null, "These are the lines you struggled with the most when playing this game");
				contplaying=false;
			}
			else 
			{
				cont= JOptionPane.showInputDialog("Invalid input, please type yes or no");
			}
		}
		if (!incorrectlines.isEmpty(incorrectlines)) 
		{
			String wrong=incorrectlines.toString(incorrectlines);
			try 
			{
				File incorrect= new File ("incorrect.txt");
				incorrect.delete();
				incorrect.createNewFile();
				FileWriter myWriter= new FileWriter ("incorrect.txt");
				myWriter.write(wrong);
				myWriter.close();
			}
			catch (IOException e)
			{
				System.out.println(e.toString());
	
			}
		}
    }
}
