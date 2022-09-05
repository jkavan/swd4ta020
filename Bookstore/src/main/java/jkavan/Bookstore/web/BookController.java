package jkavan.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jkavan.Bookstore.domain.Book;
import jkavan.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	

	@GetMapping(value={"/", "/booklist"})
	public String booklist(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist"; 
	}
	
    @RequestMapping(value = "/addbook")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
        return "addbook";
    }
    
    @PostMapping(value = "/addbook")
    public String addBookSubmit(Book book){
        repository.save(book);
        return "redirect:/booklist";
    }
    
    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model){
    	model.addAttribute("book", repository.findById(bookId));
        return "editbook";
    }
    
    @PostMapping(value = "/edit")
    public String editBookSubmit(Book book){
        repository.save(book);
        return "redirect:/booklist";
    }

    /* Should be a DeleteMapping to prevent search engines from crawling to the delete page */
    @GetMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId) {
    	repository.deleteById(bookId);
        return "redirect:/booklist";
    }  
}
