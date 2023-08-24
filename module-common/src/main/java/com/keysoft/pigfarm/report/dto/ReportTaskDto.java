package com.keysoft.pigfarm.report.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class ReportTaskDto {

    private String taskTitle;
    private String deadline;
    private List<String> assigned;
    private List<String> todos;
    private Map<String, String> overdues; //Map<ten trai, nguyen nhan bi cham>
    private List<String> dones;
    private Map<String, String> rejects; // Map<ten trai, nguyen nhan tu choi>
    private Integer dataRowNumber;

    // search
    private String searchFromDate;
    private String searchToDate;
    private String assigneeUsername;
    private Boolean adminView;

}
