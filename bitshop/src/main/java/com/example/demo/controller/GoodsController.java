package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.GoodsDao;
import com.example.demo.vo.GoodsVo;
import com.google.gson.Gson;

@RestController
public class GoodsController {

	@Autowired
	public GoodsDao dao;

	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value = "/listAll", produces = "application/json;charset=UTF-8")
	public String listAll() {
		String str = "";
		List<GoodsVo> list = dao.listAll();
		Gson gson = new Gson();
		str = gson.toJson(list);
		return str;
	}
	
	@RequestMapping("/insert")
	public String insert(GoodsVo g) {
		System.out.println("컨트롤동작");
		String str = "ok";
		dao.insert(g);
		return str;
	}
	
	@RequestMapping("/update")
	public String update(GoodsVo g) {
		String str = "ok";
		dao.update(g);
		return str;
	}
	
	@RequestMapping("/delete")
	public String delete(GoodsVo g) {
		String str = "ok";
		dao.delete(g);
		return str;
	}
}
