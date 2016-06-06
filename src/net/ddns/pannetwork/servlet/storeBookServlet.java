package net.ddns.pannetwork.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.text.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import net.ddns.pannetwork.dao.*;
import net.ddns.pannetwork.entity.*;



@WebServlet("/admin/novoLivro")
@MultipartConfig
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
		InputStream inStream = null; Part filePart = null; byte[] imagem = null;
		
		String[] param =  {	"code",
							"title",
							"author",
							"pDate",
							"preis",
							"pict"};
		String[] values = new String[param.length];
		
		for (int i = 0; i < param.length; i++){
			values[i] = request.getParameter(param[i]);
		}
		
		Books book = null;
		
		filePart = request.getPart("pict");
		
				
		if (filePart != null) {
			imagem = new byte[(int) filePart.getSize()];
			inStream = filePart.getInputStream();
			inStream.read(imagem, 0, (int) filePart.getSize());

		}
		
		try {
			book = new Books( Integer.parseInt(values[0]),
									values[1],
									values[2],
									new SimpleDateFormat("dd/MM/yyyy").parse(values[3]),
									Double.parseDouble(values[4]),
									imagem);
			
		} catch (NumberFormatException | ParseException e1) {
			e1.printStackTrace();
		}
	
		
		dao.adicionar(book);
		
		request.setAttribute("storeBookMsg", "Livro Armazenado no DB");
		
		request.getRequestDispatcher("/admin/menuPrincipal").forward(request, response);
	}
	
}
