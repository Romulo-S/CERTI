package com.number.translate.resource;

import com.number.translate.service.TranslateNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class TranslateResource {

    @Autowired
    TranslateNumberService translateNumberService;

    @GetMapping("/{number}")
    public String translateNumber(@PathVariable(value="number") int number){

        return translateNumberService.translate(number);
    }
}
