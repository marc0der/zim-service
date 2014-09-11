package zim

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

class InvasionControllerSpec extends Specification {

    InvasionController controller
    QuoteRepository repository = Mock()

    void setup() {
        controller = new InvasionController(repository: repository)
    }

    void "should quote invader zim successfully"() {
        given:
        String name = "zim"
        String message = "DOOOM!"
        def quote = new Quote(name: name, message: message)

        and:
        1 * repository.findByName(name) >> quote

        when:
        ResponseEntity<Quote> response = controller.quote(name)

        then:
        response.statusCode == HttpStatus.OK
        response.body.name == name
        response.body.message == message
    }

    void "should quote invader gir successfully"() {
        given:
        String name = "gir"
        String message = "doomdy doomdy doom!"
        def quote = new Quote(name: name, message: message)

        and:
        1 * repository.findByName(name) >> quote

        when:
        ResponseEntity<Quote> response = controller.quote(name)

        then:
        response.statusCode == HttpStatus.OK
        response.body.name == name
        response.body.message == message
    }

    void "should handle an unknown invader"() {
        when:
        controller.quote("unknown")

        then:
        def e = thrown(InvaderNotFoundException)
        e.message == "Invader not found: unknown"
    }

}
