package seedu.address.ui;

import java.util.logging.Logger;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import javafx.util.Callback;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;

/**
 * Panel containing the list of persons.
 */
public class PersonListPanel extends UiPart<Region> {
    private static final String FXML = "PersonListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(PersonListPanel.class);

    @FXML
    private TableView<Person> personTableView;
    @FXML
    private TableColumn<Person, Number> colIndex;
    @FXML
    private TableColumn<Person, String> colName;
    @FXML
    private TableColumn<Person, String> colPhone;
    @FXML
    private TableColumn<Person, String> colEmail;
    @FXML
    private TableColumn<Person, String> colAddress;
    @FXML
    private TableColumn<Person, String> colPropertyType;
    @FXML
    private TableColumn<Person, String> colPrice;
    @FXML
    private TableColumn<Person, String> colIntention;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public PersonListPanel(ObservableList<Person> personList) {
        super(FXML);

        personTableView.setItems(personList);

        colName.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getName().fullName));
        colPhone.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getPhone().value));
        colEmail.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getEmail().value));
        colAddress.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getAddress().value));
        colPropertyType.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getPropertyType().value));
        colPrice.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getPrice().value));
        colIntention.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getIntention().intentionName));
        colIndex.setCellValueFactory(cellData -> {
            Person person = cellData.getValue();
            SimpleIntegerProperty indexProperty = new SimpleIntegerProperty();
            indexProperty.bind(Bindings.createIntegerBinding(() -> personTableView.getItems().indexOf(person) + 1,
                    personTableView.getItems()
            ));
            return indexProperty;
        });
        colIndex.setCellFactory(new Callback<TableColumn<Person, Number>, TableCell<Person, Number>>() {
            @Override
            public TableCell<Person, Number> call(TableColumn<Person, Number> param) {
                return new TableCell<Person, Number>() {
                    @Override
                    protected void updateItem(Number item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty || item == null ? null : String.valueOf(item.intValue()));
                    }
                };
            }
        });

        colName.setCellFactory(tc -> new TableCell<Person, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item);
            }
        });

        colPhone.setCellFactory(tc -> new TableCell<Person, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item);
            }
        });

        colEmail.setCellFactory(tc -> new TableCell<Person, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item);
            }
        });

        colAddress.setCellFactory(tc -> new TableCell<Person, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item);
            }
        });

        colPropertyType.setCellFactory(tc -> new TableCell<Person, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item);
            }
        });

        colPrice.setCellFactory(tc -> new TableCell<Person, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item);
            }
        });

        colIntention.setCellFactory(tc -> new TableCell<Person, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                // Always reset styles when updating
                getStyleClass().removeAll("intention-chip", "intention-sell", "intention-rent");

                if (empty || item == null) {
                    setText(null);
                    return;
                }

                String className = "intention-" + item.toLowerCase();
                String labelText = item.substring(0, 1).toUpperCase() + item.substring(1);
                setText(labelText);
                getStyleClass().add("intention-chip");
                getStyleClass().add(className);
            }
        });
    }
}
