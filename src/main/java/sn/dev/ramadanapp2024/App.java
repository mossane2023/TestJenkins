package sn.dev.ramadanapp2024;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sn.dev.ramadanapp2024.entities.Operation;
import sn.dev.ramadanapp2024.entities.TypeOperation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class App extends Application {

    public void start(Stage stage) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("/pages/Design.fxml"));

        Scene scene = new Scene(parent);
        stage.setTitle("CRUD");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            TypeOperation typeOp = new TypeOperation();
            typeOp.setName("mami");

            entityManager.persist(typeOp);

            Operation Op = new Operation();
            Op.setNomComplet("khady mossane");
            Op.setMontant(43.5);
            Op.setDateOp(new Date());
            //Op.setTypeOp(TypeOperation);
            entityManager.persist(Op);

            transaction.commit();
        } finally {
            if(transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
