package cc.example.rookie.entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;

@Table(name = "evaluate")
@AllArgsConstructor
@Entity
public class Evaluate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    public Model model;

    @Column(columnDefinition = "decimal")
    public double subscription;

    @Column(columnDefinition = "decimal")
    public double price;

    public String remark;

    public Evaluate() {
    }
}
