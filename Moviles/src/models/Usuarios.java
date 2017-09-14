package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="usuario")
public class Usuarios 
{
	private int idusr;
	private String nomusr;
	private String passusr;
	private String token;
	
	Conexion objC;
	Connection con;
	
	@XmlElement(required=true)
	public int getIdusr() {
		return idusr;
	}
	
	@XmlElement(required=true)
	public String getNomusr() {
		return nomusr;
	}
	
	@XmlElement(required=true)
	public String getPassusr() {
		return passusr;
	}
	
	@XmlElement(required=true)
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setIdusr(int idusr) {
		this.idusr = idusr;
	}
	public void setNomusr(String nomusr) {
		this.nomusr = nomusr;
	}
	public void setPassusr(String passusr) {
		this.passusr = passusr;
	}
	
	public void viewUser()
	{
		try 
		{
			objC = new Conexion();
			con = objC.getCon();
			
			String query="select * from usuario where idusr="+idusr;
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			if (res.next()) 
			{
				nomusr=res.getString("nomusr");
				passusr=res.getString("passusr");
			}
			con.close();
			
		} 
		catch (Exception e) 
		{
		}
	}
	
	public void validaUsuario()
	{
		try 
		{
			objC = new Conexion();
			con = objC.getCon();
			String query = "select * from usuario"
					+ "where nomusr="+nomusr+" and passusr="+passusr;
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			if (res.next()) 
			{
				token="Valido :U a no ma";
			}
			else
			{
				token="Sesion no valida";
			}
				
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void insUsuario()
	{
		try
		{
			objC = new Conexion();
			con = objC.getCon();
			
			String query = "insert into usuario"
					+ "(nomusr, passusr) "
					+ "values ('"+nomusr+"', '"+passusr+"')";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			con.close();
		}
		catch (Exception e) 
		{
		}
	}
	
	public void updUsuario()
	{
		try
		{
			objC = new Conexion();
			con = objC.getCon();
			
			String query = "update usuario set "
					+ "nomusr = '"+nomusr+"', "
					+ "passusr = '"+passusr+"'"
						+ " where idusr = "+idusr;
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			con.close();
		}
		catch (Exception e) 
		{
		}
	}
	
	public void delUsuario()
	{
		try
		{
			objC = new Conexion();
			con = objC.getCon();
			
			String query = "delete from usuario where idusr = "+idusr+"";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			con.close();
		}
		catch (Exception e) 
		{
		}
	}
	
	public List<Usuarios> listUsuarios()
	{
		List <Usuarios> arrUsrs = null;
		try
		{
			arrUsrs = new ArrayList<>();
			Usuarios objUsr;
			objC = new Conexion();
			con = objC.getCon();
			
			String query = "select * from usuario order by idusr";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			while (res.next()) 
			{
				objUsr = new Usuarios();
				objUsr.idusr = res.getInt("idusr");
				objUsr.nomusr = res.getString("nomusr");
				objUsr.passusr = res.getString("passusr");
				arrUsrs.add(objUsr);
			}
			con.close();
		}
		catch (Exception e) 
		{
		}
		return arrUsrs;
	}
	
	public Usuarios viewUsuario()
	{
		try
		{
			objC = new Conexion();
			con = objC.getCon();
			
			String query = "select * from usuario where idusr = "+idusr+"";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			
			if (res.next())
			{
				this.idusr = res.getInt("idusr");
				this.nomusr = res.getString("nomusr");
				this.passusr = res.getString("passusr");
				con.close();
			}
			return this;
			
		}
		catch (Exception e) 
		{
			this.nomusr = e.toString();
			return this;
		}
		
	}

}
