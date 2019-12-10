package com.epam.paper.parser;

import com.epam.paper.entity.Paper;
import com.epam.paper.exceptions.XmlParserException;

import java.util.List;

public interface Parser {
    public List<Paper> parse(String pathToFile) throws XmlParserException;

}
