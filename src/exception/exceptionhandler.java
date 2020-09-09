package exception;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class exceptionhandler {
	@ExceptionHandler(SQLException.class)
	public String handleSQLException(HttpServletRequest request, Exception ex){
		return "database_error";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String nullpointer(HttpServletRequest request, Exception ex){
		return "database_error";
	}	
	

	@ExceptionHandler(ClassNotFoundException.class)
	public String method(HttpServletRequest request, Exception ex){
		return "d";
	}	
	
	
}
