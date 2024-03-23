package sn.dev.ramadanapp2024.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sn.dev.ramadanapp2024.entities.Operation;
import sn.dev.ramadanapp2024.entities.TypeOperation;

import javax.persistence.*;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class DesignController implements Initializable {


    EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = managerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    @FXML
    private TextField NomTab;

    @FXML
    private TextField MontantTab;

    @FXML
    private ComboBox<?> TypeOperationTab;

    @FXML
    private TableView<Operation> tableCol;

    @FXML
    private TableColumn<Operation, Integer> IdCol;

    @FXML
    private TableColumn<Operation, String> NomCol;

    @FXML
    private TableColumn<Operation, Double> MontantCol;

    @FXML
    private TableColumn<Operation, Integer> TypeOpCol;

    @FXML
    private TableColumn<Operation, Date> DateOpColl;

    @FXML
    private Button saveBTN;

    @FXML
    private Button depotBTN;

    @FXML
    private Button retraitBTN;

    @FXML
    private Button allBTN;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    ///Ajout



    public ObservableList<Operation> getUsers(){
        ObservableList<Operation> Op = FXCollections.observableArrayList();
        TypedQuery<Operation> query = entityManager.createNamedQuery("listUsers", Operation.class);
        Op.addAll(query.getResultList());
        return Op;
    }

    //Ajouter

    @FXML
    void saveFunction(ActionEvent event) {
        try{
            transaction.begin();
            Operation Op = new Operation();
            Op.setNomComplet(NomTab.getText());
            Op.setMontant(Double.parseDouble(MontantTab.getText()));

            //dept.setRegions(Regiontb.getText());
            entityManager.persist(Op);
            transaction.commit();
            viderChamps();
            loadTable();
        }finally {
            if (transaction.isActive())
                transaction.rollback();
        }
    }


    //vider champs

    public void viderChamps(){
        NomTab.setText("");
        MontantTab.setText("");

        TypeOperationTab.setValue(null);
    }


    public void loadTable(){
        tableCol.setItems(getUsers());
        IdCol.setCellValueFactory(new PropertyValueFactory<Operation, Integer>("idOp"));
        NomCol.setCellValueFactory(new PropertyValueFactory<Operation, String>("nomComplet"));
        MontantCol.setCellValueFactory(new PropertyValueFactory<Operation, Double>("montant"));
        DateOpColl.setCellValueFactory(new PropertyValueFactory<Operation, Date>("dateOp"));


    }














}

