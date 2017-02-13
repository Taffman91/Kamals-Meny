import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.*;

public class mainKamalsMeny {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		boolean send_mail = false;
		
		//Connect to the website using Jsoup
		Document doc=Jsoup.connect("https://www.facebook.com/Kamalsrestaurang/").timeout(6000).get();
		//Get it as outHtml text
		String Text = doc.select("body p").outerHtml();
		//Regex add linebreak at all <br>
		Text = Text.replaceAll("(.<br>)", "$1\n");
		//Regex Remove all html tags
		Text = Text.replaceAll("<.*?>","");
		//remove everything after Välkomna!
		Text = Text.split("Välkomna!")[0]+"Välkomna!";
		// System.out.println(Text);
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("file2.txt"));
			out.write(Text);
			out.close();
		}
			catch(IOException e1) {
				System.out.println("Error during reading/writing out");
		}
		
		//compare the two files
		send_mail = compare("file.txt", "file2.txt");
	          
		System.out.println(send_mail);
		
		if(send_mail)
		{
			//Write to file.txt for comparison and send mail
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter("file.txt"));
				out.write(Text);
				out.close();
			}
				catch(IOException e1) {
					System.out.println("Error during reading/writing out");
			}
		}
	}
	
	public static boolean compare(String file1, String file2) throws IOException {
		FileInputStream fstream1 = new FileInputStream(file1);
	      FileInputStream fstream2 = new FileInputStream(file2);

	      DataInputStream in1= new DataInputStream(fstream1);
	      DataInputStream in2= new DataInputStream(fstream2);

	      BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
	      BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));

	      String strLine1, strLine2;


	      while((strLine1 = br1.readLine()) != null && (strLine2 = br2.readLine()) != null){
	          if(!strLine1.equals(strLine2)){
	        	  fstream1.close();
		          fstream2.close();
		          in1.close();
		          in2.close();
		          br1.close();
		          br2.close();
	              return true;
	          }
	      }
	      fstream1.close();
          fstream2.close();
          in1.close();
          in2.close();
          br1.close();
          br2.close();
	      return false;
	}
}