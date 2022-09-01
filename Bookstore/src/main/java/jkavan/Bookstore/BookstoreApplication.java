package jkavan.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import jkavan.Bookstore.domain.Book;
import jkavan.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {					
			repository.save(new Book("Dracula", "Bram Stoker", 1897, "1503261387", 9));
			repository.save(new Book("Kubernetes: Up and Running", "Brendan Burns", 2019, "9781492046530", 58));
			
			for (Book book : repository.findAll()) {
				System.out.println(book);
			}
		};
	}
	
}
