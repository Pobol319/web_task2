package com.epam.paper.parser.sax;

import com.epam.paper.entity.Paper;
import com.epam.paper.exceptions.XmlParserException;
import com.epam.paper.parser.Parser;

import java.util.List;

public class SaxParser implements Parser {
    public List<Paper> parse(String pathToXml) throws XmlParserException {
        PapersSaxBuilder papersSAXBuilder = new PapersSaxBuilder();
        papersSAXBuilder.buildSetPapers(pathToXml);
        return papersSAXBuilder.getPapers();
    }
}
