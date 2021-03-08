package com.threez.beauty.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="shoppingCart")
public class ShoppingCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shoppingCartID;
	
	@ManyToMany(mappedBy = "shoppingCartList")
	private Set<Product> productList = new HashSet<Product>();
	
	private Short quantity;
	
	private String sessionID;
	
	@OneToOne(	mappedBy = "shoppingCart",
				cascade = CascadeType.ALL,
				fetch = FetchType.LAZY,
				optional = true)	
	private OrderDetails orderDetails;

	public ShoppingCart() {
		super();
	}

	public Integer getShoppingCartID() {
		return shoppingCartID;
	}

	public void setShoppingCartID(Integer shoppingCartID) {
		this.shoppingCartID = shoppingCartID;
	}

	public Set<Product> getProductList() {
		return productList;
	}

	public void setProductList(Set<Product> productList) {
		this.productList = productList;
	}

	public Short getQuantity() {
		return quantity;
	}

	public void setQuantity(Short quantity) {
		this.quantity = quantity;
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	@Override
	public String toString() {
		return "ShoppingCart [shoppingCartID=" + shoppingCartID + ", productList=" + productList + ", quantity="
				+ quantity + ", sessionID=" + sessionID + "]";
	}
	
	public void addProduct(Product product) {
		// TODO:
	}
	
	public void removeProduct(Product product) {
		// TODO:
	}
	
	public Integer countProductQuantity(Product product) {
		
		Integer count = (int) this.productList.stream().filter(x -> x.getProductId().equals(product.getProductId())).count();
		
		return count;
	}
}
