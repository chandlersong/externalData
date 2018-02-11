package org.externaldata.app.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SinaPriceController {

    @RequestMapping(path="/sinaprice/{stockId}/lastedPrice",method=RequestMethod.GET,produces = {"text/plain"})
    public String lastedPrice(@PathVariable(value="stockId") String stockId) {
    	System.out.println(stockId);
    	return String.valueOf((new Random()).nextInt(1000));
    }
}


