package com.squaretrade.test.insurance.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DataDto {
    String category;
    List<String> keywords;
    Integer level;
}
