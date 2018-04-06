package com.iiitb.ooadvoid.pojo;

public class FlopkartReview {
	private Integer id;
	private Integer listingId;
	private Integer userId;
	private Integer sellerId;
	private Integer stars;
	private String review;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getListingId() {
		return listingId;
	}

	public void setListingId(Integer listingId) {
		this.listingId = listingId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	
	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}
	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

}