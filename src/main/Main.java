package main;

import domain.Author;
import extractor.Address_Extractor;
import Title_Extractor.title_extractor;
import extractor.Author_Extractor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFText2HTML;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Tugce on 17.06.2014.
 */
public class Main {


    public static void main(String[] args) {
//        for (int i = 1; i <= 46; i++) {
            try {

//                System.out.println("Index: " + i);
                PDDocument doc = PDDocument.load(new File("C:\\Users\\Tugce\\Desktop\\Breast Cancer/b10.pdf"));


                PDFText2HTML stripper = new PDFText2HTML("");
                stripper.setStartPage(1);
                stripper.setEndPage(1);
                stripper.setLineSeparator(" ");
                String html = stripper.getText(doc);

                title_extractor.titlextraction(html);
                List<Author> authors = Author_Extractor.extractAuthors(html);
                List<String> strings = Address_Extractor.extractAddress(html, authors);


            } catch (IOException e) {
                e.printStackTrace();
            } catch (StringIndexOutOfBoundsException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            } catch(ClassCastException e){
                e.printStackTrace();
            } catch (NumberFormatException e){
                e.printStackTrace();
            }
        }

    }



