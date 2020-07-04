package com.ylht.schedule;

import com.ylht.service.MpuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class SaticScheduleTask {
    @Autowired
    private MpuserService mpuserService;

    public SaticScheduleTask() {
    }
}
