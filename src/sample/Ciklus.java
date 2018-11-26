package sample;

import javafx.beans.property.SimpleStringProperty;

public class Ciklus {
    private SimpleStringProperty ciklus = new SimpleStringProperty("");

    public Ciklus(String ciklus) {
        this.ciklus = new SimpleStringProperty (ciklus);
    }

    public String getCiklus() {
        return ciklus.get();
    }

    public SimpleStringProperty ciklusProperty() {
        return ciklus;
    }

    public void setCiklus(String ciklus) {
        this.ciklus.set(ciklus);
    }
    @Override
    public String toString() {
        return ciklus.get();
    }
}
