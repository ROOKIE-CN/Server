package cc.example.rookie.entity;

import javax.persistence.*;

@Entity
@Table(name = "parameters")
public class Parameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String title;

    public Parameter() {
    }

    public Parameter(String title) {
        this.title = title;
    }
}
