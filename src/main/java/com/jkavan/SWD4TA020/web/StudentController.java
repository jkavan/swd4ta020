package com.jkavan.SWD4TA020.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jkavan.SWD4TA020.domain.Student;

@Controller
public class StudentController {
	
	private List<Student> students = new ArrayList<>();

	public StudentController() {
		super();
		this.students.add(new Student("Matti", "Meikäläinen"));
		this.students.add(new Student("Foo", "Bar"));
	}

	@GetMapping("/students")
	public String returnStudents(Model model) {
		model.addAttribute("student", new Student("", ""));
		model.addAttribute("students", this.students);
		return "students";
	}

	@PostMapping("/students")
	public String studentSubmit(
		@ModelAttribute
		Student student,
		Model model
	) {
		this.students.add(student);
		return "redirect:/students";
	}
}
