package cc.example.rookie.entity;

import javax.persistence.*;

@Entity
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String baseKey;

    public String baseUrl;

    public Permission() {
    }
}
