package jkavan.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jkavan.Bookstore.web.BookController;
import jkavan.Bookstore.web.CategoryController;

@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;
	
	@Autowired
	private CategoryController categoryController;
	
	@Test
	void contextLoads() {
		assertThat(bookController).isNotNull();
		assertThat(categoryController).isNotNull();
	}

}
