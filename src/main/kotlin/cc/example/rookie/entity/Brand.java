package cc.example.rookie.entity;

import cc.example.rookie.common.Organize;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.io.IOException;
import java.util.*;

@Table(name = "brands")
@AllArgsConstructor
@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String brandName;

    public String logo;

    public int classify;

    public String description;

    public boolean status;

    public int createdUser;

    public int updatedUser;

    public Date updatedTime;

    public boolean isDelete;

    public Brand(String brandName, String logo, int classify, String description, boolean status, int createdUser, boolean isDelete) {
        this.brandName = brandName;
        this.logo = logo;
        this.classify = classify;
        this.description = description;
        this.status = status;
        this.createdUser = createdUser;
        this.updatedUser = createdUser;
        this.updatedTime = new Date();
        this.isDelete = isDelete;
    }

    public Brand() {
    }

    public static class JsonSerializerBuilder extends JsonSerializer<Brand> {

        @Override
        public void serialize(Brand brand, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeObject(
                    new Organize().add("id", brand.id)
                            .add("brandName", brand.brandName)
                            .add("logo", brand.logo)
                            .add("classifyId", brand.classify)
                            .add("description", brand.description)
                            .add("status", brand.status)
                            .add("createdUserId", brand.createdUser)
                            .add("updatedUserId", brand.updatedUser)
                            .add("updatedTime", brand.updatedTime)
                            .add("isDelete", brand.isDelete)
            );
        }

        @Override
        public Class<Brand> handledType() {
            return Brand.class;
        }
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", logo='" + logo + '\'' +
                ", classify=" + classify +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createdUser=" + createdUser +
                ", updatedUser=" + updatedUser +
                ", updatedTime=" + updatedTime +
                ", isDelete=" + isDelete +
                '}';
    }
}
