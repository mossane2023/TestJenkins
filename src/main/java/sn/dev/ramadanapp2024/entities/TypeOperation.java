package sn.dev.ramadanapp2024.entities;
import javax.persistence.*;


@Entity
public class TypeOperation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(name = "name")
    private String name;



    public TypeOperation() {

    }

    public TypeOperation(int id, String name) {
        this.id = id;
        this.name = name;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
