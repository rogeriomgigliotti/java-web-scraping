package com.example.demo.controllers;

import com.example.demo.business.ServiceResult;
import com.example.demo.services.AmericanasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api/americanas")
public class AmericanasController extends BaseController {
    @Autowired
    AmericanasService service;

    @GetMapping(value = "/getTop3WebCamLoweredPrice")
    public String getTop3WebCamLoweredPrice () throws IOException {
        ServiceResult<String> top3WebCamLoweredPrice = service.getTop3WebCamLoweredPrice();
        
        return top3WebCamLoweredPrice.getData();
    }
}
