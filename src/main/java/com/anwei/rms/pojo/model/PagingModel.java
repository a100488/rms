package com.anwei.rms.pojo.model;

import java.util.ArrayList;
import java.util.List;

public class PagingModel<T> {

    private int draw = 0;

    private long recordsTotal = 0;

    private long recordsFiltered = 0;

    private List<T> data = new ArrayList<T>();

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void setCondition(PagingCondition<?> condition){

        this.setDraw(condition.getDraw());
        this.setRecordsFiltered(condition.getCount());
        this.setRecordsTotal(condition.getCount());
    }
}
