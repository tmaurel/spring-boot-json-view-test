/*
 * Copyright (c) Search'XPR - 2011, 2015
 */
package com.example.entities;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

/**
 * @author tmaurel
 * @since 27/10/2015
 */
public class Category {

	@JsonView(Views.CategoryFocus.class)
	public List<Product> products;

	public String name;

}
