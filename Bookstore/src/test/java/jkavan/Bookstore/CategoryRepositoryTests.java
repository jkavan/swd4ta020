package jkavan.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jkavan.Bookstore.domain.Book;
import jkavan.Bookstore.domain.BookRepository;
import jkavan.Bookstore.domain.Category;
import jkavan.Bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CategoryRepositoryTests {

	@Autowired
	private CategoryRepository repository;
	
	@Test
	void testFindCategoryShouldReturnCategory() {
		Category category = repository.findByName("Best sellers").get(0);
		assertThat(category).isNotNull();
	}
	
	@Test
	void testCreateNewCategory() {
		Category category = new Category("Test category");
		repository.save(category);
		assertThat(category.getId()).isNotNull();
	}

	@Test
	void testDeleteBook() {
		Category category = repository.findByName("Best sellers").get(0);
		repository.delete(category);
		List<Category> categories = repository.findByName("Best sellers");
		assertThat(categories).hasSize(0);
		
	}
}
