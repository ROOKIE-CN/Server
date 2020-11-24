package cc.example.rookie.entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;

@Table(name = "maintain_order_flow")
@Entity
@AllArgsConstructor
public class MaintainOrderFlow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String orderNo;

    public int orderStatus;

    public String orderStatusDesc;

    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    public User operationUser;

    public MaintainOrderFlow() {
    }
}
