package com.squaretrade.test.insurance.model.composite;

import com.squaretrade.test.insurance.model.DataDto;

import java.util.List;

public class ChildCategory implements Category {

    private String name;
    private List<String> keywords;
    private Integer level;

    public ChildCategory(String name, List<String> keywords) {
        this.name = name;
        this.keywords = keywords;
    }

    @Override
    public void fillLevel(int l) {
        level = l;
    }

    public DataDto finkKeywordsAndLevel(String nameToFind) {
        if (name.equals(nameToFind)) {
            return new DataDto(this.name, this.keywords, this.level);
        }
        return null;
    }

    @Override
    public Integer getLevel() {
        return this.level;
    }
}
