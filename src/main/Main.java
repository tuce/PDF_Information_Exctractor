package main;

import metadata_extractor.MetaData_Extractor;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

/**
 * Created by Tugce on 17.06.2014.
 */
public class Main {



    public static void main(String[] args) {
        try {
            PDDocument doc = PDDocument.load(new File("c:\\article.pdf"));
            MetaData_Extractor metaData_extractor = new MetaData_Extractor(doc);
            metaData_extractor.extract_all_info();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
