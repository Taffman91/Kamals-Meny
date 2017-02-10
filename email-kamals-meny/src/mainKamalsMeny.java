import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.*;

import java.io.*;

public class mainKamalsMeny {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String vecka = "Meny vecka: ";
		
		Document doc=Jsoup.connect("https://www.facebook.com/Kamalsrestaurang/").timeout(6000).get();
		String Text = doc.select("body p").text();
		System.out.println(Text);
		//yay
		}
	}