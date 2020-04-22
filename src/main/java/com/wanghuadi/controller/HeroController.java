package com.wanghuadi.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanghuadi.beans.Camp;
import com.wanghuadi.beans.Hero;
import com.wanghuadi.service.HeroService;
import com.wanghuadi.utils.FileUtils;

@Controller
public class HeroController {
	
	@Resource
	private HeroService heroService;

	
	@RequestMapping("queryAll")
	public String list(@RequestParam(defaultValue="1")Integer pageNum,Model model,Integer cid,Integer isHave,Double startPrice,Double endPrice){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cid", cid);
		map.put("isHave", isHave);
		map.put("startPrice", startPrice);
		map.put("endPrice", endPrice);
		
		//分页工具类PageHelper
		PageHelper.startPage(pageNum,3);
		List<Hero> list = heroService.queryAll(map);	
		PageInfo<Hero> page = new PageInfo<>(list);
		model.addAttribute("page", page);
		
		//查询所有的英雄阵营
		List<Camp> campList = heroService.queryCamp();
		model.addAttribute("campList", campList);
		
		
		//模糊区间回显
		model.addAttribute("map", map);
		
		return "list";
	}
	
	@RequestMapping("queryCamp")
	@ResponseBody
	public List<Camp> queryCamp(){
		//查询所有的英雄阵营
		List<Camp> campList = heroService.queryCamp();
		return campList;
	}
	
	
	@RequestMapping("add")
	public String add(Hero hero,MultipartFile file) throws IllegalStateException, IOException{
		
		try {
			//上传 返回图片路径
			String upload = FileUtils.upload(file);
			
			hero.setPicurl(upload);
			
			heroService.addHero(hero);
			return "redirect:queryAll";
		} catch (Exception e) {
			return "add";
		}
		
	}
	
	
	@RequestMapping("lookImg")
	public void lookImg(String path,HttpServletRequest request,HttpServletResponse response){
		FileUtils.lookImg(path, request, response);
	}
	
	
	@RequestMapping("queryHeroById")
	public String queryHeroById(Integer id,Model model){
		Hero hero = heroService.queryHeroById(id);
		model.addAttribute("hero", hero);
		return "show";
	}
	
	@RequestMapping("updateIsHave")
	@ResponseBody
	public boolean updateIsHave(Integer id){
		
		try {
			heroService.updateIsHave(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
}
