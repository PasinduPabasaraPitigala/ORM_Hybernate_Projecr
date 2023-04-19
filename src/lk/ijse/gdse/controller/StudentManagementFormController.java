package lk.ijse.gdse.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import lk.ijse.gdse.dao.DaoFactory;
import lk.ijse.gdse.dto.StudentDto;
import lk.ijse.gdse.service.custom.StudentService;
import lk.ijse.gdse.tm.StudentTm;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class StudentManagementFormController {
    public Label lblStId;
    public Label lblStName;
    public Label lblStTelephone;
    public Button btnAdd;
    public Button btnDelete;
    public Button btnUpdate;
    public Button btnView;
    public Label lblStAddress;
    public TableColumn tblStAddress;
    public TableColumn tblSid;
    public TableColumn tblStName;
    public TableColumn tblTelNum;
    public TableColumn tblDateOfBirth;
    public TableColumn tblGender;
    public Label lblDateOfBirth;
    public Label lblGender;
    public TableView<StudentTm> tblStudent;
    private final StudentService studentService=(StudentService) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.STUDENTFORM);
    public Button btnSave;
    LinkedHashMap<TextField, Pattern>map=new LinkedHashMap<>();

    public void btnAddOnAction(ActionEvent actionEvent) {
        String StuId=lblStId.getText();
        String StuName=lblStName.getText();
        String StuAddress=lblStAddress.getText();
        int telNumber=Integer.parseInt(lblStTelephone.getText());
        LocalDate DateOfBirth=LocalDate.parse(lblDateOfBirth.getText());
        String Gender=lblGender.getText();

        try{
            if (btnAdd.getText().equalsIgnoreCase("save")){

                boolean save =studentService.SaveStudent(new StudentDto(StuId,StuName,StuAddress,telNumber,DateOfBirth,Gender));
                tblStudent.getItems().add(new StudentTm(StuId,StuName,StuAddress,telNumber,DateOfBirth,Gender));
                if (!save){
                    new Alert(Alert.AlertType.ERROR,"Failed Added").show();
                }
            }else {
                boolean updated=studentService.UpdateStudent(new StudentDto(StuId,StuName,StuAddress,telNumber,DateOfBirth,Gender));

                if (updated){
                    new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
                }

                StudentTm studentTm = (StudentTm) tblStudent.getSelectionModel().getSelectedItem();
                studentTm.setStuName(StuName);
                studentTm.setStuAddress(StuAddress);
                studentTm.setContact_no(telNumber);
                studentTm.setDateOfBirth(DateOfBirth);
                studentTm.setGender(Gender);
                tblStudent.refresh();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Do you Want Delete", ButtonType.YES,ButtonType.NO);
        Optional<ButtonType> buttonType =alert.showAndWait();
        if (buttonType.get().equals(ButtonType.YES)){
            try {
                String studentId=tblStudent.getSelectionModel().getSelectedItem().getStuId();
                boolean b = studentService.DeleteStudent(studentId);
                if (b){
                    new Alert(Alert.AlertType.CONFIRMATION,"Deleted").show();
                }
                tblStudent.getItems().remove(tblStudent.getSelectionModel().getSelectedItem());
                tblStudent.getSelectionModel().clearSelection();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnViewOnAction(ActionEvent actionEvent) {
        try {
            List<StudentDto> allStudents = studentService.getAllStudents();
            for (StudentDto studentDto:allStudents
            ) {
                tblStudent.getItems().add(
                        new StudentTm(studentDto.getStuId(),studentDto.getStuName(),studentDto.getStuAddress(),studentDto.getContact_no(),studentDto.getDateOfBirth(),studentDto.getGender()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        lblStId.setDisable(false);
        lblStName.setDisable(false);
        lblStAddress.setDisable(false);
        lblDateOfBirth.setDisable(false);
        lblGender.setDisable(false);

//        lblStId.clear();
//
//        genarateNewId();
//        lblStName();
//        lblStAddress();
//        lblStTelephone();
//        lblDateOfBirth();
//        lblGender();

        lblStName.requestFocus();
        btnSave.setDisable(false);
        btnSave.setText("save");
        tblStudent.getSelectionModel().clearSelection();

    }
    public void generateNewId(){
        try{
            String lastStudentId = studentService.genarateStudentId();
            int newId= Integer.parseInt(lastStudentId.substring(1,4))+1;
            if (newId <10){
                lblStId.setText("S00"+newId);
            }else if(newId <100){
                lblStId.setText("S0"+newId);
            }else {
                lblStId.setText("S"+newId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
