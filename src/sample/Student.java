package sample;

import javafx.beans.property.SimpleStringProperty;

public class Student {
    private SimpleStringProperty ime = new SimpleStringProperty("");
    private SimpleStringProperty prezime = new SimpleStringProperty("");
    private SimpleStringProperty brojIndexa = new SimpleStringProperty("");
    public String getIme() {
        return ime.get();
    }

    public SimpleStringProperty imeProperty() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }

    public String getPrezime() {
        return prezime.get();
    }

    public SimpleStringProperty prezimeProperty() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public String getBrojIndexa() {
        return brojIndexa.get();
    }

    public SimpleStringProperty brojIndexaProperty() {
        return brojIndexa;
    }

    public void setBrojIndexa(String brojIndexa) {
        this.brojIndexa.set(brojIndexa);
    }
}
