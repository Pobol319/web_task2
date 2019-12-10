package com.epam.paper.parser.dom;

import com.epam.paper.entity.Paper;
import com.epam.paper.exceptions.XmlParserException;
import com.epam.paper.parser.Parser;

import java.util.List;

public class DomParser implements Parser {

    public List<Paper> parse(String pathToXml) throws XmlParserException {
        PapersDomBuilder papersDOMBuilder = new PapersDomBuilder();
        papersDOMBuilder.buildListPapers(pathToXml);
        return papersDOMBuilder.getPapers();
    }
}
