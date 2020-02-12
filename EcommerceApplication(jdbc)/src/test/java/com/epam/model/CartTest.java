package com.epam.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class CartTest {

	@Test
	public void testCartConstructor() {
		Cart cart = new  Cart(1, 2);
		assertNotNull(cart);
	}
}
