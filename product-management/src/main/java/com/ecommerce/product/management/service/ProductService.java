package com.ecommerce.product.management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.product.management.entity.Product;
import com.ecommerce.product.management.model.ProductDTO;
import com.ecommerce.product.management.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<ProductDTO> getAllProducts() {
		
		List<Product> products = productRepository.findAll();
		return products.stream()
				.map(i -> new ProductDTO(i.getName(), i.getCode(), i.getDescription(), i.getPrice(), i.getCategory()))
				.collect(Collectors.toList());

	}

	public ProductDTO insertProduct(ProductDTO productDTO) {
		productRepository.save(Product.builder()
								.name(productDTO.getName())
								.code(productDTO.getCode())
								.build());
		return productDTO;
	}

}
