package net.ddns.pannetwork.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(description = "Menu principal da aplicacao", urlPatterns = { "/admin/menuPrincipal" })
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MenuServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		List<ItemLista> menu = new ArrayList<>();
		
		menu.add(new ItemLista("Listar livros do DB", ""));
		menu.add(new ItemLista("Cadastrar novo usuário", request.getContextPath() + "/admin/novoUsuario"));
		menu.add(new ItemLista("Cadastrar novo livro", request.getContextPath() + "/admin/novoLivro"));
		
		request.setAttribute("listaMenu", menu);
		
		request.getRequestDispatcher("/admin/Menu.jsp").include(request, response);
		

//		response.getWriter().print("<h3>Menu Principal</h3>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
