package c24.boot.core.service;

import java.util.List;

import c24.boot.core.po.BaseDict;

public interface BaseDictService {
	public List<BaseDict> findBaseDictByTypeCode(String typecode);
	
}
