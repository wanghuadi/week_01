package com.wanghuadi.mapper;

import java.util.List;
import java.util.Map;

import com.wanghuadi.beans.Camp;
import com.wanghuadi.beans.Hero;

public interface HeroMapper {
	//列表
	public List<Hero> queryAll(Map<String,Object> map);

	public List<Camp> queryCamp();

	public void addHero(Hero hero);

	public Hero queryHeroById(Integer id);

	public void updateIsHave(Integer id);
	
}
