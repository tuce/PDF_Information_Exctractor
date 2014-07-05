package metadata_extractor;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.util.PDFText2HTML;
import org.apache.pdfbox.util.PDFTextStripper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Array;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MetaData_Extractor {


    PDDocumentInformation metadata;

    PDDocument document;


    public MetaData_Extractor(PDDocument document) {
        this.document = document;

        this.metadata = document.getDocumentInformation();
    }

    public void extract_all_info() throws IOException {
        String title = metadata.getTitle();
        String keywords = metadata.getKeywords();
        String author = metadata.getAuthor();
        Calendar creationDate = metadata.getCreationDate();
        String producer = metadata.getProducer();
        String subject = metadata.getSubject();

        PDFText2HTML stripper = new PDFText2HTML("");
        stripper.setStartPage(1);
        stripper.setEndPage(1);
        stripper.setLineSeparator(" ");


         String html = stripper.getText(document);
        Document doc = Jsoup.parse(html);









              }
          }












//
//try {
//
//    System.out.println(paragraphs.text());
//}catch(IndexOutOfBoundsException e){
//    System.out.println(e.getMessage());
//}


//        System.out.println(stripper.getTitle());
//        System.out.println(author);
//        System.out.println(subject);
//        System.out.println(creationDate.toString());
//        System.out.println(producer);






