package jkavan.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jkavan.Bookstore.domain.Category;
import jkavan.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository repository;

	@GetMapping("/categories")
	public String categorylist(Model model) {
		model.addAttribute("categories", repository.findAll());
		System.out.println(repository.findAll());
		return "categories";
	}
	
    @RequestMapping(value = "/addcategory")
    public String addCategory(Model model){
    	model.addAttribute("category", new Category());
        return "addcategory";
    }
    
    @PostMapping(value = "/savecategory")
    public String saveCategory(Category category) {
        repository.save(category);
        return "redirect:/categories";
    }
    
    @RequestMapping(value = "/editcategory/{id}")
    public String editCategory(@PathVariable("id") Long categoryId, Model model){
    	model.addAttribute("category", repository.findById(categoryId));
        return "editcategory";
    }

    @GetMapping(value = "/deletecategory/{id}")
    public String deleteCategory(@PathVariable("id") Long categoryId) {
    	repository.deleteById(categoryId);
        return "redirect:/categories";
    }  
}
