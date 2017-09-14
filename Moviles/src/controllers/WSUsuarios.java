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

import models.Usuarios;

@Path("/usuarios")
public class WSUsuarios 
{
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Usuarios loginUser(Usuarios objU)
	{
		objU.validaUsuario();
		return objU;
	}
	
	@POST
	@Path("/insusr")
	@Consumes(MediaType.APPLICATION_JSON)
	public void insUsuario(Usuarios objU)
	{
		objU.insUsuario();
	}
	
	@PUT
	@Path("/updusr")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updUsuario(Usuarios objU)
	{
		objU.updUsuario();
	}
	
	@DELETE
	@Path("/delusr/{idusr}")
	public void delUsuario(@PathParam("idusr") int idUsr)
	{
		Usuarios objU = new Usuarios();
		objU.setIdusr(idUsr);
		objU.delUsuario();
	}
	
	
	@GET
	@Path("/listusr")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuarios> listUsuarios()
	{
		Usuarios objU = new Usuarios();
		return objU.listUsuarios();
	}
	
	
	@GET
	@Path("/viewusr/{idusr}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuarios viewUsuario(@PathParam("idusr") int idUsr)
	{
		Usuarios objU = new Usuarios();
		objU.setIdusr(idUsr);
		return objU.viewUsuario();
	}
	

}
