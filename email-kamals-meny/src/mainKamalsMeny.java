import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.*;

import java.io.*;

public class mainKamalsMeny {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Document d=Jsoup.connect("https://www.facebook.com/Kamalsrestaurang/").timeout(6000).get();
		String str = Jsoup.connect("https://www.facebook.com/Kamalsrestaurang/").get().text();
		
		System.out.println(str);
		
		String title = d.title();
		System.out.println("Title:"+title);
		
		Elements links = d.select("div[class]");
		Elements meny =d.select("Meny vecka 6");
		
		int antal = 0;
			
		die:
		
		for (Element link: links)
		{
			System.out.println("\nLink: "+link.attr("<p>"));
			System.out.println("text: "+link.text());
			
			antal++;
			if (antal > 70)
				break die;
		}
	}
}
