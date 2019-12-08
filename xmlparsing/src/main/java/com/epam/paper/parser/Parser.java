package com.epam.paper.parser;

import com.epam.paper.entity.Paper;

import java.util.List;

public interface Parser {
    public List<Paper> parse(String pathToFile);

}
