package com.company.practice.web.screens;

import com.haulmont.cuba.gui.screen.LoadDataBeforeShow;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

@UiController("practice_RandomNumbersScreen")
@UiDescriptor("random-numbers-screen.xml")
@LoadDataBeforeShow
public class RandomNumbersScreen extends Screen {
}