package com.grocery.shop.grocery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "quantity", nullable = false)
	private int quantity;

	
	@Column(name = "mrp_price", nullable = false)
	private double mrpPrice;
	
	@Column(name = "price", nullable = false)
	private double price;
	
	@OneToOne
	@JoinColumn(name = "customer_id", nullable = false, foreignKey = @ForeignKey(name = "CART_CUST_FK") )
	@JsonIgnore
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY)
	//@Cascade({ org.hibernate.annotations.CascadeType.ALL })
    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "CART_PROD_FK") )
	@JsonIgnore
	private Product product;

	@Column(name = "total_price", nullable = false)
	private double totalPrice;

	public Cart() {}

	public Cart(int quantity, double mrpPrice, double price, Customer customer, Product product, double totalPrice) {
		this.quantity = quantity;
		this.mrpPrice = mrpPrice;
		this.price = price;
		this.customer = customer;
		this.product = product;
		this.totalPrice = totalPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getMrpPrice() {
		return mrpPrice;
	}

	public void setMrpPrice(double mrpPrice) {
		this.mrpPrice = mrpPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", quantity=" + quantity + ", mrpPrice=" + mrpPrice + ", price=" + price
				+ ", customer=" + customer + ", product=" + product + ", totalPrice=" + totalPrice + "]";
	}
	
}
