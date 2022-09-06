package jkavan.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import jkavan.Bookstore.domain.Category;
import jkavan.Bookstore.domain.CategoryRepository;
import jkavan.Bookstore.domain.Book;
import jkavan.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CategoryRepository categories, BookRepository books) {
		return (args) -> {
			categories.save(new Category("Best sellers"));
			categories.save(new Category("New books"));
			books.save(new Book("Dracula", "Bram Stoker", 1897, "1503261387", 9, categories.findByName("Best sellers").get(0)));
			books.save(new Book("Kubernetes: Up and Running", "Brendan Burns", 2019, "9781492046530", 58, categories.findByName("New books").get(0)));
			
			for (Book book : books.findAll()) {
				System.out.println(book);
			}
		};
	}
	
}
