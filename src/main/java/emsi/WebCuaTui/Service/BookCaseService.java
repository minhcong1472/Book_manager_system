package emsi.WebCuaTui.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emsi.WebCuaTui.repository.BookCaseRepository;

@Service
@Transactional
public class BookCaseService {

	@Autowired
	BookCaseRepository BCrepo;
	
	
//	public Optional<BookCase> findByUserID(Long user_id){
//		return BCrepo.findByUserID(user_id);
//		
//	}
	
}
