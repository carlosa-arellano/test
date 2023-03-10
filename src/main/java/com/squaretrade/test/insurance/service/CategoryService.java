package com.squaretrade.test.insurance.service;

import com.squaretrade.test.insurance.model.InsResponse;

public interface CategoryService {
    InsResponse getLevelAndKwordsFromCategory(String category);
}
