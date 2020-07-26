package com.ecommerce.product.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.product.management.model.ProductDTO;
import com.ecommerce.product.management.service.ProductService;

@RestController
@RequestMapping("/v1")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/products")
	public ResponseEntity<List<ProductDTO>> getAllProducts() {
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}

	@PostMapping("/product/insert")
	public ResponseEntity<ProductDTO> insertProduct(@RequestBody ProductDTO productDTO) {
		try {
			ProductDTO poductDTO = productService.insertProduct(productDTO);
			return new ResponseEntity<>(poductDTO, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

}
