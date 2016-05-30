package net.ddns.pannetwork.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.ddns.pannetwork.dao.GenericDao;
import net.ddns.pannetwork.entity.Users;


@WebServlet(
		name="Servlet Login",
		urlPatterns = { "/bemvindo" }
		)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	GenericDao<Users> daoUsers;
	

    public LoginServlet() {
        super();
        daoUsers =  new GenericDao<>(Users.class);
    }
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("login.jsp").include(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("goPost: LoginServlet");
		
		String user = request.getParameter("user");
		String pwd = request.getParameter("senha");
		
		Users loginUser = null;
		try {
			loginUser = daoUsers.authentication(user, pwd);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		if (loginUser != null){
			
			HttpSession session = request.getSession();
			session.setAttribute("usuario_sessao", loginUser);
			
			response.sendRedirect("admin/menuPrincipal");
			
		} else {
			request.setAttribute("loginMsg", "Senha /Nome não conferem");
			request.getRequestDispatcher("login.jsp").include(request, response);		
		}
	}
}
