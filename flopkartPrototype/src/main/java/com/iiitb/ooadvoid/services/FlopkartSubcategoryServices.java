package com.iiitb.ooadvoid.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.iiitb.ooadvoid.pojo.FlopkartSubcategory;
import com.iiitb.ooadvoid.dao.FlopkartSubcategoryDAO;

@Path("/subcategories")
public class FlopkartSubcategoryServices 
{

	@GET
	@Produces("application/json")
	public List<FlopkartSubcategory> getFlopkartSubcategories()
	{
		FlopkartSubcategoryDAO dao = new FlopkartSubcategoryDAO();
		List<FlopkartSubcategory> subcategory = dao.getFlopkartSubcategories();
		return subcategory;
	}

	
	@POST
	@Path("/create")
	@Consumes("application/json")
	public Response addFlopkartSubcategory(FlopkartSubcategory subcategory)
	{
		subcategory.setCategoryId(subcategory.getCategoryId());
		subcategory.setSubcategoryName(subcategory.getSubcategoryName());
		FlopkartSubcategoryDAO dao = new FlopkartSubcategoryDAO();
		dao.addFlopkartSubcategory(subcategory);

		return Response.ok().build();
	}

	@PUT
	@Path("/update/{id}")
	@Consumes("application/json")
	public Response updateFlopkartSubcatergory(@PathParam("id") int id, FlopkartSubcategory subcategory)
	{
		FlopkartSubcategoryDAO dao = new FlopkartSubcategoryDAO();
		int count = dao.updateFlopkartSubcategory(id, subcategory);
		if (count == 0)
		{
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}

	@DELETE
	@Path("/delete/{id}")
	@Consumes("application/json")
	public Response deleteFlopkartSubcategory(@PathParam("id") int id)
	{
		FlopkartSubcategoryDAO dao = new FlopkartSubcategoryDAO();
		int count = dao.deleteFlopkartSubcategory(id);
		if (count == 0)
		{
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}
	
//	@POST
//	@Path("/categoryId")
//	@Consumes("application/json")
//	@Produces("application/json")
//	public List<FlopkartSubcategory> getFlopkart_bySubcategoryId(FlopkartSubcategory subcategory)
//	{
//		FlopkartSubcategoryDAO dao = new FlopkartSubcategoryDAO();
//		List<FlopkartSubcategory> subcategory_details = dao.getFlopkartSubcategoryBycategoryId(subcategory);
//		if(subcategory_details==null)
//			return null;
//		else
//			return subcategory_details;
//	}	

	
	@GET
	@Path("/category/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public List<FlopkartSubcategory> getFlopkartbyCategoryId(@PathParam("id") int id)
	{
		FlopkartSubcategoryDAO dao = new FlopkartSubcategoryDAO();
		List<FlopkartSubcategory> subcategory_details = dao.getFlopkartSubcategoryBycategoryId(id);
		if(subcategory_details==null)
			return null;
		else
			return subcategory_details;
	}
}
