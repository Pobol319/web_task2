package com.epam.parser;

import com.epam.entity.Paper;

import java.util.List;

public interface Parser {
    public List<Paper> parse(String pathToFile);

}
