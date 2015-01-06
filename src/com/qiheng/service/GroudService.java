package com.qiheng.service;

import java.util.List;

import com.qiheng.bean.Groud;
import com.qiheng.bean.Plate;


public interface GroudService {

	Groud findGroud(int groudId);

	public List<Plate> findAllPlate();

	
}
