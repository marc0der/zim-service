package zim

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class InvasionController {

    @Autowired
    QuoteRepository repository

    @RequestMapping("/invader/{name}")
    @ResponseBody
    ResponseEntity<Quote> quote(@PathVariable String name) {
        def quote = repository.findByName(name)
        if(!quote) throw new InvaderNotFoundException("Invader not found: $name")
        new ResponseEntity<Quote>(quote, HttpStatus.OK)
    }

    @ExceptionHandler
    ResponseEntity<String> handle(InvaderNotFoundException infe) {
        new ResponseEntity<String>(infe.message, HttpStatus.NOT_FOUND)
    }
}
