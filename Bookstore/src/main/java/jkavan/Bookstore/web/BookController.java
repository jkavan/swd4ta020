package jkavan.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jkavan.Bookstore.domain.Book;
import jkavan.Bookstore.domain.BookRepository;
import jkavan.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository categories;

	@GetMapping(value={"/", "/booklist"})
	public String booklist(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist"; 
	}

    @GetMapping(value="/books")
    public @ResponseBody List<Book> studentListRest() {
        return (List<Book>) repository.findAll();
    }
    @GetMapping(value="/book/{id}")
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
        return repository.findById(bookId);
    }
	
    @RequestMapping(value = "/addbook")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", categories.findAll());
        return "addbook";
    }
    
    @PostMapping(value = "/savebook")
    public String save(Book book){
        repository.save(book);
        return "redirect:/booklist";
    }
    
    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model){
    	model.addAttribute("book", repository.findById(bookId));
    	model.addAttribute("categories", categories.findAll());
        return "editbook";
    }

    /* Should be a DeleteMapping to prevent search engines from crawling to the delete page */
    @GetMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId) {
    	repository.deleteById(bookId);
        return "redirect:/booklist";
    }  
}
