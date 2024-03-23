package sn.dev.ramadanapp2024.entities;
import javax.persistence.*;
import java.util.Date;

@NamedQuery(name = "listUsers", query = "SELECT u FROM Operation u ORDER BY u.nomComplet ASC")
@Entity
public class Operation {


    @Id
    @Column(name = "idOp")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idOp;

    @Column(name = "nomComplet")
    private String nomComplet;

    @Column(name = "montant")
    private double montant;

    @Column(name = "dateOp")
    private Date dateOp;


    @ManyToOne
    @JoinColumn(name = "idU")
    private TypeOperation TypeOp ;






    public Operation(int idOp, String nomComplet, double montant, Date dateOp, TypeOperation typeOp) {
        this.idOp = idOp;
        this.nomComplet = nomComplet;
        this.montant = montant;
        this.dateOp = dateOp;
        TypeOp = typeOp;
    }

    public Operation() {

    }


    public int getIdOp() {
        return idOp;
    }

    public void setIdOp(int idOp) {
        this.idOp = idOp;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDateOp() {
        return dateOp;
    }

    public void setDateOp(Date dateOp) {
        this.dateOp = dateOp;
    }

    public TypeOperation getTypeOp() {
        return TypeOp;
    }

    public void setTypeOp(TypeOperation typeOp) {
        TypeOp = typeOp;
    }
}
