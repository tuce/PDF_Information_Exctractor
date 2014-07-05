package extractor;

import com.sun.xml.internal.ws.developer.MemberSubmissionEndpointReference;
import domain.Author;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tugce on 01.07.2014.
 */
public class Address_Extractor {

    public static List<String> extractAddress(String html, List<Author> authors){
        List<String> addresses = new ArrayList<String>();
        Document doc = Jsoup.parse(html);
//        System.out.println(doc);
        Element paragraphs=null;

        for (int i = 0; i < authors.size(); i++) {
            String indexs[] = String.valueOf(authors.get(i).getIndex());






        }
        if((doc.select("p").set(2,paragraphs)!=null)){
            System.out.println(doc.select("p").set(2,paragraphs).text());
        }
//        addresses.add(x);
//        System.out.println(x);
        return null;
    }

}
