package extractor;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.xml.internal.ws.developer.MemberSubmissionEndpointReference;
import domain.Author;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tugce on 01.07.2014.
 */
public class Address_Extractor {

    public static List<String> extractAddress(String html, List<Author> authors) {

            List<String> addresses = new ArrayList<String>();
            Document doc = Jsoup.parse(html);
//        System.out.println(doc);
            Element paragraphs = null;

    String indexes[] = new String[authors.size()];
//    String index = "";


    for (int i = 0; i < authors.size(); i++) {//int olarak gelen sayıları string cevirdim.
        indexes[i] = String.valueOf(authors.get(i).getIndex());


        if (indexes[0].equals("0") == true)
            indexes[i] = String.valueOf(authors.get(i).getIndex());


//        else {
//            if(i < authors.size()-1)
//                indexes[i] = String.valueOf(authors.get(i).getIndex() + "~");
//
//            else
//                indexes[i] = String.valueOf(authors.get(i).getIndex());
//            }

        }

//        for(int i=0; i<indexes.length; i++)//string arrays olan indexes,string index cevirdi
//            index+= indexes[i];
        System.out.println(Arrays.toString(indexes));





    if(indexes[0].equals("0")==true && Character.isDigit((doc.select("p").set(0,paragraphs)).text().charAt(0))==false) {//index gelmediğinde 0 basıyor ve ilk pde sayı yoksa
        for (int i = 0; i <authors.size() ; i++) {
            System.out.println((doc.select("p").set(2, paragraphs)).text());
        }

    }
    else if (indexes[0].equals("0") == true && Character.isDigit((doc.select("p").set(0, paragraphs)).text().charAt(0)) == true) {//index yoksa ve ilk pde sayfa numrası var
        for (int i = 0; i < authors.size(); i++) {
            System.out.println((doc.select("p").set(3, paragraphs)).text());

        }
    }

        num(indexes,doc,paragraphs);












//        addresses.add(x);
//        System.out.println(x);


        return null;
    }



    public static void num(String indexes[],Document doc, Element paragraphs) {
        for (int i = 0; i < indexes.length; i++) {
            String pattern = indexes[i];
//            System.out.println(pattern);
            String pattern2;
            if (i + 1 >= indexes.length) {
                pattern2 = "~";
            } else {
                pattern2 = indexes[i + 1];
            }
            String text = doc.select("p").set(2, paragraphs).text() + "~";
            Pattern p = Pattern.compile(Pattern.quote(pattern) + "(.*?)" + Pattern.quote(pattern2));
            Matcher m = p.matcher(text);
            while (m.find()) {
                System.out.println(m.group(1));

            }
        }
    }
//        String div[] = new String[indexes.length];
//        div = index.split("~");
//        String pattern = null;
//        String pattern1 = null;
//
//        for (int i = 0; i < indexes.length; i++) {
//            pattern = div[i];
//            if (++i < indexes.length) {
//
//                pattern1 = div[i];
//                String text = doc.select("p").set(2, paragraphs).text() + 9;
//                Pattern p = Pattern.compile(Pattern.quote(pattern) + "(.*?)" + Pattern.quote(pattern1));
//                Matcher m = p.matcher(text);
//                while (m.find()) {
//                    System.out.println(m.group(1));
//
//                }
//            }
//        }





}
