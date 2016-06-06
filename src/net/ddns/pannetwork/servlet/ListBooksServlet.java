package net.ddns.pannetwork.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ddns.pannetwork.dao.GenericDao;
import net.ddns.pannetwork.entity.Books;


@WebServlet("/admin/listaLivros")
public class ListBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListBooksServlet() {
        super();
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GenericDao<Books> daoBook =  new GenericDao<>(Books.class);
		
		String code = (String)request.getParameter("code");
		String action = (String) request.getParameter("action");
		
		System.out.println(code + " " + action );
		
		if (action == null || code == null) System.out.println("null pointer");
		else if (action.equals("delete")){
			Books book = daoBook.buscar(Integer.parseInt(code));
			if(book != null) daoBook.remover(book);
		}
		
		List<Books> books = daoBook.listar();
		
		request.setAttribute("booksList", books);
		request.getRequestDispatcher("/admin/ListBooks.jsp").forward(request, response);
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
