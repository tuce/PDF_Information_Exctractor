package metadata_extractor;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.util.PDFText2HTML;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

/**
 * Created by KaanBasal on 6/17/2014.
 */
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

//        System.out.println(stripper.getArticleStart());
        System.out.println(stripper.getText(document));
//        System.out.println(stripper.getTitle());
//        System.out.println(author);
//        System.out.println(subject);
//        System.out.println(creationDate.toString());
//        System.out.println(producer);
    }

}
