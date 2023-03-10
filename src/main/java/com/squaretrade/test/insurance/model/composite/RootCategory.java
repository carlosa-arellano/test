package com.squaretrade.test.insurance.model.composite;

import com.squaretrade.test.insurance.model.DataDto;

import java.util.ArrayList;
import java.util.List;

public class RootCategory implements Category{
    public RootCategory(String name, List<String> keywords) {
        this.name = name;
        this.keywords = keywords;
    }
    public RootCategory(String name, List<String> keywords,boolean isRoot) {
        this.name = name;
        this.keywords = keywords;
        this.isRoot=isRoot;
        if(this.isRoot){
            this.level=1;
        }
    }


    private String name;
    private List<String> keywords;

    private Integer level;

    private boolean isRoot =false;

    private final List<Category> categories = new ArrayList<>();

    public void add(Category category) {
        categories.add(category);
    }
    @Override
    public void fillLevel(int l) {
        level=l;
        for (Category category : categories) {
            category.fillLevel(level+1);
        }
    }

    public DataDto finkKeywordsAndLevel(String categoryName) {
        if (name.equals(categoryName)) {
            if(this.keywords.isEmpty()){

            }
            return new DataDto(this.name,this.keywords, this.level);
        }
        for (Category category : categories) {
            DataDto data=category.finkKeywordsAndLevel(categoryName);
            if(data!=null)
                return data;
        }
        return null;
    }

    @Override
    public Integer getLevel() {
        return this.level;
    }
}
