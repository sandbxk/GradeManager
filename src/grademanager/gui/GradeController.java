package grademanager.gui;

import grademanager.be.Grade;
import grademanager.bll.GradeScaleFactory;
import grademanager.bll.IGradeScale;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class GradeController implements Initializable
{
    private IGradeScale gradeScale;

    @FXML
    private TextField txtStudentName;

    @FXML
    private ChoiceBox<String> cbPerformance;

    @FXML
    private ListView<String> lstGrades;

    public GradeController()
    {
        gradeScale = GradeScaleFactory.getGradeScale(GradeScaleFactory.ECTS_SCALE);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        cbPerformance.getItems().addAll(
            IGradeScale.FAILED_DESCRIPTION,
            IGradeScale.BELOW_AVERAGE_DESCRIPTION,
            IGradeScale.AVERAGE_DESCRIPTION,
            IGradeScale.PERFECT_DESCRIPTION
        );
    }

    @FXML
    public void assignGrade()
    {
        String studentName = txtStudentName.getText();
        String performanceDescription = cbPerformance.getValue();
        Grade grade = gradeScale.createGrade(studentName, performanceDescription);
        lstGrades.getItems().add(grade.toString());
    }
}
