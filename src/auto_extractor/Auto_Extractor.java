package auto_extractor;

import domain.Author;
import domain.PDF_Information;
import org.docear.pdf.PdfDataExtractor;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class Auto_Extractor {

    File pdf_file;
    PdfDataExtractor extractor;

    public Auto_Extractor(File pdf_file) {
        this.pdf_file = pdf_file;
        extractor = new PdfDataExtractor(pdf_file);
    }

    public PDF_Information extract_all_info() {
        return null;
    }

    private String extract_title() throws IOException {
        return extractor.extractTitle();
    }

    private long extract_publish_date() {
        return 0;
    }

    private List<String> extract_keywords() {
        return null;
    }

    private List<Author> extract_authors() {
        return null;
    }
}
