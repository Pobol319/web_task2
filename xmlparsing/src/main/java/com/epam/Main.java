package com.epam;

import com.epam.parser.dom.PapersDOMBuilder;

public class Main {
    public static void main(String[] args) {

        String path = "src\\main\\resources\\papersImpl.xml";

        PapersDOMBuilder papersDOMBuilder = new PapersDOMBuilder();
        papersDOMBuilder.buildSetPapers(path);
        System.out.println(papersDOMBuilder.getPapers());
    }
}
