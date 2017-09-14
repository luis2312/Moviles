package controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import models.Clientes;

@Path("/clientes")
public class WSClientes 
{
	@POST
	@Path("/inscte")
	@Consumes(MediaType.APPLICATION_JSON)
	public void insCliente(Clientes objC)
	{
		objC.insCliente();
	}
	
	@PUT
	@Path("/updcte")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updCliente(Clientes objC)
	{
		objC.updCliente();
	}
	
	@DELETE
	@Path("/delcte/{idcte}")
	public void delCliente(@PathParam("idcte") int idCte)
	{
		Clientes objC = new Clientes();
		objC.setIdcliente(idCte);
		objC.delCliente();
	}
	
	
	@GET
	@Path("/listctes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Clientes> listClientes()
	{
		Clientes objC = new Clientes();
		return objC.listClientes();
	}
	
	
	@GET
	@Path("/viewcte/{idcte}")
	@Produces(MediaType.APPLICATION_JSON)
	public Clientes viewCliente(@PathParam("idcte") int idCte)
	{
		Clientes objC = new Clientes();
		objC.setIdcliente(idCte);
		return objC.viewCliente();
	}

}
