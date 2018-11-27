package ba.unsa.etf.rpr.tutorijal6;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    public TextField datumRodjenja;
    public TextField imeField;
    public TextField prezimeField;
    public TextField indexField;
    public TextField jmbgField;
    public TextField kontaktAdresaField;
    public TextField kontaktTelefonField;
    public TextField kontaktMailField;
    public CheckBox check;
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
    private boolean imeValidno = false;
    private boolean prezimeValidno = false;
    private boolean indeksValidan = false;
    private boolean jmbgValidan = false;
    private boolean datumValidan = false;
    private boolean emailValidan = false;
    private  boolean telValidan = true;
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
                if (isValidEmail(n)) {
                    kontaktMailField.getStyleClass().removeAll("poljeNijeIspravno");
                    kontaktMailField.getStyleClass().add("poljeIspravno");
                } else {
                    kontaktMailField.getStyleClass().removeAll("poljeIspravno");
                    kontaktMailField.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });
        kontaktTelefonField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validanTel(n)) {
                    kontaktTelefonField.getStyleClass().removeAll("poljeNijeIspravno");
                    kontaktTelefonField.getStyleClass().add("poljeIspravno");
                } else {
                    kontaktTelefonField.getStyleClass().removeAll("poljeIspravno");
                    kontaktTelefonField.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });
        datumRodjenja.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validanDatum(n)) {
                    datumRodjenja.getStyleClass().removeAll("poljeNijeIspravno");
                    datumRodjenja.getStyleClass().add("poljeIspravno");
                    emailValidan=true;
                } else {
                    datumRodjenja.getStyleClass().removeAll("poljeIspravno");
                    datumRodjenja.getStyleClass().add("poljeNijeIspravno");
                    emailValidan=false;
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
    private boolean validanTel(String n) {
        if(n.length()==0) {telValidan= true; return true; }
        if(n.length()!=9 || n.charAt(0) != '0' ){telValidan= false; return false; }
        for(int i=1; i<n.length();i++) {
            if (!(n.charAt(i) >= '0' && n.charAt(i) <= '9')) {telValidan= false; return false; }
        }
        telValidan = true;
        return !n.trim().isEmpty();
    }
    private boolean validnoIme(String n) {

        if (n.length() < 2 || n.length() > 20) {imeValidno= false; return false; }
        for (int i = 0; i < n.length(); i++) {
            if (!((n.charAt(i) >= 'A' && n.charAt(i) <= 'Z') || n.charAt(i) == 'Ž' || n.charAt(i) == 'Č' || n.charAt(i) == 'Ć' || n.charAt(i) == 'Đ' || n.charAt(i) == 'Š') && !(n.charAt(i) >= 'a' && n.charAt(i) <= 'z' || n.charAt(i) == 'ž' || n.charAt(i) == 'č' || n.charAt(i) == 'ć' || n.charAt(i) == 'đ' || n.charAt(i) == 'š')) {
                imeValidno = false;
                return false;
            }
        }
        imeValidno = true;
        return !n.trim().isEmpty();
    }
    private boolean validanJMBG(String n) {
        if(n.length()!=13) return false;
        else{
            if(n.charAt(0) >= '4' || n.charAt(0) < '0') {jmbgValidan=false; return false; }
            if(n.charAt(2) >='2') {jmbgValidan = false; return false; }
            if(n.charAt(2) == '1' && n.charAt(3) >='3') {jmbgValidan= false; return false; }
            for (int i = 4; i < n.length(); i++) {
                if (!(n.charAt(i) >= '0' && n.charAt(i) <= '9')) {jmbgValidan= false; return false; }
            }
        }
        int L = 11 - ((7*( (n.charAt(0)-'0') + (n.charAt(6)-'0')) + 6*( (n.charAt(1)-'0') + (n.charAt(7)-'0')) + 5*((n.charAt(2)-'0')+ (n.charAt(8)-'0')) + 4*((n.charAt(3)- '0') + (n.charAt(9)-'0')) +3*((n.charAt(4)-'0') + n.charAt(10)-'0') + 2*((n.charAt(5)-'0') + (n.charAt(11)-'0'))) % 11);
        if((L>=1 && L<=9) && n.charAt(12)-'0' == L) {jmbgValidan=true; return true; }
        jmbgValidan=false;
        return false;

    }
    private boolean validanIndex(String n) {
        if(n.length()!=5 || n.charAt(0) == '0') {indeksValidan = false; return false; }
        for(int i = 1; i< n.length(); i++) {
            if(!(n.charAt(i)>='0' && n.charAt(i) <='9')) {indeksValidan= false; return false; }
        }
        indeksValidan = true;
        return !n.trim().isEmpty();
    }
    private boolean validanDatum(String n) {
        boolean b = true;
        if(n.length()==11) {
            if (n.charAt(2) == '.' && n.charAt(5) == '.' && n.charAt(10) == '.') {
                for (int i = 0; i < n.length(); i++) {
                    if (i != 2 && i != 5 && i != 10) {
                        if (n.charAt(i) < '0' || n.charAt(i) > '9') b = false;
                    }
                }
            }
            if (b) {
                String jmbg = jmbgField.getText();
                String newDate = "";
                for (int i = 0; i < n.length(); i++) {
                    if (n.charAt(i) != '.') newDate += n.charAt(i);
                }
                String novi = newDate.substring(0, 4);
                String novijmbg = jmbg.substring(0, 4);
                String stari = newDate.substring(5);
                String starijmbg= jmbg.substring(4,7);
                if (novi.equals(novijmbg) && stari.equals(starijmbg)) {
                    datumValidan = true;
                    return true;
                }
                datumValidan = false;
                return false;
            } else return false;
        }
        else return false;
    }
    public boolean formularValidan() {
        return (imeValidno  && indeksValidan && jmbgValidan && telValidan && emailValidan && datumValidan);
    }
    public void dugme(ActionEvent actionEvent) {
    if(formularValidan()) {
        System.out.println("Ime: " + imeField.getText());
        System.out.println("Prezime: " + prezimeField.getText());
        System.out.println("Index: " + indexField.getText());
        System.out.println("JMBG: " + jmbgField.getText());
        System.out.println("Datum: " + datumRodjenja.getText());
        System.out.println("Mjesto rođenja: " + izborMjestaRodjenja.getValue());
        System.out.println("Adresa: " + kontaktAdresaField.getText());
        System.out.println("Telefon: " + kontaktTelefonField.getText());
        System.out.println("E-Mail: "+ kontaktMailField.getText());
        System.out.println("Odsjek: "+ izborOdsjeka.getValue());
        System.out.println("Godina studija: " +izborStudija.getValue());
        System.out.println("Ciklus studija: "+ izborCiklusa.getValue());
        System.out.println("Status studenta: "+ izborStatusa.getValue());
        if(check.isSelected()) {
            System.out.println("Student pripada posebnim boračkim kategorijama");
        }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Nije validno");
            alert.setHeaderText("Niste dobro popunili formular");
            alert.show();
        }

    }
}
