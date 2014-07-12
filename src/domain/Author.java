package domain;


public class Author {

    private int index;
    private String name_surname;
    private String address;
    private String email;

    public Author(int index, String name_surname, String address, String email) {
        this.index = index;
        this.name_surname = name_surname;
        this.address = address;
        this.email = email;
    }

    public Author(int index, String name_surname) {
        this.index = index;
        this.name_surname = name_surname;
    }

    public Author(String name_surname) {
        this.name_surname = name_surname;
    }
//    public Author(int index){
//        this.index = index;
//    }

    public int getIndex() {
        return index;
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

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
