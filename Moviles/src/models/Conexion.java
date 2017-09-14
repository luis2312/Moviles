package models;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion 
{
	private String cadconexion = "jdbc:postgresql://localhost:5432/vuelos";
	private String user = "postgres";
	private String pass = "root";
	private String driver = "org.postgresql.Driver";
	
	private Connection con;
	
	public Conexion()
	{
		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(cadconexion, user, pass);
		}
		catch (Exception e) {
			e.toString();
		}
	}
	public Connection getCon()
	{
		return con;
	}
}
