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
@XmlRootElement(name="cliente")
public class Clientes 
{
	private int idcliente;
	private String nomcliente;
	private String emailcliente;
	private String fotocliente;
	private int idusr;
	private Usuarios usr;
	
	private Connection con;
	private Conexion objC;
	
	@XmlElement(required=true)
	public int getIdcliente() {
		return idcliente;
	}
	
	@XmlElement(required=true)
	public String getNomcliente() {
		return nomcliente;
	}
	
	@XmlElement(required=true)
	public String getEmailcliente() {
		return emailcliente;
	}
	
	@XmlElement(required=true)
	public String getFotocliente() {
		return fotocliente;
	}
	
	@XmlElement(required=true)
	public int getIdusr() {
		return idusr;
	}
	
	@XmlElement(required=true)
	public Usuarios getUsr() {
		return usr;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public void setNomcliente(String nomcliente) {
		this.nomcliente = nomcliente;
	}
	public void setEmailcliente(String emailcliente) {
		this.emailcliente = emailcliente;
	}
	public void setFotocliente(String fotocliente) {
		this.fotocliente = fotocliente;
	}
	public void setIdusr(int idusr) {
		this.idusr = idusr;
	}
	
	
	public void insCliente()
	{
		try
		{
			objC = new Conexion();
			con = objC.getCon();
			
			String query = "insert into cliente"
					+ "(nomcliente, emailcliente, fotocliente, idusr) "
					+ "values ('"+nomcliente+"', '"+emailcliente+"', '"+fotocliente+"', "+idusr+") ";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			con.close();
		}
		catch (Exception e) 
		{
		}
	}
	
	public void updCliente()
	{
		try
		{
			objC = new Conexion();
			con = objC.getCon();
			
			String query = "update cliente set "
					+ "nomcliente = '"+nomcliente+"', "
					+ "emailcliente = '"+emailcliente+"', "
				    + "fotocliente = '"+fotocliente+"', "
				    + "idusr = "+idusr+" where idcliente = "+idcliente;
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			con.close();
		}
		catch (Exception e) 
		{
		}
	}
	
	public void delCliente()
	{
		try
		{
			objC = new Conexion();
			con = objC.getCon();
			
			String query = "delete from cliente where idcliente = "+idcliente+"";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			con.close();
		}
		catch (Exception e) 
		{
		}
	}
	
	public List<Clientes> listClientes()
	{
		List <Clientes> arrCtes = null;
		try
		{
			arrCtes = new ArrayList<>();
			Clientes objCte;
			objC = new Conexion();
			con = objC.getCon();
			
			String query = "select * from cliente order by idcliente";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			while (res.next()) 
			{
				objCte = new Clientes();
				objCte.idcliente = res.getInt("idcliente");
				objCte.nomcliente = res.getString("nomcliente");
				objCte.emailcliente = res.getString("emailcliente");
				objCte.fotocliente = res.getString("fotocliente");
				objCte.idusr = res.getInt("idusr");
				
				Usuarios objU = new Usuarios();
				objU.setIdusr(objCte.idusr);
				objU.viewUser();
				
				objCte.usr = objU;
				
				arrCtes.add(objCte);
			}
			con.close();
		}
		catch (Exception e) 
		{
		}
		return arrCtes;
	}
	
	public Clientes viewCliente()
	{
		try
		{
			objC = new Conexion();
			con = objC.getCon();
			
			String query = "select * from cliente where idcliente = "+idcliente+"";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			
			if (res.next())
			{
				this.idcliente = res.getInt("idcliente");
				this.nomcliente = res.getString("nomcliente");
				this.emailcliente = res.getString("emailcliente");
				this.fotocliente = res.getString("fotocliente");
				this.idusr = res.getInt("idusr");
				con.close();
			}
			return this;
			
		}
		catch (Exception e) 
		{
			this.nomcliente = e.toString();
			return this;
		}
		
	}
	
}
