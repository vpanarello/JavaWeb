/**
 * 
 */
package net.ddns.pannetwork.servlet;

import java.io.Serializable;

/**
 * Aula01 / ItensLista.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class ItemLista implements Serializable {
	
	String link;
	String titulo;
	public ItemLista(String titulo, String link) {
		super();
		this.link = link;
		this.titulo = titulo;
	}
	public String getLink() {
		return link;
	}
	public String getTitulo() {
		return titulo;
	}
	
	

}
