package com.cg.onlineshoppingapps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id")
	@SequenceGenerator(sequenceName = "PRODUCT_SEQ5", allocationSize = 1, name = "product_id")
	@Column(name = "product_id")
	private int productId;

	@Column(name = "product_name")
	private String productName;

	@NotNull(message = "Price Cannot Be Null!!")
	@Column(name = "price")
	private double price;

	@Column(name = "color")
	private String color;

	@Column(name = "dimensions")
	private String dimension;

	@Column(name = "specifications")
	private String specification;

	@Column(name = "manufacturer")
	private String manufacturer;

	@NotNull(message = "Quantity Should Be Greater Than 0")
	@Column(name = "quantity")
	private int quantity;

	@Column(name = "PRODUCT_IMAGE_URL")
	private String productImageUrl;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private CategoryEntity category;
	
//	@ManyToMany(mappedBy = "cart")
//	private List<CartEntity> cart = new ArrayList<>();
	
	public ProductEntity() {
		super();
	}

	public ProductEntity(int productId, String productName, double price, String color, String dimension,
			String specification, String manufacturer, int quantity, String productImageUrl,
			CategoryEntity category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.color = color;
		this.dimension = dimension;
		this.specification = specification;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.productImageUrl = productImageUrl;
		this.category = category;
	}

	public ProductEntity(String string) {
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", color=" + color + ", dimension=" + dimension + ", specification=" + specification
				+ ", manufacturer=" + manufacturer + ", quantity=" + quantity + ", productImageUrl="
				+ productImageUrl + ", category=" + category + "]";
	}

}
