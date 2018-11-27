package ba.unsa.etf.rpr.tutorijal6;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CiklusModel {
    private ObservableList<Ciklus> ciklus = FXCollections.observableArrayList();
    private ObjectProperty<Ciklus> trenutniCiklus = new SimpleObjectProperty<>();

    public ObservableList<Ciklus> getCiklus() {
        return ciklus;
    }

    public void setCiklus(ObservableList<Ciklus> ciklus) {
        this.ciklus = ciklus;
    }

    public Ciklus getTrenutniCiklus() {
        return trenutniCiklus.get();
    }

    public ObjectProperty<Ciklus> trenutniCiklusProperty() {
        return trenutniCiklus;
    }

    public void setTrenutniCiklus(Ciklus trenutniCiklus) {
        this.trenutniCiklus.set(trenutniCiklus);
    }
    public void dodajCiklus() {
        ciklus.add(new Ciklus("Bachelor studij"));
        ciklus.add(new Ciklus("Master studij"));
        ciklus.add(new Ciklus("Doktorski studij"));
        ciklus.add(new Ciklus("Stručni studij"));
    }
}
