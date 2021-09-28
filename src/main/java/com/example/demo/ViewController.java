package com.example.demo;

import com.example.demo.model.entities.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

    @FXML
    private ComboBox<Person> comboBoxPerson;

    @FXML
    private Button buttonAllPerson;

    private ObservableList<Person> observableList;

    @FXML
    public void onBtAllAction() {
        for (Person person : comboBoxPerson.getItems()) {
            System.out.println(person);
        }
    }

    @FXML
    public void onComboBoxPersonAction() {
        Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
        System.out.println(person);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "Ezequias", "zeca@gmail.com"));
        list.add(new Person(2, "Magdalena", "magdalena@gmail.com"));
        list.add(new Person(3, "Marcelo", "marcelo@gmail.com"));
        list.add(new Person(4, "Gabriel", "biel@gmail.com"));
        list.add(new Person(5, "Alice", "alice@gmail.com"));
        list.add(new Person(6, "Ezequiana", "quiana@gmail.com"));

        observableList = FXCollections.observableList(list);
        comboBoxPerson.setItems(observableList);

        Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
            @Override
            protected void updateItem(Person item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getName());
            }
        };
        comboBoxPerson.setCellFactory(factory);
        comboBoxPerson.setButtonCell(factory.call(null));

    }
}
