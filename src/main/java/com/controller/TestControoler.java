package com.controller;

import com.dao.entity.MscUser;
import com.dao.entity.MscUserExample;
import com.dao.mapper.MscUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
*  测试
 *  @author htian
* */
@RestController
public class TestControoler {
	
	@Autowired
	private MscUserMapper mscUserMapper;

	@RequestMapping(value ="/test001")
	public List<MscUser> test001(){
		List<MscUser> list = mscUserMapper.selectByExample(new MscUserExample());
		return list;
	}
	
}
