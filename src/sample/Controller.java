package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

public class Controller {
    private CiklusModel modelCiklusa;
    public ChoiceBox<Ciklus> izborCiklusa;
    private StudijModel modelStudija;
    public  ChoiceBox<Studij> izborStudija;
    private StatusModel modelStatus;
    public ChoiceBox<Status> izborStatusa;
    private OdsjekModel modelOdsjek;
    public ChoiceBox<Odsjek> izborOdsjeka;
    private MjestoRodjenjaModel model;
    public ComboBox<MjestoRodjenja> izborMjestaRodjenja;
    public Controller(MjestoRodjenjaModel modelMjestaRodjenja, OdsjekModel modelOdsjeka, StatusModel statusModel, StudijModel studij, CiklusModel ciklus) {
        model=modelMjestaRodjenja;
        modelOdsjek = modelOdsjeka;
        modelStatus = statusModel;
        modelStudija = studij;
        modelCiklusa = ciklus;
    }

    @FXML
    public void initialize() {
        izborMjestaRodjenja.setItems(model.getMjestoRodjenja());
        izborOdsjeka.setItems(modelOdsjek.getOdsjek());
        izborStatusa.setItems(modelStatus.getStatus());
        izborStudija.setItems(modelStudija.getStudij());
        izborCiklusa.setItems(modelCiklusa.getCiklus());
    }
    public void promjenaKnjige(ActionEvent actionEvent) {
        model.setTrenutnoMjestoRodjenja(izborMjestaRodjenja.getValue());
    }
}