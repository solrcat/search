package cn.Solarcat.test;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSolrJ {
	@Autowired
	SolrClient solrClient;

	@Test
	public void addDocument() throws SolrServerException, IOException {
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "doc01");
		document.addField("item_title", "测试商品01");
		document.addField("item_price", 1000);
		solrClient.add(document);
		solrClient.commit();
	}

	@Test
	public void deleteDocument() throws SolrServerException, IOException {
		solrClient.deleteById("doc01");
		solrClient.commit();
	}
//	@Test
//	public void quertIndex() throws SolrServerException {
//		final SolrServer solrServer = new HttpSolrServer("http://139.199.201.162:8100/solr/collection1");
//		final SolrQuery solrQuery = new SolrQuery();
//		solrQuery.setQuery("*:*");
//		solrQuery.set("q", "*:*");
//		final QueryResponse queryResponse = solrServer.query(solrQuery);
//		final SolrDocumentList solrDocumentList = queryResponse.getResults();
//		System.out.println("查询结果总记录数：" + solrDocumentList.getNumFound());
//		for (final SolrDocument solrDocument : solrDocumentList) {
//			System.out.println(solrDocument.get("id"));
//			System.out.println(solrDocument.get("item_title"));
//			System.out.println(solrDocument.get("item_sell_point"));
//			System.out.println(solrDocument.get("item_price"));
//			System.out.println(solrDocument.get("item_image"));
//			System.out.println(solrDocument.get("item_category_name"));
//		}
//	}
//
//	@Test
//	public void queryIndexFuza() throws SolrServerException {
//		final SolrServer solrServer = new HttpSolrServer("http://139.199.201.162:8100/solr/collection1");
//		final SolrQuery solrQuery = new SolrQuery();
//		solrQuery.setQuery("手机");
//		solrQuery.setStart(0);
//		solrQuery.setRows(20);
//		solrQuery.set("df", "item_title");
//		solrQuery.setHighlight(true);
//		solrQuery.addHighlightField("item_title");
//		solrQuery.setHighlightSimplePre("<em>");
//		solrQuery.setHighlightSimplePost("</em>");
//		final QueryResponse queryResponse = solrServer.query(solrQuery);
//		final SolrDocumentList solrDocumentList = queryResponse.getResults();
//		System.out.println("查询结果总记录数：" + solrDocumentList.getNumFound());
//		for (final SolrDocument solrDocument : solrDocumentList) {
//			System.out.println(solrDocument.get("id"));
//			final Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
//			final List<String> list = highlighting.get(solrDocument.get("id")).get("item_title");
//			String title = "";
//			if (list != null && list.size() > 0) {
//				title = list.get(0);
//			} else {
//				title = (String) solrDocument.get("item_title");
//			}
//			System.out.println(title);
//			System.out.println(solrDocument.get("item_sell_point"));
//			System.out.println(solrDocument.get("item_price"));
//			System.out.println(solrDocument.get("item_image"));
//			System.out.println(solrDocument.get("item_category_name"));
//		}

//	}

}
