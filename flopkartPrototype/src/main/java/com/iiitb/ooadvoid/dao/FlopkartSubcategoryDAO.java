
package com.iiitb.ooadvoid.dao;

import java.util.List;

import com.iiitb.ooadvoid.pojo.FlopkartSubcategory;

public class FlopkartSubcategoryDAO extends HibernateDAO<FlopkartSubcategory>
{
	String entity_name = "FlopkartSubcategory";
	
	public FlopkartSubcategory addFlopkartSubcategory(FlopkartSubcategory subcategory)
	{
		super.add(subcategory);
		return subcategory;
	}
	
	
	public List<FlopkartSubcategory> getFlopkartSubcategories()
	{
		return super.list(new FlopkartSubcategory());
	}

	public FlopkartSubcategory getFlopkartSubcategoryById(int id)
	{
		return super.find(new FlopkartSubcategory(),id);
	}

	public int deleteFlopkartSubcategory(int id)
	{
		return super.remove(entity_name,id);
	}

	public int updateFlopkartSubcategory(int id, FlopkartSubcategory subcategory)
	{
		if (id <= 0)
			return 0;	
		super.update(subcategory,id);
		return 1;
	}
	
//	public List<FlopkartSubcategory> getFlopkartSubcategoryBysubcategoryId(FlopkartSubcategory subcategory)
//	{
//		int val =  subcategory.getCategoryId();
//		return super.findAll(entity_name,"categoryId",val);
//	}
	
	public List<FlopkartSubcategory> getFlopkartSubcategoryBycategoryId(Integer categoryid)
	{
		return super.findAll(entity_name,"categoryId",categoryid);
	}
}
