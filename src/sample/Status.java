package sample;

import javafx.beans.property.SimpleStringProperty;

public class Status {
    private SimpleStringProperty status = new SimpleStringProperty("");

    public Status(String status) {
        this.status = new SimpleStringProperty (status);;
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
    @Override
    public String toString() {
        return status.get();
    }
}
