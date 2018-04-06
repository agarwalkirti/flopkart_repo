
package com.iiitb.ooadvoid.dao;

import java.util.ArrayList;
import java.util.List;

import com.iiitb.ooadvoid.pojo.FlopkartListing;
import com.iiitb.ooadvoid.pojo.FlopkartSubcategory;

public class FlopkartListingDAO extends HibernateDAO<FlopkartListing>
{
	String entity_name = "FlopkartListing";
	
	public FlopkartListing addFlopkartListing(FlopkartListing item)
	{
		super.add(item);
		item = super.find(entity_name , "listingName" , item.getListingName());
		return item;
	}
	
	
	public List<FlopkartListing> getFlopkartListings()
	{
		return super.list(new FlopkartListing());
	}
	
	
	public List<FlopkartListing> getFlopkartListingsSortedByDate(int n)
	{
		return super.listSorted(new FlopkartListing(),"manufacture_Date",n);
	}
	

	public FlopkartListing getFlopkartListingById(int id)
	{
		return super.find(new FlopkartListing(),id);
	}

	public FlopkartListing getFlopkartListingByItemId(String id) {
		return super.find(entity_name,"itemId",id);
	}
	
  /*  public List<FlopkartListing> getFlopkartListingByCategoty(FlopkartListing item)
	{
		return super.findAll(entity_name,"category", item.getSubcategoryId());
	}
  */
	
	 public List<FlopkartListing> getFlopkartListingBysubcategoryId(Integer id)
	{
		return super.findAll(entity_name,"subcategoryId", id);
	}
	
	public List<FlopkartListing> getFlopkartListingBycategoryId(Integer id)
	{
		 List<FlopkartListing> items = null;
		 List<FlopkartListing> all_items = new ArrayList<FlopkartListing>();
		 List<FlopkartSubcategory> subcategories = new FlopkartSubcategoryDAO().getFlopkartSubcategoryBycategoryId(id);
		 for(FlopkartSubcategory subcategory : subcategories)
		 {
			 items = super.findAll(entity_name,"subcategoryId", subcategory.getId());
			 all_items.addAll(items);
		 }
		return all_items;
	}
	 
	 public List<FlopkartListing> getFlopkartListingBysellerId(Integer id)
	{
		return super.findAll(entity_name,"sellerid", id);
	}
	 
	public int deleteFlopkartListing(int id)
	{
		return super.remove(entity_name,id);
	}

	public int updateFlopkart_Item(int id, FlopkartListing item)
	{
		if (id <= 0)
			return 0;	
		super.update(item,id);
		return 1;
	}
}
