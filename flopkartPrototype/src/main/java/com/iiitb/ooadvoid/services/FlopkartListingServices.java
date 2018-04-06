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

import com.iiitb.ooadvoid.pojo.FlopkartListing;
import com.iiitb.ooadvoid.dao.FlopkartListingDAO;

@Path("/listings")
public class FlopkartListingServices 
{

	@GET
	@Produces("application/json")
	public List<FlopkartListing> getFlopkartListing()
	{
		FlopkartListingDAO dao = new FlopkartListingDAO();
		List<FlopkartListing> listings = dao.getFlopkartListings();
		return listings;
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public FlopkartListing getFlopkartListingById(@PathParam("id") int id)
	{
		FlopkartListingDAO dao = new FlopkartListingDAO();
		FlopkartListing listing_details = dao.getFlopkartListingById(id);
		return listing_details;
	}
	
	@GET
	@Path("/item/{id}")
	@Produces("application/json")
	public FlopkartListing getFlopkartListingByItemId(@PathParam("id") String id)
	{
		FlopkartListingDAO dao = new FlopkartListingDAO();
		FlopkartListing listing_details = dao.getFlopkartListingByItemId(id);
		return listing_details;
	}
	
	@GET
	@Path("/date/{id}")
	@Produces("application/json")
	public List<FlopkartListing> getFlopkartListingByDate(@PathParam("id") int id)
	{
		FlopkartListingDAO dao = new FlopkartListingDAO();
		List<FlopkartListing> listing_details = dao.getFlopkartListingsSortedByDate(id);
		return listing_details;
	}
	
	
	@POST
	@Path("/create")
	@Consumes("application/json")
	@Produces("application/json")
	
	public FlopkartListing addFlopkartListing(FlopkartListing item)
	{		
			item.setListingName(item.getListingName());
			item.setImgUrl(item.getImgUrl());
			item.setSubcategoryId(item.getSubcategoryId());
			item.setQuantity(item.getQuantity());
			item.setPrice(item.getPrice());
			item.setSellerid(item.getSellerid());
	//		item.setDiscount(item.getDiscount());
			item.setColour(item.getColour());
			item.setBrand(item.getBrand());
			item.setManufacture_Date(item.getManufacture_Date());
			item.setDescription(item.getDescription());
		
			FlopkartListingDAO dao = new FlopkartListingDAO();
			FlopkartListing item_details = dao.addFlopkartListing(item);
		return item_details;
	}
	

	@PUT
	@Path("/update/{id}")
	@Consumes("application/json")
	public Response updateFlopkart_Item(@PathParam("id") int id, FlopkartListing listing)
	{
		FlopkartListingDAO dao = new FlopkartListingDAO();
		int count = dao.updateFlopkart_Item(id, listing);
		if (count == 0)
		{
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}

	@DELETE
	@Path("/delete/{id}")
	@Consumes("application/json")
	public Response deleteFlopkart_Item(@PathParam("id") int id)
	{
		FlopkartListingDAO dao = new FlopkartListingDAO();
		int count = dao.deleteFlopkartListing(id);
		if (count == 0)
		{
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}
	

	
	@GET
	@Path("/subcategory/{id}")
	@Produces("application/json")
	public List<FlopkartListing> getListingBySubCategoryId(@PathParam("id") int id)
	{
		FlopkartListingDAO dao = new FlopkartListingDAO();
		List<FlopkartListing> listing_details = dao.getFlopkartListingBysubcategoryId(id);
		if(listing_details==null)
			return null;
		else
			return listing_details;
	}
	

	
	@GET
	@Path("/category/{id}")
	@Produces("application/json")
	public List<FlopkartListing> getListingByCategoryId(@PathParam("id") int id)
	{
		FlopkartListingDAO dao = new FlopkartListingDAO();
		List<FlopkartListing> listing_details = dao.getFlopkartListingBycategoryId(id);
		if(listing_details==null)
			return null;
		else
			return listing_details;
	}
	
	@GET
	@Path("/seller/{id}")
	@Produces("application/json")
	public List<FlopkartListing> getListingBySellerId(@PathParam("id") int id)
	{
		FlopkartListingDAO dao = new FlopkartListingDAO();
		List<FlopkartListing> listing_details = dao.getFlopkartListingBysellerId(id);
		if(listing_details==null)
			return null;
		else
			return listing_details;
	}
	
}
