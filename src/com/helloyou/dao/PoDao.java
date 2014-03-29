package com.helloyou.dao;

import com.helloyou.model.Po;

public interface PoDao extends Dao<Po>{
	Po getById(Long id);
}
