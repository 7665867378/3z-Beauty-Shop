package com.threez.beauty.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.threez.beauty.enums.Unit;

@Entity(name = "Product")
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	private Integer sku;
	private String name;
	private String description;
	@Enumerated(EnumType.STRING)
	private Unit unit;
	private Double unitPrice;
	private Double weight;
	private Double size;
	private String image;
	private String thumbnail;
	private Integer stock;
	
	@ManyToMany(
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			}
	)
	@JoinTable(
			name = "productCategory",
			joinColumns = @JoinColumn(name = "productId"),
			inverseJoinColumns = @JoinColumn(name = "categoryId")
	)
	private Set<Category> categoryList = new HashSet<Category>();
	
	@ManyToMany(
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
    })
	@JoinTable(
			name = "productShoppingCart",
			joinColumns = @JoinColumn(name = "productId"),
			inverseJoinColumns = @JoinColumn(name="shoppingCartID")
	)
	private Set<ShoppingCart> shoppingCartList = new HashSet<ShoppingCart>();
	
	public Product() {
		super();
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getSku() {
		return sku;
	}
	public void setSku(Integer sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getSize() {
		return size;
	}
	public void setSize(Double size) {
		this.size = size;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Set<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(Set<Category> categoryList) {
		this.categoryList = categoryList;
	}
	public Set<ShoppingCart> getShoppingCartList() {
		return shoppingCartList;
	}
	public void setShoppingCartList(Set<ShoppingCart> shoppingCartList) {
		this.shoppingCartList = shoppingCartList;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", sku=" + sku + ", name=" + name + ", description=" + description
				+ ", unit=" + unit + ", unitPrice=" + unitPrice + ", weight=" + weight + ", size=" + size + ", image="
				+ image + ", thumbnail=" + thumbnail + ", stock=" + stock + ", categoryList=" + categoryList
				+ ", shoppingCartList=" + shoppingCartList + "]";
	}
	
}
