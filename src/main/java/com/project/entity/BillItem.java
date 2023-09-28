package com.project.entity;

import java.util.Date;

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
public class BillItem {
	@EmbeddedId
	private BillItemId id;
	
	//extra column
	private int quantity;
	private Date rate_date;
	private String rate_content;
	private int point;
	private long price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("bill_id")
	@JoinColumn(name = "bill_id")
	private Bill bill;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("product_detail_id")
	@JoinColumns({
		@JoinColumn(name = "product_id"),
		@JoinColumn(name = "size_id")
	})
	private ProductDetail product_detail;
	
	@Embeddable
	public static class BillItemId {
		private ProductDetailId product_detail_id;
		private long bill_id;
	}

}
