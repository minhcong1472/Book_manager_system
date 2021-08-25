package emsi.WebCuaTui.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emsi.WebCuaTui.model.Book;
import emsi.WebCuaTui.repository.BookRepositoty;

@Service
@Transactional
public class BookService {
	
	@Autowired
	private BookRepositoty repo;

	public List<Book> listAll (String keyword){
		if(keyword!=null) {
			return repo.findAll(keyword);
	}
		return repo.findAll();
}
	public void save(Book book) {
		repo.save(book);
	}
	
	public void delete(Long book_id) {
		repo.deleteById(book_id);
	}
	public Book get(Long book_id) {
		return repo.findById(book_id).get();
	}
	
	public Optional<Book> getBookByID(Long book_id){
		return repo.findById(book_id);
		
	}
}
