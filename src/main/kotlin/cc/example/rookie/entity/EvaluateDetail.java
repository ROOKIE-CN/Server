package cc.example.rookie.entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "evaluate_detail")
@AllArgsConstructor
public class EvaluateDetail {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    public Evaluate evaluate;


    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    public Malfunction malf;


    public int optionName;

    public EvaluateDetail() {
    }
}
