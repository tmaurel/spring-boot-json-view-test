package com.example.controllers;

import com.example.entities.Category;
import com.example.entities.Product;
import com.example.entities.Purchase;
import com.example.entities.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tmaurel
 * @since 27/10/2015
 */

@RestController
@RequestMapping("/")
public class TestController {

	private final Map<Long, Product> products;
	private final Map<Long, Category> categories;
	private final Map<Long, Purchase> purchases;

	{
		this.products = new HashMap<>();
		this.categories = new HashMap<>();
		this.purchases = new HashMap<>();

		final Product product1 = new Product();
		product1.name = "product1";

		final Product product2 = new Product();
		product2.name = "product2";

		final Category category = new Category();
		category.name = "category1";
		category.products = new ArrayList<>();
		category.products.add(product1);
		category.products.add(product2);

		product1.category = category;
		product2.category = category;

		final Purchase purchase = new Purchase();
		purchase.products = new ArrayList<>();
		purchase.products.add(product1);
		purchase.products.add(product2);

		this.products.put(1L, product1);
		this.products.put(2L, product2);

		this.categories.put(1L, category);

		this.purchases.put(1L, purchase);
	}

	@JsonView(Views.ProductFocus.class)
	@RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
	Product getProduct(@PathVariable final Long productId) {
		return this.products.get(productId);
	}

	@JsonView(Views.CategoryFocus.class)
	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
	Category getCategory(@PathVariable final Long categoryId) {
		return this.categories.get(categoryId);
	}

	@JsonView(Views.ProductFocus.class)
	@RequestMapping(value = "/purchase/{purchaseId}", method = RequestMethod.GET)
	Purchase getPurchase(@PathVariable final Long purchaseId) {
		return this.purchases.get(purchaseId);
	}

}
