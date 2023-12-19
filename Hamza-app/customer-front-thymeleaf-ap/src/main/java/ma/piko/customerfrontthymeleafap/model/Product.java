package ma.piko.customerfrontthymeleafap.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

 @Getter @Setter

public class Product {

    private String id;

    private String name ;

    private double price;

    private int quantity;

}
