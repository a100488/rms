package com.anwei.rms.pojo.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.anwei.rms.util.EncodeUtils;
import com.anwei.rms.util.StringUtils;
import com.github.pagehelper.Page;

public class PagingCondition<T> {

    private int start = 0;
    private int length = 0;
    private int draw = 0;
    private long count=0;
    private String filter = null;
    private T searchObject;
    
    public PagingCondition(T searchObject)
    {
    	this.searchObject = searchObject;
    	this.start = 0;
    	this.length = Integer.MAX_VALUE;
    	this.draw = Integer.MAX_VALUE;
    	this.filter = null;
    }

    public PagingCondition(Map<String, String> params, T searchObject) {

        this.filter = EncodeUtils.convert(params.get("search[value]"), EncodeUtils.ISO88591, EncodeUtils.UTF8);
        this.start = Integer.parseInt(params.get("start"));
        this.length = Integer.parseInt(params.get("length"));
        this.draw = Integer.parseInt(params.get("draw"));
        this.searchObject = searchObject;
    }

    public RowBounds getRowBounds() {
        return new RowBounds(start, length);
    }

    public int getDraw(){
        return this.draw;
    }

    public long getCount() {
        return count;
    }

    public String getFilter() {
        return this.filter;
    }

    public T getSearchObject() {
        return this.searchObject;
    }

    public boolean hasFilter(){
        return StringUtils.isNotEmpty(this.filter);
    }

    public void total(List<?> list) {
        if (list instanceof Page) {
            this.count = ((Page<?>)(list)).getTotal();
        } else {
            this.count = list.size();
        }
    }
}
