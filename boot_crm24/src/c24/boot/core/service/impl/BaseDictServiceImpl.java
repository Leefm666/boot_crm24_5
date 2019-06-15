package c24.boot.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c24.boot.core.dao.BaseDictDao;
import c24.boot.core.po.BaseDict;
import c24.boot.core.service.BaseDictService;


@Service("baseDictSerive")
public class BaseDictServiceImpl implements BaseDictService {
	@Autowired
	private BaseDictDao baseDictDao;
	
	
	public List<BaseDict> findBaseDictByTypeCode(String typecode) {
		// TODO Auto-generated method stub
		return baseDictDao.selectBaseDictByTypeCode(typecode);
	}

}
