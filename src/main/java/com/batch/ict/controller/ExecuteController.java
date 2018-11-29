package com.batch.ict.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.batch.ict.collection.NaverITNews;
import com.batch.ict.service.CrawlService;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class ExecuteController {
	
	@Autowired
	private CrawlService cs;
	
	@PostMapping(value="/execute")
	@ResponseBody
	public List<NaverITNews> postMethodName(@RequestParam Map<String,String> auth) throws Exception {	
		if(!"test".equals(auth.get("id"))) {
			throw new Exception("권한없어 이녀석아.");
		}
		if(!"test".equals(auth.get("pwd"))) {
			throw new Exception("권한없어 이녀석아.");
		}
		return cs.getNaverITList();
	}
	
}
