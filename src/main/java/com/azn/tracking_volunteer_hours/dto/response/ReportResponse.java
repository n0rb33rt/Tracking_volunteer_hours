package com.azn.tracking_volunteer_hours.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportResponse {
    List<ProjectResponse> projectResponses;
    Integer allHours;
}
