package zim

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK

@Controller
class InvasionController {

    @Autowired
    QuoteRepository repository

    @RequestMapping("/invader/{name}")
    @ResponseBody ResponseEntity quote(@PathVariable String name){
        def quotes = repository.findByName(name)
        if(!quotes) throw new InvaderNotFoundException(name)

        def quote = quotes[(int)(Math.random() * quotes.size())]
        new ResponseEntity(quote, OK)
    }

    @ExceptionHandler(InvaderNotFoundException)
    @ResponseBody ResponseEntity handle(InvaderNotFoundException infe){
        def error = new InvasionErrorResponse(error: NOT_FOUND.value(), message: infe.message)
        new ResponseEntity(error, NOT_FOUND)
    }
}
