package ba.unsa.etf.rpr.tutorijal6;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StatusModel {
    private ObservableList<Status> status = FXCollections.observableArrayList();
    private ObjectProperty<Status> trenutniStatus = new SimpleObjectProperty<>();

    public ObservableList<Status> getStatus() {
        return status;
    }

    public void setStatus(ObservableList<Status> status) {
        this.status = status;
    }

    public Status getTrenutniStatus() {
        return trenutniStatus.get();
    }

    public ObjectProperty<Status> trenutniStatusProperty() {
        return trenutniStatus;
    }

    public void setTrenutniStatus(Status trenutniStatus) {
        this.trenutniStatus.set(trenutniStatus);
    }

    public void dodajStatus() {
        status.add(new Status("Redovni"));
        status.add(new Status("Redovni-samofinansirajući"));
        status.add(new Status("Vanredni"));
    }
}
