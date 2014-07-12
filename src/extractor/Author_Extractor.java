package extractor;

import com.sun.org.apache.xpath.internal.SourceTree;
import domain.Author;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Author_Extractor {

    public static List<Author> extractAuthors(String html) {
        List<Author> authors = new ArrayList<Author>();

        Document doc = Jsoup.parse(html);
        Element paragraphs = null;//2 dersen 3.pde adres varsa basar.

        if (Character.isDigit((doc.select("p").set(0, paragraphs)).text().charAt(0)) == false) { // page numarasını var ilk sayfada

//            try {

                paragraphs = doc.select("p").set(1, paragraphs);
                Element ext_author = paragraphs;


                if (paragraphs.text().contains("and") == true) {//içinde sadece and varsa

                    String[] ext_author1 = ext_author.text().split("\\s*and+s*");
                    if (Arrays.toString(ext_author1).contains(",") == true)//içinde and olup vırgul varsa

                    {

                        String[] ext_author3 = ext_author.text().split(",");


                        for (int i = 0; i < ext_author3.length; i++) {

                            if (ext_author3[i].contains("and") == true) { //virgüllerin içinde and varsa

                                String[] ext_author4 = ext_author3[i].split("and");//and olanları array attı


                                for (int j = 0; j < ext_author4.length; j++) {//andları bastı

                                    String index = Arrays.asList(ext_author4[j].replaceAll("[^0-9]+", " ").trim().split(" ")).get(0);
                                    System.out.println("[i50]"+index);
                                    String name_surname = ext_author4[j].replaceAll("\\d", "").replace("∗", "").replace("*", "");
                                    System.out.println("[AuthorExctractor-51] "+ name_surname);
                                    Author author = new Author(Integer.parseInt(index), name_surname);
                                    authors.add(author);


                                }
                            } else//eger virgülleri arasında and yoksa vıgullerı bastı.
                            {
                                String index = Arrays.asList(ext_author3[i].replaceAll("[^0-9]+", " ").trim().split(" ")).get(0);
//                                System.out.println(index);

                                String name_surname = ext_author3[i].replaceAll("\\d", "").replace("∗", "").replace("*", "");


                                    if(Character.isDigit(ext_author3[i].charAt(0))== true) {//ustleri virgulle ayrılmıssa boslukları bastırmamak için
                                       ext_author3[i]=null;
                                        System.out.println("[authors-68]"+name_surname);
                                        Author author = new Author(Integer.parseInt(index), name_surname);
                                        authors.add(author);

                                    }
                                else {
//                                        System.out.println("[AuthorExctractor-62]" + ext_author3[i].replaceAll("∗","").replace("*",""));

//                                        System.out.println(index);

                                    }

                            }
                        }

                    } else if (Arrays.toString(ext_author1).contains(",") == false) {//içinde and olup vırgul yoksa

                        for (int i = 0; i < ext_author1.length; i++) {
                            Author author = new Author(ext_author1[i].replaceAll("\\d", "").replace("∗", "").replace("*", "").replace(",", ""));
                            authors.add(author);
                            System.out.println("[AuthorExctractor-64] "+ext_author1[i].replaceAll("\\d", "").replace("∗", "").replace(",", "").replace("*", ""));
                        }
                    }
                } else if (paragraphs.text().contains(",") == true) {//içinde sadece , varsa

                    String[] ext_author2 = ext_author.text().split(",");
                    for (int i = 0; i < ext_author2.length; i++) {
                        String index = Arrays.asList(ext_author2[i].replaceAll("[^0-9]+", " ").trim().split(" ")).get(0);
//                        System.out.println("[index-96] "+index);//sayılar var burda!!
                        String name_surname = ext_author2[i].replaceAll("\\d", "").replace("∗", "").replace("*", "").replace("and", "");
                        System.out.println( "[authors-98]"+name_surname);
                        if(index.equals("") == true){//hiç indexi yoksa direk name ve surname ekle

                            Author author = new Author(0,name_surname);
                            authors.add(author);
                        }else{
                            Author author = new Author(Integer.parseInt(index), name_surname);
                            authors.add(author);

                        }





                    }
                    if ((doc.select("p").set(2, paragraphs)).text().contains(" ") &&(doc.select("p").set(2, paragraphs)).text().substring(0,(doc.select("p").set(2, paragraphs)).text().indexOf(" ")) == "and")
                        //alttaki pde and ile başlayan ad varsa
                    {

                            Author author = new Author((doc.select("p").set(2, paragraphs)).text().replace("and", "").replaceAll("∗", "").replace("*", "").replace(",", ""));
                            authors.add(author);
                            System.out.println("[AuthorExctractor-81]"+(doc.select("p").set(2, paragraphs)).text().replace("and", "").replaceAll("∗", "").replace("*", "").replace(",", ""));

                    }
                }

//            } catch (ArrayIndexOutOfBoundsException e) {
//                e.printStackTrace();
//            }

        } else {
            if (Character.isDigit((doc.select("p").set(0, paragraphs)).text().charAt(0)) == true) {

                try {


                    Element paragraphs1 = null;
                    paragraphs1 = doc.select("p").set(2, paragraphs);//2 dersen 3.pde adres varsa basar.Burda adresler oluyor ve daha uzun genelde.

                    if ((doc.select("p").set(2, paragraphs)).text().compareTo("") == 0) {//birden fazla<p><\p>varsa DONGU???

                        paragraphs1 = doc.select("p").set(3, paragraphs);
                    }
                    Element ext_author = paragraphs1;


                    if (paragraphs1.text().contains("and") == true) {
                        String[] ext_author1 = ext_author.text().split("\\s*and+s*");

                        for (int i = 0; i < ext_author1.length; i++) {
                            Author author = new Author(ext_author1[i].replaceAll("\\d", "").replace("∗", "").replace("*", ""));
                            authors.add(author);
                            System.out.println("[AuthorExctractor-112] "+ext_author1[i].replaceAll("\\d", "").replace("∗", "").replace(",", ""));
                        }
                    } else if (paragraphs1.text().contains(",") == true) {


                        String[] ext_author2 = ext_author.text().split(",");
                        for (int i = 0; i < ext_author2.length; i++) {
                            String index = Arrays.asList(ext_author2[i].replaceAll("[^0-9]+", " ").trim().split(" ")).get(0);//sayilar burda.
//                            System.out.println("index-158"+index);
                            String name_surname = ext_author2[i].replaceAll("\\d", "").replace("∗", "").replace("*", "").replace("and", "");
                            System.out.println("[suthors-159]"+name_surname);
                            if(index.equals("") == true){//hiç indexi yoksa direk name ve surname ekle

                                Author author = new Author(name_surname);
                                authors.add(author);
                            }else{
                                Author author = new Author(Integer.parseInt(index), name_surname);
                                authors.add(author);

                            }
                        }
                    }

                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                } catch(NumberFormatException e){
                    e.printStackTrace();
                }
            }
        }
        return authors;
    }


}
