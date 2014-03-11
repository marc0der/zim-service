package com.wiredforcode.zim.controllers

import com.wiredforcode.zim.exception.InvaderNotFoundException
import com.wiredforcode.zim.model.Quote
import com.wiredforcode.zim.repos.QuoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class InvasionController {

    private QuoteRepository repository;

    @Autowired
    InvasionController(QuoteRepository repository){
        this.repository = repository
    }

    @RequestMapping("/invasion/{name}")
    public @ResponseBody ResponseEntity<Quote> quote(@PathVariable String name){
        def quotes = repository.findByName(name);
        if(!quotes) throw new InvaderNotFoundException(name)

        def quote = quotes[(int)(Math.random() * quotes.size())]
        return new ResponseEntity<String>(quote, HttpStatus.OK)
    }
}
