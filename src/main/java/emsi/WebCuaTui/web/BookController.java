package emsi.WebCuaTui.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import emsi.WebCuaTui.Service.BookService;
import emsi.WebCuaTui.model.Book;
import emsi.WebCuaTui.repository.BookCaseRepository;
import emsi.WebCuaTui.repository.BookRepositoty;
import emsi.WebCuaTui.repository.UserRepository;

@Controller

public class BookController {
	
	@Autowired
	BookCaseRepository bcRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	BookRepositoty bookRepo;
	
	@Autowired
	BookService service;
	
	//show list book
	@RequestMapping("/book")
	public String showListBook(Model model, @Param("keyword") String keyword ) {
		List<Book> listbook = service.listAll(keyword);
		model.addAttribute("listbook", listbook);
		model.addAttribute("keyword",keyword);
		return "book";
		
	}
	
	// create a new book
	@RequestMapping("/newBook")
	public String NewBook(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "book_new";
	}
	
	
	//show a viewbook with book_id
	@RequestMapping("/view/{book_id}")
	public ModelAndView ShowViewBook(@PathVariable(name="book_id")Long book_id) {
		ModelAndView mav = new ModelAndView("book_view");
		Book book = service.get(book_id);
		mav.addObject("book",book);
		return mav;
	}
	
	//edit book
	@RequestMapping("/edit/{book_id}")
	public ModelAndView ShowEDITBook(@PathVariable(name="book_id")Long book_id) {
		ModelAndView mav = new ModelAndView("book_edit");
		Book book = service.get(book_id);
		mav.addObject("book",book);
		return mav;
	}
	
	// save book when new a book and edit a book
	@RequestMapping(value= "/saveBook" , method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("book")Book book , Model model, @Param("keyword") String keyword) {
		service.save(book);
		List<Book> listbook = service.listAll(keyword);
		model.addAttribute("listbook",listbook);
		model.addAttribute("keyword" ,  keyword);
		return "book";
		
	}
	
	//delete a book
	@RequestMapping("/delete/{book_id}")
	public String deleteBook(@PathVariable(name="book_id")Long book_id , Model model , @Param("keyword") String keyword) {
		service.delete(book_id);		
		List<Book> listbook = service.listAll(keyword);
		model.addAttribute("listbook",listbook);
		return"redirect:/book";
	}
	
}
