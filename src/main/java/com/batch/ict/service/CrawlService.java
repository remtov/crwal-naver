package com.batch.ict.service;

import java.io.IOException;
import java.util.List;

import com.batch.ict.collection.NaverITNews;

public interface CrawlService {

	public List<NaverITNews> getNaverITList()throws IOException ;
}
