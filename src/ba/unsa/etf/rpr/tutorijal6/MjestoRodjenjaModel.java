package ba.unsa.etf.rpr.tutorijal6;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MjestoRodjenjaModel {
    private ObservableList<MjestoRodjenja> mjestoRodjenja = FXCollections.observableArrayList();
    private ObjectProperty<MjestoRodjenja> trenutnoMjestoRodjenja = new SimpleObjectProperty<>();

    public ObservableList<MjestoRodjenja> getMjestoRodjenja() {
        return mjestoRodjenja;
    }

    public void setMjestoRodjenja(ObservableList<MjestoRodjenja> mjestoRodjenja) {
        this.mjestoRodjenja = mjestoRodjenja;
    }

    public MjestoRodjenja getTrenutnoMjestoRodjenja() {
        return trenutnoMjestoRodjenja.get();
    }

    public ObjectProperty<MjestoRodjenja> trenutnoMjestoRodjenjaProperty() {
        return trenutnoMjestoRodjenja;
    }

    public void setTrenutnoMjestoRodjenja(MjestoRodjenja trenutnoMjestoRodjenja) {
        this.trenutnoMjestoRodjenja.set(trenutnoMjestoRodjenja);
    }
    public void dodajMjestoRodjenja() {
        mjestoRodjenja.add(new MjestoRodjenja("Sarajevo"));
        mjestoRodjenja.add(new MjestoRodjenja("Mostar"));
        mjestoRodjenja.add(new MjestoRodjenja("Zagreb"));
        mjestoRodjenja.add(new MjestoRodjenja("Beograd"));
        mjestoRodjenja.add(new MjestoRodjenja("Banja Luka"));
        mjestoRodjenja.add(new MjestoRodjenja("Split"));
        mjestoRodjenja.add(new MjestoRodjenja("Zenica"));
    }

}
