package cc.example.rookie.entity;

import javax.persistence.*;

@Entity
@Table(name = "parameter_options")
public class ParameterOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public int parent;

    public String content;

    public ParameterOption() {
    }

    public ParameterOption(int parent, String content) {
        this.parent = parent;
        this.content = content;
    }
}
