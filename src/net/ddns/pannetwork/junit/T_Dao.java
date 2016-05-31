/**
 * 
 */
package net.ddns.pannetwork.junit;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;



import net.ddns.pannetwork.dao.*;
import net.ddns.pannetwork.entity.*;

/**
 * 20160521_Aula01_ProjetoTomCat / T_Dao.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class T_Dao {
	
	static GenericDao<Users> daoUsers;
	static GenericDao<Books> daoBooks;
	static  EntityManager em;
	
	static String[][] users = {
							{"vagner.panarello", "12345" },
							{"mario.bros" ,"nin1223" },
							{"l.davinche" ,"leodav10" },
							{"a.einstein","alb121212" },
							};
	
	@BeforeClass
	static public void initDaoEntities(){
		
		em =  JpaUtil.getEntityManager();
		
		
		System.out.println("Executando Testes...");
		daoUsers = new GenericDao<>(Users.class);
		daoBooks = new GenericDao<>(Books.class);
		
	}
	

	@Test
	public void testGenericDao() {
		
		
		
		for (Users users : daoUsers.buscar("user", "vagner.panarello")) {
			System.out.println(users.toString());
		}
		
		
	}

}



