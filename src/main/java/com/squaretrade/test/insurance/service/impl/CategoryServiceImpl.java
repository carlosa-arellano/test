package com.squaretrade.test.insurance.service.impl;

import com.squaretrade.test.insurance.model.DataDto;
import com.squaretrade.test.insurance.model.InsResponse;
import com.squaretrade.test.insurance.model.composite.ChildCategory;
import com.squaretrade.test.insurance.model.composite.RootCategory;
import com.squaretrade.test.insurance.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    //Method to obtain category level and keywords
    @Override
    public InsResponse getLevelAndKwordsFromCategory(String category) {
        InsResponse response = new InsResponse();
        RootCategory categories = getData();
        DataDto data = categories.finkKeywordsAndLevel(category);
        response.setData(data);
        return response;
    }


    //This point 1
    //Method to generate Data
    private RootCategory getData() {
        ChildCategory cat1 = new ChildCategory("Forniture", Arrays.asList("forniture", "fornit"));
        ChildCategory cat2 = new ChildCategory("Electronics", Arrays.asList("electronics"));
        RootCategory root1 = new RootCategory("Home Appliances", Arrays.asList("home appliances"));
        RootCategory root2 = new RootCategory("Major Appliances", Arrays.asList());

        //level 3
        ChildCategory cat4 = new ChildCategory("Minor Appliances", Arrays.asList(""));
        ChildCategory cat5 = new ChildCategory("Lawn & Garden", Arrays.asList(""));

        //level 4
        ChildCategory cat6 = new ChildCategory("Kitchen Appliances", Arrays.asList(""));

        //level 1
        RootCategory root0 = new RootCategory("Base", Arrays.asList("root category"));
        //level 2

        root1.add(root2);
        root1.add(cat4);
        root1.add(cat5);
        root2.add(cat6);

        //add level 2
        root0.add(cat1);
        root0.add(cat2);
        root0.add(root1);

        root0.fillLevel(1);
        return root0;
    }
}
