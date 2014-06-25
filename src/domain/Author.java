package domain;

/**
 * Created by KaanBasal on 6/17/2014.
 */
public class Author {

    private String name_surname;
    private String address;
    private String email;

    public Author(String name_surname, String address, String email) {
        this.name_surname = name_surname;
        this.address = address;
        this.email = email;
    }

    public String getName_surname() {
        return name_surname;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
}
