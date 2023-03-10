package com.squaretrade.test.insurance.controller;

import com.squaretrade.test.insurance.model.InsResponse;
import com.squaretrade.test.insurance.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }

    //Operation that returns an object with level and keywords of a category
    @GetMapping(value={"/getLevelKeyWords/{categoryName}"},produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<InsResponse> getLevelAndKwordsFromCategory(@PathVariable String categoryName){
        try {
            InsResponse response = categoryService.getLevelAndKwordsFromCategory(categoryName);
            if(response.getData()==null){
                return new ResponseEntity<>(new InsResponse<>(null,"Category not found"), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new InsResponse<>(e.getMessage(),"ERROR"), HttpStatus.OK);
        }
    }

}
