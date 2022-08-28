package com.jkavan.SWD4TA020.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jkavan.SWD4TA020.domain.Student;

@Controller
public class StudentController {

	@RequestMapping("/students")
	public String returnStudents(
			Model model) {
		List<Student> students = new ArrayList<>();

		students.add(new Student("Matti", "Meikäläinen"));
		students.add(new Student("Foo", "Bar"));
		
		model.addAttribute("students", students);
		return "students";
	}
}
