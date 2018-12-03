package com.batch.ict.collection;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("naverit4")
public class NaverITNews {
	private String uri;
	private String title;
/*document 가 collection 즉 table 밑에 2가지가 colums*/
}
