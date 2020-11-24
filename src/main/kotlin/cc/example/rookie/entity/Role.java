package cc.example.rookie.entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "roles")
@Entity
public class Role {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String roleName;

    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    public Set<Permission> permissions = new HashSet<Permission>();

    public Role(String roleName, Set<Permission> permissions) {
        this.roleName = roleName;
        this.permissions = permissions;
    }

    public Role() {
    }
}
