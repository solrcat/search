package cn.solarcat.search.service;

import cn.solarcat.common.pojo.SearchResult;

public interface SearchService {
	SearchResult search(String keyword,int page,int rows) throws Exception;
}
