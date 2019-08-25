package com.company.practice.web.screens.algorithm;

import com.company.practice.entity.Algorithm;
import com.company.practice.entity.AlgorithmType;
import com.company.practice.entity.ProcessInformation;
import com.company.practice.service.ProcessService;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("practice_Algorithm.edit")
@UiDescriptor("algorithm-edit.xml")
@EditedEntityContainer("algorithmDc")
@LoadDataBeforeShow
public class AlgorithmEdit extends StandardEditor<Algorithm> {

    @Inject
    protected ProcessService processService;

    @Inject
    protected InstanceContainer<Algorithm> algorithmDc;
    @Inject
    protected TextField<String> nameField;
    @Inject
    protected TextField<Double> memoryField;
    @Inject
    protected TextField<Long> timeField;
    @Inject
    private TextField<AlgorithmType> typeField;

    @Subscribe("infoField")
    protected void onInfoFieldValueChange(HasValue.ValueChangeEvent<ProcessInformation> event) {
        ProcessInformation processInformation = event.getValue();
        if (processInformation != null) {
            nameField.setValue(processInformation.getName());
            typeField.setValue(processInformation.getType());
        } else {
            nameField.setValue("");
            memoryField.setValue(0.0d);
            timeField.setValue(0L);
            typeField.setValue(null);
        }
    }

    @Subscribe("refreshInfo")
    protected void onRefreshInfoClick(Button.ClickEvent event) {
        refreshItem();
    }

    protected void refreshItem() {
        Algorithm algorithm = algorithmDc.getItem();
        Algorithm newAlgorithm = processService.run(algorithm);
        algorithm.setTime(newAlgorithm.getTime());
        algorithm.setMemory(newAlgorithm.getMemory());
    }
}