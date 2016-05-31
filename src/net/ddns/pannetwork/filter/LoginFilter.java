package net.ddns.pannetwork.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.ddns.pannetwork.entity.Users;

/* Filtro aplicável somente as classes especificadas */
@WebFilter("/admin/*")
public class LoginFilter implements Filter {

 
    public LoginFilter() {

    }


	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		Users users = (Users)session.getAttribute("usuario_sessao");
		
		if(users == null){
			((HttpServletResponse)response).sendRedirect("/aula01/bemvindo");
		}else {
			// pass the request along the filter chain
			System.out.printf("Usuário Logado: %s%n", users.getUser());
			
			chain.doFilter(request, response);	
		}
		
	
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
