package org.externaldata.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



/**
 * 0："万 科Ａ"，股票；
   1："25.900"，今开；
2："26.000"，昨收；
3："26.040"，当前价格；
4："26.100"，今日最高价；
5："25.510"，今日最低价；
6："26.030"，竞价买一报价；
7："26.050"，竞价卖一报价；
8："46121388"，成交量；
9："1189370537.360"，成交额；
10～29为五档信息
30："2016-10-18"，日期；
31："14:13:36"，时间； 
 * @author Chandler
 *
 */
@RestController
public class SinaPriceController {

	private final static String PRICE_FORMAT = "http://hq.sinajs.cn/list=%1s";
	
    @RequestMapping(path="/sinaprice/{stockId}/lastedPrice",method=RequestMethod.GET,produces = {"text/plain"})
    public String lastedPrice(@PathVariable(value="stockId") String stockId) {
    	RestTemplate restTemplate = new RestTemplate();
    	ResponseEntity<String> response = restTemplate.getForEntity(String.format(PRICE_FORMAT, stockId),String.class);
    	
    	if(response.getStatusCode()!= HttpStatus.OK){
    		return response.getStatusCode().toString();
    	}
    	try {
			return response.getBody().split(",")[3];
		} catch (Exception e) {
			return response.getBody();
		}
    }
}

