package cc.example.rookie.entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "pay_order")
@AllArgsConstructor
public class PayOrder {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String orderNo;

    public String payNo;


    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    public User user;

    @Column(columnDefinition = "decimal")
    public double price;

    public boolean payType;

    public int status;

    public PayOrder() {
    }
}
