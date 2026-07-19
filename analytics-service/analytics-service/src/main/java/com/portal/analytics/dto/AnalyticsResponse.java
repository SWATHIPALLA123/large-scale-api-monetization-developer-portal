package com.portal.analytics.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalyticsResponse {

    private long totalDevelopers;

    private long totalApis;

    private long totalSubscriptions;

    private double totalRevenue;

    private long totalApiCalls;

}