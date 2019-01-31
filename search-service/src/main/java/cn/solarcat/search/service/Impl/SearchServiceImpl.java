package cn.solarcat.search.service.Impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

import cn.solarcat.aop.Log;
import cn.solarcat.common.pojo.ACTION;
import cn.solarcat.common.pojo.LEVEL;
import cn.solarcat.common.pojo.SearchResult;
import cn.solarcat.search.dao.SearchDao;
import cn.solarcat.search.service.SearchService;

@Service
@Component
public class SearchServiceImpl implements SearchService {
	@Autowired
	private SearchDao searchDao;

	@Override
	@Log(action = ACTION.SELECT, level = LEVEL.SERVICE)
	public SearchResult search(String keyword, int page, int rows) throws Exception {
		SolrQuery query = new SolrQuery();
		query.setQuery(keyword);
		if (page <= 0)
			page = 1;
		query.setStart((page - 1) * rows);
		query.setRows(rows);
		query.set("df", "item_title");
		query.setHighlight(true);
		query.addHighlightField("item_title");
		query.setHighlightSimplePre("<em style=\"color:red\">");
		query.setHighlightSimplePost("</em>");
		SearchResult searchResult = searchDao.search(query);
		long recordCount = searchResult.getRecordCount();
		int totalPage = (int) (recordCount / rows);
		if (recordCount % rows > 0)
			totalPage++;
		searchResult.setTotalPages(totalPage);
		return searchResult;
	}

}
