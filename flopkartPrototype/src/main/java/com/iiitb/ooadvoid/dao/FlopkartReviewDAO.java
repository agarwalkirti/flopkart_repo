package com.iiitb.ooadvoid.dao;

import java.util.List;

import com.iiitb.ooadvoid.pojo.FlopkartReview;

public class FlopkartReviewDAO extends HibernateDAO<FlopkartReview>
{
	String entity_name = "FlopkartReview";
	
	public FlopkartReview addFlopkartReview(FlopkartReview review)
	{
		super.add(review);
		return review;
	}
	
	
	public List<FlopkartReview> getFlopkartReview()
	{
		return super.list(new FlopkartReview());
	}

	public FlopkartReview getFlopkartReviewById(int id)
	{
		return super.find(new FlopkartReview(),id);
	}

	public int deleteFlopkartReview(int id)
	{
		return super.remove(entity_name,id);
	}

	public int updateFlopkartReview(int id, FlopkartReview review)
	{
		if (id <= 0)
			return 0;	
		super.update(review,id);
		return 1;
	}
	
	public List<FlopkartReview> getFlopkartReviewByListingId(int id)
	{
		return super.findAll(entity_name,"listingId",id);
	}
	
	public List<FlopkartReview> getFlopkartReviewBySellerId(int id)
	{
		return super.findAll(entity_name,"sellerId",id);
	}
	public List<FlopkartReview> getFlopkartReviewByUserId(int id)
	{
		return super.findAll(entity_name,"userId",id);
	}
}