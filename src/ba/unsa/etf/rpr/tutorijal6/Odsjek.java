package ba.unsa.etf.rpr.tutorijal6;

import javafx.beans.property.SimpleStringProperty;

public class Odsjek {
    private SimpleStringProperty odsjek = new SimpleStringProperty("");
    public Odsjek(String odsjek) {
        this.odsjek = new SimpleStringProperty (odsjek);
    }
    public String getOdsjek() {
        return odsjek.get();
    }

    public SimpleStringProperty odsjekProperty() {
        return odsjek;
    }

    public void setMjestoRodjenja(String odsjek) {
        this.odsjek.set(odsjek);
    }

    @Override
    public String toString() {
        return odsjek.get();
    }
}
