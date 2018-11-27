package ba.unsa.etf.rpr.tutorijal6;

import javafx.beans.property.SimpleStringProperty;

public class Studij {
    private SimpleStringProperty studij = new SimpleStringProperty("");

    public Studij(String studij) {
        this.studij = new SimpleStringProperty(studij);
    }

    public String getStudij() {
        return studij.get();
    }

    public SimpleStringProperty studijProperty() {
        return studij;
    }

    public void setStudij(String studij) {
        this.studij.set(studij);
    }
    @Override
    public String toString() {
        return studij.get();
    }
}
