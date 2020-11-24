package cc.example.rookie.entity;

import cc.example.rookie.common.Organize;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.io.IOException;
import java.util.*;

@Table(name = "classify")
@Entity
public class Classify {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String classifyName;
    public String icon;
    public String bigIcon;
    public String description;
    public boolean status;

    public int createdUser;

    public int updatedUser;

    public Date createdTime;
    public Date updatedTime;
    public boolean isDelete;

    public Classify() {
    }

    public Classify(String classifyName, String icon, String bigIcon, String description, boolean status, int createdUser, int updatedUser, Date createdTime, Date updatedTime, boolean isDelete) {
        this.classifyName = classifyName;
        this.icon = icon;
        this.bigIcon = bigIcon;
        this.description = description;
        this.status = status;
        this.createdUser = createdUser;
        this.updatedUser = updatedUser;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Classify{" +
                "id=" + id +
                ", classifyName='" + classifyName + '\'' +
                ", icon='" + icon + '\'' +
                ", bigIcon='" + bigIcon + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createdUser=" + createdUser +
                ", updatedUser=" + updatedUser +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                ", isDelete=" + isDelete +
                '}';
    }


}
