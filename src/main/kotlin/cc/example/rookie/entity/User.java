package cc.example.rookie.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "account",nullable = false)
    public String account;

    @Column(name = "userName",nullable = false)
    public String userName;

    @Column(name = "password",nullable = false)
    public String password;

    @Column(name = "isAuthentication")
    public boolean isAuthentication;

    @Column(name = "name")
    public String name;

    @Column(name = "cardNo")
    public String cardNo;

    @Column(name = "faceUrl")
    public String faceUrl;

    @Column(name = "time")
    public Date time;

    public boolean admin = false;

    public User() {
    }

    public User(String account, String userName, String password, boolean isAuthentication, String name, String cardNo, String faceUrl, Date time) {
        this.account = account;
        this.userName = userName;
        this.password = password;
        this.isAuthentication = isAuthentication;
        this.name = name;
        this.cardNo = cardNo;
        this.faceUrl = faceUrl;
        this.time = time;
        
    }

    public User(String account, String password) {
        this(account,account,password,false,"","","",new Date());
    }
}
