package com.ecommerce.product.management.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {

	private String name;
	private String code;
	private String description;
	private Double price;
	private String category;
	
	public ProductDTO(ProductDTOBuilder productDTOBuilder) {
		this.name = productDTOBuilder.name;
		this.code = productDTOBuilder.code;
		this.price = productDTOBuilder.price;
	}

	public static class ProductDTOBuilder {
		private String name;
		private String code;
		private Double price;
		
		public ProductDTOBuilder(String name, String code, Double price) {
			this.name = name;
			this.code = code;
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}
		
		public ProductDTO build() {
			return new ProductDTO(this);
		}
	}
}
