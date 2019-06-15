package c24.boot.core.dao;

import java.util.List;

import c24.boot.core.po.BaseDict;

public interface BaseDictDao {
	public List<BaseDict> selectBaseDictByTypeCode(String typecode);
}
