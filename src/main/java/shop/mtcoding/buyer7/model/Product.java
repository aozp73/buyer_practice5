package shop.mtcoding.buyer7.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private int price;
    private int qty;
    private Timestamp createdAt;
}
