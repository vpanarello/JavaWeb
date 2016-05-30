/**
 * 
 */
package net.ddns.pannetwork.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * 20160521_Aula01_ProjetoTomCat / Books.java
 * FIAP / RM30222 - Vagner Panarello
 */


@Entity
@Table(name="books")
public class Books implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CODE")
	private int code;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="AUTHOR")
	private String author; 
	
	@Temporal(TemporalType.DATE)
	@Column(name="PUBDATE")
	private Date publicationDate;
	
	@Column(name="PREIS")
	private double preis;
	
	@Lob
	@Column(name="PICT")
	private byte[] image;

	public Books() {
		super();
	}
	
	public Books(String title, String author, Date publicationDate, double preis, byte[] image) {
		super();
		this.title = title;
		this.author = author;
		this.publicationDate = publicationDate;
		this.preis = preis;
		this.image = image;
	}

	public int getCode() {return code;}
	public void setCode(int code) {this.code = code;}
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	public String getAuthor() {return author;}
	public void setAuthor(String author) {this.author = author;}
	public Date getPublicationDate() {return publicationDate;}
	public void setPublicationDate(Date publicationDate) {this.publicationDate = publicationDate;}
	public double getPreis() {return preis;}
	public void setPreis(double preis) {this.preis = preis;}
	public byte[] getImage() {return image;}
	public void setImage(byte[] image) {this.image = image;}
		
}
