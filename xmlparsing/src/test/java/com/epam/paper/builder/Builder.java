package com.epam.paper.builder;
import com.epam.paper.entity.Magazine;
import com.epam.paper.entity.OutputFrequencyEnum;
import com.epam.paper.entity.Paper;

import java.util.ArrayList;
import java.util.List;

public class Builder {

    public List<Paper> buildPapers() {
        List<Paper> papers = new ArrayList<>();
        papers.add(getFirstPaper());
        return papers;
    }

    private Magazine getFirstPaper() {
        Magazine magazine = new Magazine();
        magazine.setId("o202");
        magazine.setOwner("Owner1");
        magazine.setTitle("Title1");
        magazine.setPrice(100);
        magazine.setSubscriptionIndex(200000);
        magazine.setOutputFrequency(OutputFrequencyEnum.EVERY_WEEK);
        magazine.setSubject("Subject");
        return magazine;
    }
}

