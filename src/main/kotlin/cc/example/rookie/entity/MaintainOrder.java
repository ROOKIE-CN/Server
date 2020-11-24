package cc.example.rookie.entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;

@Table(name = "maintain_order")
@Entity
@AllArgsConstructor
public class MaintainOrder {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String orderNo;


    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    public User user;


    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    public Model model;


    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    public Evaluate evaluate;

    @Column(columnDefinition = "decimal")
    public double subscription;

    @Column(columnDefinition = "decimal")
    public double price;

    public boolean status;

    public MaintainOrder() {
    }
}
