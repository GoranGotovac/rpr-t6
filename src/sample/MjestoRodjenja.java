package sample;

import javafx.beans.property.SimpleStringProperty;

public class MjestoRodjenja {
    private SimpleStringProperty mjestoRodjenja = new SimpleStringProperty("");

    public MjestoRodjenja(String mjestoRodjenja) {
        this.mjestoRodjenja = new SimpleStringProperty (mjestoRodjenja);
    }

    public String getMjestoRodjenja() {
        return mjestoRodjenja.get();
    }

    public SimpleStringProperty mjestoRodjenjaProperty() {
        return mjestoRodjenja;
    }

    public void setMjestoRodjenja(String mjestoRodjenja) {
        this.mjestoRodjenja.set(mjestoRodjenja);
    }
    @Override
    public String toString() {
        return mjestoRodjenja.get();
    }
}