/**
 * 
 */
package net.ddns.pannetwork.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(
		name="users",
		uniqueConstraints={
				@UniqueConstraint(columnNames={"USER"})
				}
		)
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	
	@Column(name="USER" , unique=true)
	private String user;
	
	@Column(name="PWD")
	private String pwd;
	
	@Column(name="LEVEL")
	private int level;
	
	
	public Users() {
		super();
	}
	public Users(String user, String pwd, int level) {
		super();
		this.user = user;
		this.pwd = pwd;
		this.level = level;
	}
	
	@Override
	public String toString() {
		return "id=" + id + ", user=" + user + ", pwd=" + pwd + ", level=" + level;
	}

	public int getId() { return id;}
	public void setId(int id) {this.id = id;}
	public String getUser() {return user;}
	public void setUser(String user) {this.user = user;}
	public String getPwd() {return pwd;}
	public void setPwd(String pwd) {this.pwd = pwd;}
	public int getLevel() {return level;}
	public void setLevel(int level) {this.level = level;}
	
}
