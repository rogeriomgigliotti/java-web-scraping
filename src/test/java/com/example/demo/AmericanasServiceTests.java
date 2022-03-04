package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.business.ResultTypeEnum;
import com.example.demo.business.ServiceResult;
import com.example.demo.services.AmericanasService;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = AmericanasService.class)
class AmericanasServiceTests {
    @Autowired
    AmericanasService service;

	@Test
	void contextLoads() {
	}

	@Test
	void getProductsByCategoryAndSort() throws IOException {
		ServiceResult<String> result = service.getTop3WebCamLoweredPrice();
		assertEquals(ResultTypeEnum.Success, result.getResultType());
	}
}
