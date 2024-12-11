package com.example.springtest;

import com.example.springtest.Controller.BookController;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SpringtestApplicationTests {

	@Autowired
	private BookController bookControllerTest;

	@Test
	void contextLoads() throws Exception {
		Assertions.assertThat(bookControllerTest).isNotNull();
	}

	@Test
	void addSum() {
		assertEquals(4, 2+ 2);
	}

	@Test
	public void testTrue() {
		assertTrue(true);
	}

	@Test
	public void testMultiple() {
		assertEquals(4, 2+ 2);

	}

}
