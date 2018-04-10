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

import com.iiitb.ooadvoid.pojo.FlopkartCart;
import com.iiitb.ooadvoid.dao.FlopkartCartDAO;

@Path("/cart")
public class FlopkartCartServices 
{

	@GET
	@Produces("application/json")
	public List<FlopkartCart> getFlopkartCartItems()
	{
		FlopkartCartDAO dao = new FlopkartCartDAO();
		List<FlopkartCart> cart = dao.getFlopkartCartItems();
		return cart;
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public FlopkartCart getFlopkartCartItemById(@PathParam("id") int id)
	{
		FlopkartCartDAO dao = new FlopkartCartDAO();
		FlopkartCart cart = dao.getFlopkartCartItemById(id);
		return cart;
	}
	
	@GET
	@Path("/user/{id}")
	@Produces("application/json")
	public List<FlopkartCart> getFlopkartCartItemsByUserId(@PathParam("id") int id)
	{
		FlopkartCartDAO dao = new FlopkartCartDAO();
		List<FlopkartCart> cartItems = dao.getFlopkartCartItemByUserId(id);
		return cartItems;
	}
	
	@POST
	@Path("/user/listingid/{id}")
	@Produces("application/json")
	public FlopkartCart getFlopkartCartItemsByItemId(@PathParam("id") int id,FlopkartCart cart)
	{
		FlopkartCartDAO dao = new FlopkartCartDAO();
		FlopkartCart cartItem = dao.getFlopkartCartItemByUserListingId(id,cart);
		return cartItem;
	}
	
	@POST
	@Path("/create")
	@Consumes("application/json")
	public Response addFlopkartCartItem(FlopkartCart cart)
	{
		FlopkartCartDAO dao = new FlopkartCartDAO();
		dao.addFlopkartCartItem(cart);
		return Response.ok().build();
	}

	@PUT
	@Path("/update/{id}")
	@Consumes("application/json")
	public Response updateFlopkartCartItem(@PathParam("id") int id, FlopkartCart cart)
	{
		FlopkartCartDAO dao = new FlopkartCartDAO();
		int count = dao.updateFlopkartCartItem(id, cart);
		if (count == 0)
		{
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}

	@DELETE
	@Path("/delete/{id}")
	@Consumes("application/json")
	public Response deleteFlopkartCartItem(@PathParam("id") int id)
	{
		FlopkartCartDAO dao = new FlopkartCartDAO();
		int count = dao.deleteFlopkartCartItem(id);
		if (count == 0)
		{
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}
}
