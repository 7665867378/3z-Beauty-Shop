package com.threez.beauty.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderDetails")
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String orderDetailsID;
	
	private Double total;
	
	private String shippingAddress;
	
	private String contactNumber;
	
	@OneToOne(
			cascade = {
					CascadeType.MERGE,
					CascadeType.PERSIST
			},
			fetch = FetchType.LAZY,
			optional = false
	)
	private ShoppingCart shoppingCart;

	@OneToOne(	mappedBy = "orderDetails",
				cascade = CascadeType.ALL,
				optional = true)
	private Transaction transaction;
	
	private String firstname;
	
	private String lastname;

	public String getOrderDetailsID() {
		return orderDetailsID;
	}

	public void setOrderDetailsID(String orderDetailsID) {
		this.orderDetailsID = orderDetailsID;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderDetailsID=" + orderDetailsID + ", total=" + total + ", shippingAddress="
				+ shippingAddress + ", contactNumber=" + contactNumber + ", shoppingCart=" + shoppingCart
				+ ", transaction=" + transaction + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
}
