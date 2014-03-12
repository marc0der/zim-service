import wslite.rest.RESTClient

import static cucumber.api.groovy.EN.And
import static cucumber.api.groovy.Hooks.Before

Before(){
    client = new RESTClient("http://localhost:8080")
}

And(~'^an Invader named "([^"]*)"$') { String invader ->
    // Express the Regexp above with the code you wish you had
    //throw new cucumber.api.PendingException()
}

And(~'^the Invader "([^"]*)" has a quote "([^"]*)"$') { String invader, String quote ->
    // Express the Regexp above with the code you wish you had
    //throw new cucumber.api.PendingException()
}

And(~'^a Quote is requested for "([^"]*)"$') { String invader ->
    // Express the Regexp above with the code you wish you had
    response = client.get(path:"/invasion/${invader}")
}

And(~'^we hear "([^"]*)"$') { String quote ->
    // Express the Regexp above with the code you wish you had
    assert response.statusCode == 200
    assert response.json.message == quote
}