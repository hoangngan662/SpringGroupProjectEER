package com.project.entity;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductDetail")
public class ProductDetail {
	@EmbeddedId
	private ProductDetailId id;
	
	//extra column
	private int inventory;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("product_id")
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("size_id")
	@JoinColumn(name = "size_id")
	private Size size;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product_detail", orphanRemoval = true)
	private Set<CartItem> cartItems = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product_detail", orphanRemoval = true)
	private Set<BillItem> billItems = new HashSet<>();
	
	@Embeddable
	public static class ProductDetailId{
		private long product_id;
		private long size_id;
	}
	

}
