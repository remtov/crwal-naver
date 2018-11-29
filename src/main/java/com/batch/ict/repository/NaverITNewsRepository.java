package com.batch.ict.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.batch.ict.collection.NaverITNews;

public interface NaverITNewsRepository extends MongoRepository<NaverITNews, String>{

	@Query("{aid:?0}")
	public List<NaverITNews> findByAId(String aid);
}
