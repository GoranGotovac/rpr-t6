package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    public DatePicker datumRodjenja;
    public TextField imeField;
    public TextField prezimeField;
    public TextField indexField;
    public TextField jmbgField;
    public TextField kontaktAdresaField;
    public TextField kontaktTelefonField;
    public TextField kontaktMailField;
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
    private boolean imeValidno;
    private boolean prezimeValidno;
    private boolean indeksValidan;
    private boolean jmbgValidan;
    private boolean datumValidan;
    private boolean emailValidan;
    private  boolean telValidan;
    public Controller(MjestoRodjenjaModel modelMjestaRodjenja, OdsjekModel modelOdsjeka, StatusModel statusModel, StudijModel studij, CiklusModel ciklus) {
        model=modelMjestaRodjenja;
        modelOdsjek = modelOdsjeka;
        modelStatus = statusModel;
        modelStudija = studij;
        modelCiklusa = ciklus;
    }

    @FXML
    public void initialize() {
        imeField.getStyleClass().add("poljeNijeIspravno");
        prezimeField.getStyleClass().add("poljeNijeIspravno");
        jmbgField.getStyleClass().add("poljeNijeIspravno");
        indexField.getStyleClass().add("poljeNijeIspravno");
        kontaktMailField.getStyleClass().add("poljeNijeIspravno");
        izborMjestaRodjenja.setItems(model.getMjestoRodjenja());
        izborOdsjeka.setItems(modelOdsjek.getOdsjek());
        izborStatusa.setItems(modelStatus.getStatus());
        izborStudija.setItems(modelStudija.getStudij());
        izborCiklusa.setItems(modelCiklusa.getCiklus());
        imeField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validnoIme(n)) {
                    imeField.getStyleClass().removeAll("poljeNijeIspravno");
                    imeField.getStyleClass().add("poljeIspravno");
                } else {
                    imeField.getStyleClass().removeAll("poljeIspravno");
                    imeField.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });
        prezimeField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validnoIme(n)) {
                    prezimeField.getStyleClass().removeAll("poljeNijeIspravno");
                    prezimeField.getStyleClass().add("poljeIspravno");
                } else {
                    prezimeField.getStyleClass().removeAll("poljeIspravno");
                    prezimeField.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });
        indexField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validanIndex(n)) {
                    indexField.getStyleClass().removeAll("poljeNijeIspravno");
                    indexField.getStyleClass().add("poljeIspravno");
                } else {
                    indexField.getStyleClass().removeAll("poljeIspravno");
                    indexField.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });
        jmbgField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validanJMBG(n)) {
                    jmbgField.getStyleClass().removeAll("poljeNijeIspravno");
                    jmbgField.getStyleClass().add("poljeIspravno");
                } else {
                    jmbgField.getStyleClass().removeAll("poljeIspravno");
                    jmbgField.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });
        kontaktMailField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validanMail(n)) {
                    kontaktMailField.getStyleClass().removeAll("poljeNijeIspravno");
                    kontaktMailField.getStyleClass().add("poljeIspravno");
                } else {
                    kontaktMailField.getStyleClass().removeAll("poljeIspravno");
                    kontaktMailField.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

    }
    public void promjenaKnjige(ActionEvent actionEvent) {
        model.setTrenutnoMjestoRodjenja(izborMjestaRodjenja.getValue());
    }
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static boolean isValidEmail(String emailStr){
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }
    private boolean validanDatum(String n) {

    }
    private boolean validnoIme(String n) {

        if (n.length() < 2 || n.length() > 20) return false;
        for (int i = 0; i < n.length(); i++) {
            if (!(n.charAt(i) >= 'A' && n.charAt(i) <= 'Ž') && !(n.charAt(i) >= 'a' && n.charAt(i) <= 'ž'))
                return false;
        }
        return !n.trim().isEmpty();
    }
    private boolean validanJMBG(String n) {
        if(n.length()!=13) return false;
        else{
            if(n.charAt(0) >= '4' || n.charAt(0) < '0') return false;
            if(n.charAt(2) >='2') return false;
            if(n.charAt(2) == '1' && n.charAt(3) >='3') return false;
            for (int i = 4; i < n.length(); i++) {
                if (!(n.charAt(i) >= '0' && n.charAt(i) <= '9')) return false;
            }
        }
        return !n.trim().isEmpty();
    }
    private boolean validanMail(String n) {
        for (int i = 0; i < n.length(); i++) if (n.charAt(i) == '@') return true;
        return false;
    }
    private boolean validanIndex(String n) {
        if(n.length()!=5 || n.charAt(0) == '0') return false;
        for(int i = 1; i< n.length(); i++) {
            if(!(n.charAt(i)>='0' && n.charAt(i) <='9')) return false;
        }
        return !n.trim().isEmpty();
    }
    public boolean formularValidan() {
        return (imeValidno && prezimeValidno && indeksValidan && datumValidan && jmbgValidan && telValidan && emailValidan && jmbgValidan);
    }
}