/*
 * Copyright (c) Search'XPR - 2011, 2015
 */
package com.example.entities;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author tmaurel
 * @since 27/10/2015
 */
public class Product {

	public String name;

	@JsonView(Views.ProductFocus.class)
	public Category category;

}
