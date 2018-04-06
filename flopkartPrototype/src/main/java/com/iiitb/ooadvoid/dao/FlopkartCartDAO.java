package com.iiitb.ooadvoid.dao;

import java.util.List;
import com.iiitb.ooadvoid.pojo.FlopkartCart;

public class FlopkartCartDAO extends HibernateDAO<FlopkartCart>
{
	String entity_name = "FlopkartCart";
	
	public FlopkartCart addFlopkartCartItem(FlopkartCart cart)
	{
		super.add(cart);
		return cart;
	}
	
	public List<FlopkartCart> getFlopkartCartItems()
	{
		return super.list(new FlopkartCart());
	}

	public FlopkartCart getFlopkartCartItemById(int id)
	{
		return super.find(new FlopkartCart(),id);
	}
	
	public List<FlopkartCart> getFlopkartCartItemByUserId(int id){
		return super.findAll(entity_name,"userId",id);
	}

	public int deleteFlopkartCartItem(int id)
	{
		return super.remove(entity_name,id);
	}

	public int updateFlopkartCartItem(int id, FlopkartCart cart)
	{
		if (id <= 0)
			return 0;	
		super.update(cart,id);
		return 1;
	}
}
