package com.ylht.xzhcontroller;

import com.ylht.service.AmendrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MaintenancerecordController {
    @Autowired
    private AmendrecordService service;
}
