package com.qiheng.DAO;

import java.util.List;

import com.qiheng.bean.Groud;
import com.qiheng.bean.Plate;


public interface GroudDAO {

	Groud findGroudNameAndPlateName(int groudId);

	List<Plate> findAllPlate();

	
	
}
