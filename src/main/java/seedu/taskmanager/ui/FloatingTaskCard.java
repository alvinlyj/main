package seedu.taskmanager.ui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.taskmanager.model.task.ReadOnlyTask;

//@@author A0142418L
public class FloatingTaskCard extends UiPart<Region> {

    private static final String FXML = "FloatingTaskCard.fxml";

    @FXML
    private HBox cardPane;
    @FXML
    private Label taskname;
    @FXML
    private Label id;
    @FXML
    private Label markedCompleted;
    @FXML
    private FlowPane categories;

    private final StringProperty empty = new SimpleStringProperty("");
    private final StringProperty completed = new SimpleStringProperty("Completed");

    public FloatingTaskCard(ReadOnlyTask task, int displayedIndex) {
        super(FXML);
        taskname.setText(task.getTaskName().fullTaskName);
        id.setText(displayedIndex + ". ");

        if (task.getIsMarkedAsComplete()) {
            markedCompleted.textProperty().bind(completed);
        } else {
            markedCompleted.textProperty().bind(empty);
        }
        initCategory(task);
    }

    private void initCategory(ReadOnlyTask task) {
        if (!task.getCategories().asObservableList().isEmpty()) {
            for (int index = 0; task.getCategories().asObservableList().size() != index; index++) {
                String category = task.getCategories().asObservableList().get(index).categoryName;
                Label label = new Label(category);
                if (category.equals("High")) {
                    label.setStyle("-fx-background-color: red");
                }
                if (category.equals("Medium")) {
                    label.setStyle("-fx-background-color: orange");
                }
                if (category.equals("Low")) {
                    label.setStyle("-fx-background-color: lightblue");
                }

                categories.getChildren().add(label);
            }
        }
    }
}