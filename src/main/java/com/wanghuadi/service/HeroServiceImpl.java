package com.wanghuadi.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wanghuadi.beans.Camp;
import com.wanghuadi.beans.Hero;
import com.wanghuadi.mapper.HeroMapper;

@Service
public class HeroServiceImpl implements HeroService {
	
	@Resource
	private HeroMapper heroMapper;

	@Override
	public List<Hero> queryAll(Map<String, Object> map) {
		return heroMapper.queryAll(map);
	}

	@Override
	public List<Camp> queryCamp() {
		return heroMapper.queryCamp();
	}

	@Override
	public void addHero(Hero hero) {
		heroMapper.addHero(hero);
	}

	@Override
	public Hero queryHeroById(Integer id) {
		return heroMapper.queryHeroById(id);
	}

	@Override
	public void updateIsHave(Integer id) {
		heroMapper.updateIsHave(id);
	}

}
