package net.ddns.pannetwork.servlet;

import java.awt.print.Book;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ddns.pannetwork.dao.GenericDao;
import net.ddns.pannetwork.entity.Books;


@WebServlet("/admin/Imagem")
public class PictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PictureServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	GenericDao<Books> daoBooks = new GenericDao<>(Books.class);
		
		int codeArg = Integer.parseInt(request.getParameter("code"));
		System.out.println("ImgCode: " + codeArg);
		Books book = daoBooks.buscar(codeArg);
		
		byte[] image = book.getImage();
		
		response.setContentType("image/jpeg");
		ServletOutputStream outS = response.getOutputStream();
		outS.write(image);
		outS.close();
		
//		response.getWriter().append("ImgCode: ").append(Integer.toString(codeArg));
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
