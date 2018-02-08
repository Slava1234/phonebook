package com.phonebook.objects;

public class PhoneBook {
    private int id;
    private String name;
    private Long phone;
    private String email;

    public PhoneBook() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneBook phoneBook = (PhoneBook) o;

        if (phone != phoneBook.phone) return false;
        if (!name.equals(phoneBook.name)) return false;
        return email.equals(phoneBook.email);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id;
        hash = 47 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 47 * hash + (this.phone != null ? this.phone.hashCode() : 0);
        hash = 47 * hash + (this.email != null ? this.email.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }
}


















