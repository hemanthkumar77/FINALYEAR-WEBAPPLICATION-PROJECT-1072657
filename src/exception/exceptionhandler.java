package exception;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

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
		mod.addAttribute("error","Back End Team Is Working On It");
		return "exception";
	}	
	
	
}
