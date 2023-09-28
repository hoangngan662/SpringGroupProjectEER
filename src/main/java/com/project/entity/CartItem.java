package com.project.entity;


import com.project.entity.ProductDetail.ProductDetailId;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class CartItem {
	@EmbeddedId
	private CartItemId id;
	
	//extra column
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("customer_id")
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("product_detail_id")
	@JoinColumns({
		@JoinColumn(name = "product_id"),
		@JoinColumn(name = "size_id")
	})
	private ProductDetail product_detail;
	
	
	@Embeddable
	public static class CartItemId {
		private ProductDetailId product_detail_id;
		private long customer_id;
	}

}
