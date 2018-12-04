package com.batch.ict.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.batch.ict.collection.NaverITNews;
import com.batch.ict.repository.NaverITNewsRepository;
import com.batch.ict.service.CrawlService;

@Service
public class CrawlServiceImpl implements CrawlService {

	@Value("${ex.target.url}")
	private String targetUrl;
	@Value("${ex.parent.selector}")
	private String pSelector;
	@Value("${ex.dt.selector}")
	private String dtSelector;

	@Autowired
	private NaverITNewsRepository nitnRepo;
	
	@Override
	public List<NaverITNews> getNaverITList() throws IOException {
		Document doc = Jsoup.connect(targetUrl).get();
		Elements ulElements = doc.select(pSelector);
		Elements aElements = ulElements.select(dtSelector);
		List<NaverITNews> nitnList = new ArrayList<NaverITNews>();
		for (Element aElement : aElements) {
			String uri = aElement.attr("href");

			String title = aElement.text();
			NaverITNews nitn = new NaverITNews();

			nitn.setUri(uri);
			nitn.setTitle(title);
			nitnList.add(nitn);
		}
		return nitnRepo.saveAll(nitnList);
	}

}
