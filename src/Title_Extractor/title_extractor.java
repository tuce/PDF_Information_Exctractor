package Title_Extractor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class title_extractor {

    public static String titlextraction(String html){
        String title = "";
        Document doc = Jsoup.parse(html);
                Element paragraphs = doc.select("p").first();
        if (Character.isDigit(paragraphs.text().charAt(0)) == true) try {

            paragraphs = doc.select("p>b").get(0);
            title = paragraphs.text();
            System.out.println(paragraphs.text());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        else {

            paragraphs = doc.select("p").first();
            title = paragraphs.text();
            System.out.println(paragraphs.text());
        }
        return title;
    }

}
