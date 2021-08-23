package emsi.WebCuaTui.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import emsi.WebCuaTui.model.BookCase;
import emsi.WebCuaTui.repository.BookCaseRepository;

@Controller
public class BookCaseController {

	@Autowired
	BookCaseRepository BCrepo;
	
	
	@GetMapping("/bookcase")
	public String showBookCase(Model model) {
		List<BookCase> listbookcase = BCrepo.findAll();
		model.addAttribute("listbookcase", listbookcase);
		return"book_case";
	}
}
