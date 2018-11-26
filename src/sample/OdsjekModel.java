package sample;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OdsjekModel {
    private ObservableList<Odsjek> odsjek = FXCollections.observableArrayList();
    private ObjectProperty<Odsjek> trenutniOdsjek = new SimpleObjectProperty<>();

    public ObservableList<Odsjek> getOdsjek() {
        return odsjek;
    }

    public void setOdsjek(ObservableList<Odsjek> odsjek) {
        this.odsjek = odsjek;
    }

    public Odsjek getTrenutniOdsjek() {
        return trenutniOdsjek.get();
    }

    public ObjectProperty<Odsjek> trenutniOdsjekProperty() {
        return trenutniOdsjek;
    }

    public void setTrenutniOdsjek(Odsjek trenutniOdsjek) {
        this.trenutniOdsjek.set(trenutniOdsjek);
    }
    public void dodajOdsjek() {
        odsjek.add(new Odsjek("AE"));
        odsjek.add(new Odsjek("RI"));
        odsjek.add(new Odsjek("TK"));
        odsjek.add(new Odsjek("EE"));
    }
}
