package com.epam.paper.parser.jaxb;

import com.epam.paper.entity.Paper;
import com.epam.paper.entity.Papers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JaxbParser {

    public List<Paper> getData(String path) throws IllegalAccessException {
        File file = new File(path);
        try {
            JAXBContext context = JAXBContext.newInstance(Papers.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Papers papers = (Papers) unmarshaller.unmarshal(file);
            return papers.getPapers();
        } catch (JAXBException e) {
            throw new IllegalAccessException();
        }
    }

}
