package cc.example.rookie.entity;

import cc.example.rookie.common.Organize;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.io.IOException;

@Entity
@Table(name = "model")
@AllArgsConstructor
public class Model {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String modelName;

    public int brand;

    @Column(columnDefinition = "decimal(10.2)")
    public double exchangePrice;

    @Column(columnDefinition = "decimal(10.2)")
    public double topPrice;

    public String faceImg;

    public String contentImg;

    public String description;

    public boolean status;

    public int createdUser;

    public Model(String modelName, int brand, double exchangePrice, double topPrice, String faceImg,
                 String contentImg, String description, boolean status, int createdUser) {
        this.modelName = modelName;
        this.brand = brand;
        this.exchangePrice = exchangePrice;
        this.topPrice = topPrice;
        this.faceImg = faceImg;
        this.contentImg = contentImg;
        this.description = description;
        this.status = status;
        this.createdUser = createdUser;
    }

    public Model() {
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", brand=" + brand +
                ", exchangePrice=" + exchangePrice +
                ", topPrice=" + topPrice +
                ", faceImg='" + faceImg + '\'' +
                ", contentImg='" + contentImg + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createdUser=" + createdUser +
                '}';
    }
}
