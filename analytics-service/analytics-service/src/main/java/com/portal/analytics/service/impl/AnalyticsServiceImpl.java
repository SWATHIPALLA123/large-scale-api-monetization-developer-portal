package com.portal.analytics.service.impl;

import org.springframework.stereotype.Service;

import com.portal.analytics.dto.AnalyticsResponse;
import com.portal.analytics.service.AnalyticsService;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {

    @Override
    public AnalyticsResponse getDashboard() {

        return new AnalyticsResponse(
                25,          // Total Developers
                12,          // Total APIs
                18,          // Total Subscriptions
                24500.00,    // Total Revenue
                98500        // Total API Calls
        );
    }
}