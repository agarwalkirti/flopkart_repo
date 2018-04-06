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
import com.iiitb.ooadvoid.pojo.FlopkartReview;
import com.iiitb.ooadvoid.pojo.FlopkartUser;
import com.iiitb.ooadvoid.dao.FlopkartListingDAO;
import com.iiitb.ooadvoid.dao.FlopkartReviewDAO;
import com.iiitb.ooadvoid.dao.FlopkartUserDAO;

@Path("/reviews")
public class FlopkartReviewServices 
{

	@GET
	@Produces("application/json")
	public List<FlopkartReview> getFlopkartReview()
	{
		FlopkartReviewDAO dao = new FlopkartReviewDAO();
		List<FlopkartReview> reviews = dao.getFlopkartReview();
		return reviews;
	}

	
	@POST
	@Path("/create")
	@Consumes("application/json")
	public Response addFlopkartReview(FlopkartReview review)
	{
		review.setListingId(review.getListingId());
		review.setUserId(review.getUserId());
		review.setStars(review.getStars());
		review.setReview(review.getReview());
		review.setSellerId(review.getSellerId());
		FlopkartReviewDAO dao = new FlopkartReviewDAO();
		dao.addFlopkartReview(review);

		return Response.ok().build();
	}
	@PUT
	@Path("/update/{id}")
	@Consumes("application/json")
	public Response updateFlopkartReview(@PathParam("id") int id, FlopkartReview review)
	{
		FlopkartReviewDAO dao = new FlopkartReviewDAO();
		int count = dao.updateFlopkartReview(id, review);
		if (count == 0)
		{
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}
	@GET
	@Path("/listing/{id}")
	@Produces("application/json")
	public List<FlopkartReview> getFlopkartReviewByListingId(@PathParam("id") int id)
	{
		FlopkartReviewDAO dao = new FlopkartReviewDAO();
		List<FlopkartReview> reviews = dao.getFlopkartReviewByListingId(id);
		return reviews;
	}
	
	@GET
	@Path("/seller/{id}")
	@Produces("application/json")
	public List<FlopkartReview> getFlopkartReviewBySellerId(@PathParam("id") int id)
	{
		FlopkartReviewDAO dao = new FlopkartReviewDAO();
		List<FlopkartReview> reviews = dao.getFlopkartReviewBySellerId(id);
		return reviews;
	}
	@GET
	@Path("/user/{id}")
	@Produces("application/json")
	public List<FlopkartReview> getFlopkartReviewByUserId(@PathParam("id") int id)
	{
		FlopkartReviewDAO dao = new FlopkartReviewDAO();
		List<FlopkartReview> reviews = dao.getFlopkartReviewByUserId(id);
		return reviews;
	}
}