package com.squaretrade.test.insurance.service.impl;

import com.squaretrade.test.insurance.model.DataDto;
import com.squaretrade.test.insurance.model.InsResponse;
import com.squaretrade.test.insurance.model.composite.ChildCategory;
import com.squaretrade.test.insurance.model.composite.RootCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceImplTest {
    @Spy
    private CategoryServiceImpl categoryService;

    @BeforeEach
    void init(){
        categoryService= Mockito.spy(new CategoryServiceImpl());
    }

    @Test
    void SuccesfullSearch(){
        InsResponse resp=categoryService.getLevelAndKwordsFromCategory("Forniture");
        assertNotNull(resp);
        
    }

    @Test
    void testData() {


        //level 2
        ChildCategory cat1 = new ChildCategory("Forniture", Arrays.asList("forniture", "fornit"));
        ChildCategory cat2 = new ChildCategory("Electronics", Arrays.asList("electronics"));
        RootCategory root1 = new RootCategory("Home Appliances", Arrays.asList("home appliances"));
        RootCategory root2 = new RootCategory("Major Appliances", Arrays.asList("major"));

        //level 3
        ChildCategory cat4 = new ChildCategory("Minor Appliances", Arrays.asList(""));
        ChildCategory cat5 = new ChildCategory("Lawn & Garden", Arrays.asList(""));

        //level 4
        ChildCategory cat6 = new ChildCategory("Kitchen Appliances", Arrays.asList(""));

        //level 1
        RootCategory root0 = new RootCategory("Base", Arrays.asList(""));
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

        DataDto data =root0.finkKeywordsAndLevel("Minor Appliances");

        assertNotNull(data);

    }

}