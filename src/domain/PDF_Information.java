package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KaanBasal on 6/17/2014.
 */
public class PDF_Information {

    String title;
    ArrayList<Author> authors;
    long publish_day;
    List<String> keywords;

    public PDF_Information(String title, ArrayList<Author> authors, long publish_day, List<String> keywords) {
        this.title = title;
        this.authors = authors;
        this.publish_day = publish_day;
        this.keywords = keywords;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public long getPublish_day() {
        return publish_day;
    }

    public void setPublish_day(long publish_day) {
        this.publish_day = publish_day;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
}
