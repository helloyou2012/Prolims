/**
 * 
 */
package com.helloyou.dao.impl;

import org.springframework.stereotype.Repository;
import com.helloyou.dao.PoDao;
import com.helloyou.model.Po;

@Repository("PoDao")
public class PoDaoImpl extends DaoImpl<Po> implements PoDao{

	@Override
	protected Class<Po> getType() {
		// TODO Auto-generated method stub
		return Po.class;
	}

	@Override
	public Po getById(Long id) {
		// TODO Auto-generated method stub
		return this.get(id);
	}

}
