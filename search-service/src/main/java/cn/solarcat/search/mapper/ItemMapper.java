package cn.solarcat.search.mapper;

import java.util.List;

import cn.solarcat.common.pojo.SearchItem;

public interface ItemMapper {
	List<SearchItem> getItemList();

	SearchItem getItemById(long itemId);
}