package ba.unsa.etf.rpr.tutorijal6;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudijModel {
    private ObservableList<Studij> studij = FXCollections.observableArrayList();
    private ObjectProperty<Studij> trenutniStudij = new SimpleObjectProperty<>();

    public ObservableList<Studij> getStudij() {
        return studij;
    }

    public void setStudij(ObservableList<Studij> studij) {
        this.studij = studij;
    }

    public Studij getTrenutniStudij() {
        return trenutniStudij.get();
    }

    public ObjectProperty<Studij> trenutniStudijProperty() {
        return trenutniStudij;
    }

    public void setTrenutniStudij(Studij trenutniStudij) {
        this.trenutniStudij.set(trenutniStudij);
    }

    public void dodajStudij() {
        studij.add(new Studij("Prva"));
        studij.add(new Studij("Druga"));
        studij.add(new Studij("Treća"));
    }
}
