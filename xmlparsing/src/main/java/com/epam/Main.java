package com.epam;

import com.epam.parser.dom.PapersDOMBuilder;
import com.epam.parser.sax.PapersSAXBuilder;

public class Main {
    public static void main(String[] args) {

        String path = "src\\main\\resources\\papersImpl.xml";

        /*PapersDOMBuilder papersDOMBuilder = new PapersDOMBuilder();
        papersDOMBuilder.buildSetPapers(path);
        System.out.println(papersDOMBuilder.getPapers());*/

        PapersSAXBuilder papersSAXBuilder = new PapersSAXBuilder();
        papersSAXBuilder.buildSetPapers(path);
        System.out.println(papersSAXBuilder.getPapers());
    }
}
