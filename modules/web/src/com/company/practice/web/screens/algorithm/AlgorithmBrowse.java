package com.company.practice.web.screens.algorithm;

import com.haulmont.cuba.gui.screen.*;
import com.company.practice.entity.Algorithm;

@UiController("practice_Algorithm.browse")
@UiDescriptor("algorithm-browse.xml")
@LookupComponent("algorithmsTable")
@LoadDataBeforeShow
public class AlgorithmBrowse extends StandardLookup<Algorithm> {
}