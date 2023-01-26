package me.anvarisy.kodegiri.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
    @Id
    private int id;
    private String name;
    private double price;
    private long stock;
}
