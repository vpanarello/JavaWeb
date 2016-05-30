package net.ddns.pannetwork.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ddns.pannetwork.dao.GenericDao;
import net.ddns.pannetwork.entity.Users;

/**
 * Servlet implementation class NewUserServlet
 */
@WebServlet("/admin/novoUsuario")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

    public NewUserServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Acesso cadastro novo user");
		
		request.getRequestDispatcher("/admin/NewUser.jsp").include(request, response);

//		response.sendRedirect("/NewUser.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GenericDao<Users> dao = new GenericDao<>(Users.class);
		
		String user = request.getParameter("user");
		String pwd = request.getParameter("senha");
		
		Users newUser = new Users(user, pwd, 1);
		
		try {
			dao.adicionar(newUser);
		} catch (Exception e) {
			
			request.setAttribute("feedbackMsg", "Usuário já existe");
			request.getRequestDispatcher("NewUser.jsp").forward(request, response);
			e.printStackTrace();
		}
		
		
		response.sendRedirect(request.getContextPath() + "/bemvindo");
		
		
	}

}
