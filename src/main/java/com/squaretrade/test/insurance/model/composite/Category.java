package com.squaretrade.test.insurance.model.composite;

import com.squaretrade.test.insurance.model.DataDto;

///implements composite pattern
public interface Category {
//Method for fill categories level

    void fillLevel(int Level);

    //Look for level and keywords from category
    DataDto finkKeywordsAndLevel(String categoryName);

    Integer getLevel();

}
