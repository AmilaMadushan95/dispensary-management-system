package com.Laboratory.controllers;


import com.common.ScreenController;
import com.common.SessionListener;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.main.Main;
import com.main.controllers.MainScreenController;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import com.EntityClasses.MainTest;
import com.EntityClasses.TestField;
import db.UserSession;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import org.hibernate.Query;
import org.hibernate.Session;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by AmilaWC on 9/17/2017.
 */




@SuppressWarnings("Duplicates")
public class AddReferenceValueController implements Initializable,SessionListener {

    private Session session;
    private MainScreenController mainScreenController;



//    @FXML
//    private TreeTableView<?> referenceValueTab;
//
//    @FXML
//    private TreeTableColumn<?, ?> upRange;
//
//    @FXML
//    private TreeTableColumn<?, ?> lowRange;
//
//    @FXML
//    private TableView<?> ageTable;
//
//    @FXML
//    private TableColumn<?, ?> ageCol;
//
//    @FXML
//    private TitledPane maintest;
//
//    @FXML
//    private TreeTableView<?> mainTestTable;
//
//    @FXML
//    private TreeTableColumn<?, ?> mainid;
//
//    @FXML
//    private TreeTableColumn<?, ?> mainName;
//
//    @FXML
//    private TreeTableColumn<?, ?> mainPrice;
//
//    @FXML
//    private TitledPane testF;
//
//    @FXML
//    private TreeTableView<?> testFieldTable;
//
//    @FXML
//    private TreeTableColumn<?, ?> TestFid;
//
//    @FXML
//    private TreeTableColumn<?, ?> TestName;
//
//    @FXML
//    private TreeTableColumn<?, ?> testUnits;





    @FXML
    private JFXTextField id;

    @FXML
    private JFXTextField testName;

    @FXML
    private JFXTextField testPrice;

    @FXML
    private JFXTextField fid;

    @FXML
    private JFXTextField fName;

    @FXML
    private JFXTextField Units;




    @FXML
    private TreeTableView<MainTest> mainTestTable;

    @FXML
    private TreeTableColumn<MainTest, Number> mainid;

    @FXML
    private TreeTableColumn<MainTest, String> mainName;

    @FXML
    private TreeTableColumn<MainTest, Number> mainPrice;






    @FXML
    private TreeTableView<TestField> testFieldTable;

    @FXML
    private TreeTableColumn<TestField, Number> TestFid;

    @FXML
    private TreeTableColumn<TestField, String> TestName;

    @FXML
    private TreeTableColumn<TestField, String > testUnits;





    @FXML
    private Button resetBT;

    @FXML
    private Button reset1;

    private List<TreeItem<MainTest>> mainTestList;

    private List<TreeItem<TestField>> fieldList;








    @Override
    public void initialize(URL location, ResourceBundle resources) {



        mainid.setCellValueFactory(param -> param.getValue().getValue().tIdProperty());
        mainName.setCellValueFactory(param -> param.getValue().getValue().testNameProperty());
        mainPrice.setCellValueFactory(param -> param.getValue().getValue().testPriceProperty());




        session = ScreenController.getSession();
        mainTestList = new ArrayList<>();
        fieldList = new ArrayList<>();

        session.beginTransaction();
        Query query = session.createQuery("select s from MainTest s");
        List<MainTest> list = query.list();

        session.getTransaction().commit();

        for (MainTest s : list){
            mainTestList.add(new TreeItem<>(s));
        }


        MainTest mainTest = new MainTest();
        mainTest.settId(0);
        mainTest.setTestName("Test Name");
        mainTest.setTestPrice(0);

        TreeItem<MainTest> root = new TreeItem<>(mainTest);
        root.getChildren().addAll(mainTestList);
        mainTestTable.setRoot(root);
        mainTestTable.setShowRoot(false);


        TestFid.setCellValueFactory(param -> param.getValue().getValue().fIdProperty());

        TestName.setCellValueFactory(param -> param.getValue().getValue().fieldNameProperty());

        testUnits.setCellValueFactory(param -> param.getValue().getValue().unitsProperty());

        TestField testField = new TestField();
        testField.setfId(0);
        testField.setFieldName("Test Field Test");
        testField.setUnits("unit");

        TreeItem<TestField> root2 = new TreeItem<>(testField);

        testFieldTable.setRoot(root2);
        testFieldTable.setShowRoot(false);


    }


    @FXML
    void setTextFields(MouseEvent event) {

        TreeItem<MainTest> treeItem = mainTestTable.getSelectionModel().getSelectedItem();

        MainTest mainTest = treeItem.getValue();
        mainTest.getTestFields();
        fieldList.clear();

        for (TestField testField : mainTest.getTestFields()){
            fieldList.add(new TreeItem<>(testField));
        }

        testFieldTable.getRoot().getChildren().clear();
        testFieldTable.getRoot().getChildren().addAll(fieldList);


    }




    @FXML
    void ageClick(MouseEvent event) {

    }




    @Override
    public void setSession(Session session) {

    }

    @Override
    public void setMainController(SessionListener controller) {

        this.mainScreenController = (MainScreenController) controller;


    }
}





















