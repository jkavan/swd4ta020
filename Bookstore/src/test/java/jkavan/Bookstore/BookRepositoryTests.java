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
import jkavan.Bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class BookRepositoryTests {

	@Autowired
	private CategoryRepository categories;
	
	@Autowired
	private BookRepository repository;
	
	@Test
	void testFindBookShouldReturnBook() {
		Book book = repository.findByTitle("Kubernetes: Up and Running").get(0);
		assertThat(book.getAuthor()).isEqualTo("Brendan Burns");
	}
	
	@Test
	void testCreateNewBook() {
		Book book = new Book(
				"Test Book",
				"Test Author",
				2022,
				"123456890",
				50,
				categories.findByName("Best sellers").get(0)
		);
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}

	@Test
	void testDeleteBook() {
		Book book = repository.findByTitle("Kubernetes: Up and Running").get(0);
		repository.delete(book);
		List<Book> books = repository.findByTitle("Kubernetes: Up and Running");
		assertThat(books).hasSize(0);
		
	}
}
