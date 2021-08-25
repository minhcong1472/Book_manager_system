package emsi.WebCuaTui.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import emsi.WebCuaTui.model.Book;
import emsi.WebCuaTui.model.BookCase;
import emsi.WebCuaTui.model.User;
import emsi.WebCuaTui.repository.BookCaseRepository;
import emsi.WebCuaTui.repository.BookRepositoty;
import emsi.WebCuaTui.repository.UserRepository;

@Controller
public class BookCaseController {

	@Autowired
	BookCaseRepository bcRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	BookRepositoty bookRepo;
	
//	@Autowired
//	BookService bookService;

	@GetMapping("/bookcase")
	public String showBookCase(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		org.springframework.security.core.userdetails.User au = (org.springframework.security.core.userdetails.User) authentication
				.getPrincipal();

		User user = userRepo.findByEmail(au.getUsername());
		BookCase bookcase = new BookCase();
		bookcase = bcRepo.findByUser(user);
		bookcase.getBooks().forEach(s -> System.out.println(s));
		List<Book> listbookcase = new ArrayList<Book>(bookcase.getBooks());
		
		model.addAttribute("listbookcase", listbookcase);
		return "book_case";
	}

	@GetMapping("/add/{book_id}")
	public ModelAndView addBook(@PathVariable(name = "book_id") Long book_id) {
		Book book = bookRepo.findById(book_id).orElse(null);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		org.springframework.security.core.userdetails.User au = (org.springframework.security.core.userdetails.User) authentication
				.getPrincipal();
		User user = userRepo.findByEmail(au.getUsername());
		BookCase bookcase = new BookCase();
		bookcase = bcRepo.findByUser(user);
		bookcase.getBooks().add(book);
		bcRepo.save(bookcase);
		return new ModelAndView("redirect:/book");
	}

	@RequestMapping("/removebook/{book_id}")
	public String removeBookInCart(@PathVariable(name="book_id")Long book_id ) {
		Book book = bookRepo.findById(book_id).orElse(null);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		org.springframework.security.core.userdetails.User au = (org.springframework.security.core.userdetails.User) authentication
				.getPrincipal();
		User user = userRepo.findByEmail(au.getUsername());
		BookCase bookcase = new BookCase();
		bookcase = bcRepo.findByUser(user);
		bookcase.getBooks().remove(book);
		bcRepo.save(bookcase);
		return "redirect:/bookcase";
		
	}
	@GetMapping("/clear")
	public String clearCart() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		org.springframework.security.core.userdetails.User au = (org.springframework.security.core.userdetails.User) authentication
				.getPrincipal();
		User user = userRepo.findByEmail(au.getUsername());
		BookCase bookcase = new BookCase();
		bookcase = bcRepo.findByUser(user);
		bookcase.getBooks().clear();
		bcRepo.save(bookcase);
		
		
		return "redirect:/bookcase";
		
	}
}
