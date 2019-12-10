package com.epam.paper.saxtest;

import com.epam.paper.builder.Builder;
import com.epam.paper.entity.Magazine;
import com.epam.paper.entity.Newspaper;
import com.epam.paper.entity.Paper;
import com.epam.paper.exceptions.XmlParserException;
import com.epam.paper.parser.Parser;
import com.epam.paper.parser.sax.SaxParser;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.paper.constants.Constants.PATH_TO_TEST_FILE_FOR_NEGATIVE_TEST;
import static com.epam.paper.constants.Constants.PATH_TO_TEST_FILE_FOR_POSITIVE_TEST;

public class SaxParserTest {
    private Parser parser;
    private Builder builder;

    @BeforeTest
    void setUp() throws XmlParserException {
        parser = new SaxParser();
        builder = new Builder();
    }

    @Test
    public void testParsePositive() throws XmlParserException {
        //given
        List<Paper> expected = builder.buildPapers();
        //when
        List<Paper> actually = parser.parse(PATH_TO_TEST_FILE_FOR_POSITIVE_TEST);
        //then
        Assert.assertEquals(expected.get(0).getId(), actually.get(0).getId());
        Assert.assertEquals(expected.get(0).getOwner(), actually.get(0).getOwner());
        Assert.assertEquals(expected.get(0).getTitle(), actually.get(0).getTitle());
        Assert.assertEquals(expected.get(0).getPrice(), actually.get(0).getPrice());
        Assert.assertEquals(((Newspaper) expected.get(0)).getSubscriptionIndex(), ((Newspaper) actually.get(0)).getSubscriptionIndex());
        Assert.assertEquals(((Newspaper) expected.get(0)).getOutputFrequency(), ((Newspaper) actually.get(0)).getOutputFrequency());
        Assert.assertEquals(((Magazine) expected.get(0)).getSubject(), ((Magazine) expected.get(0)).getSubject());
    }

    @Test(expectedExceptions = XmlParserException.class)
    public void testParseNegative() throws XmlParserException {
        //given
        List<Paper> expected = builder.buildPapers();
        //when
        List<Paper> actually = parser.parse(PATH_TO_TEST_FILE_FOR_NEGATIVE_TEST);
        //then
        Assert.assertEquals(expected.get(0).getId(), actually.get(0).getId());
        Assert.assertEquals(expected.get(0).getOwner(), actually.get(0).getOwner());
        Assert.assertEquals(expected.get(0).getTitle(), actually.get(0).getTitle());
        Assert.assertEquals(expected.get(0).getPrice(), actually.get(0).getPrice());
        Assert.assertEquals(((Newspaper) expected.get(0)).getSubscriptionIndex(), ((Newspaper) actually.get(0)).getSubscriptionIndex());
        Assert.assertEquals(((Newspaper) expected.get(0)).getOutputFrequency(), ((Newspaper) actually.get(0)).getOutputFrequency());
        Assert.assertEquals(((Magazine) expected.get(0)).getSubject(), ((Magazine) expected.get(0)).getSubject());
    }
}

