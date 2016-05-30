package net.ddns.pannetwork.servlet;

import java.awt.print.Book;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ddns.pannetwork.dao.GenericDao;
import net.ddns.pannetwork.entity.Books;

import javax.servlet.http.*;


@WebServlet("/admin/novoLivro")
public class storeBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public storeBookServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/admin/NewBook.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GenericDao<Books> dao = new GenericDao<>(Books.class);
		
		InputStream inStream = null;
		Part filePart = null;
		byte[] imagem = null;
		
		


		try {
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String pDate = request.getParameter("pDate");
			
			int code = Integer.parseInt(request.getParameter("code"));
			Date pubDate = new SimpleDateFormat("dd/MM/yyyy").parse(pDate);
			Double preis = Double.parseDouble(request.getParameter("preis"));

			filePart = request.getPart("pict");

		
			if (filePart != null) {
				imagem = new byte[(int) filePart.getSize()];
				inStream = filePart.getInputStream();
				inStream.read(imagem, 0, (int) filePart.getSize());
			}
			
			Books book = new Books(title, author, pubDate, preis, imagem);
			
			dao.adicionar(book);
			

		} catch (ParseException e) {
			System.out.println("Erro de parse com Datas");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Erro Generico: " + e.getMessage());
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/admin/NewBook.jsp").forward(request, response);
		
		
	}

}
