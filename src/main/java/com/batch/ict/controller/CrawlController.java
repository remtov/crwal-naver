package com.batch.ict.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.batch.ict.collection.NaverITNews;
import com.batch.ict.service.CrawlService;
/*import lombok.extern.slf4j.Slf4j;*/

@EnableScheduling
@Controller
/*@Slf4j*/
public class CrawlController {
	@Autowired
	private CrawlService cs;
	@PostMapping(value="/execute")
	@ResponseBody
	public List<NaverITNews> postMethodName(@RequestParam Map<String,String> auth) throws Exception {	
		if(!"test".equals(auth.get("id"))) {
			throw new Exception("권한없음");
		}
		if(!"test".equals(auth.get("pwd"))) {
			throw new Exception("권한없음");
		}
		return cs.getNaverITList();
	}

	@GetMapping(value="/crawl")
	@ResponseBody
	public List<NaverITNews> getMethodName(@RequestParam Map<String,String> auth) throws Exception {	
		return cs.getNaverITList();
	}
}
