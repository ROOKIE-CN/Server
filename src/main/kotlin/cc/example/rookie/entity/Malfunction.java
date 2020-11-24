package cc.example.rookie.entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "malfunction")
public class Malfunction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String content;

    public double eval;

    public Malfunction() {
    }

    public Malfunction(String content, double eval) {
        this.content = content;
        this.eval = eval;
    }
}
