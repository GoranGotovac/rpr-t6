package sample;

import javafx.beans.property.SimpleStringProperty;

public class Kontakt {
    private SimpleStringProperty kontaktAdresa = new SimpleStringProperty("");
    private SimpleStringProperty kontaktTelefon = new SimpleStringProperty("");
    private SimpleStringProperty kontaktMail = new SimpleStringProperty("");

    public String getKontaktAdresa() {
        return kontaktAdresa.get();
    }

    public SimpleStringProperty kontaktAdresaProperty() {
        return kontaktAdresa;
    }

    public void setKontaktAdresa(String kontaktAdresa) {
        this.kontaktAdresa.set(kontaktAdresa);
    }

    public String getKontaktTelefon() {
        return kontaktTelefon.get();
    }

    public SimpleStringProperty kontaktTelefonProperty() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon.set(kontaktTelefon);
    }

    public String getKontaktMail() {
        return kontaktMail.get();
    }

    public SimpleStringProperty kontaktMailProperty() {
        return kontaktMail;
    }

    public void setKontaktMail(String kontaktMail) {
        this.kontaktMail.set(kontaktMail);
    }
}

