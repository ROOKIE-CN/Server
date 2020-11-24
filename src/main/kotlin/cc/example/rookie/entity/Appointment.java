package cc.example.rookie.entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "appointment")
@AllArgsConstructor
public class Appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String appointCode;


    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    public User user;

    public Date appintDate;

    public String adress;

    public boolean status;

    public Appointment() {
    }
}
