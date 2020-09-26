package exception;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.hibernate.NonUniqueObjectException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class exceptionhandler {
	@ExceptionHandler(SQLException.class)
	public String handleSQLException(HttpServletRequest request, Exception ex,Model mod){
		mod.addAttribute("error","DB TEAM IS WORKING ONE");
		return "exception";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String nullpointer(HttpServletRequest request, Exception ex,Model mod){
		mod.addAttribute("error","No data is available");
		return "exception";
	}	
	

	@ExceptionHandler(ClassNotFoundException.class)
	public String method(HttpServletRequest request, Exception ex,Model mod){
		mod.addAttribute("error","Back End Team Is Working On It");
		return "exception";
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String runner(HttpServletRequest request, Exception ex,Model mod){
		mod.addAttribute("error","RUN TIME ERROR");
		return "exception";
	}	
	
	@ExceptionHandler(NumberFormatException.class)
	public String conversion(HttpServletRequest request, Exception ex,Model mod){
		mod.addAttribute("error","input conversion problem");
		return "exception";
	}
	
	
	@ExceptionHandler(NonUniqueObjectException.class)
	public String hiber(HttpServletRequest request, Exception ex,Model mod){
		mod.addAttribute("error","duplicate entry in the DB");
		return "exception";
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public String duplicate(HttpServletRequest request, Exception ex,Model mod){
		mod.addAttribute("error","duplicate entry in the DB");
		return "exception";
	}
	
}
