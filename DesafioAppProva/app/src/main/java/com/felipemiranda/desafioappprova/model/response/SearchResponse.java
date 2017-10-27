package com.felipemiranda.desafioappprova.model.response;

import com.felipemiranda.desafioappprova.model.Item;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by felipemiranda on 26/10/17.
 */

public class SearchResponse implements Serializable {

    private Integer totalCount;
    private Boolean incompleteResults;
    private ArrayList<Item> items;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    public void setIncompleteResults(Boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
