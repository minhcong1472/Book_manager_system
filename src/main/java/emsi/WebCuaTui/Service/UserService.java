package emsi.WebCuaTui.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

import emsi.WebCuaTui.model.User;
import emsi.WebCuaTui.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
