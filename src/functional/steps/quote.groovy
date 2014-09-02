import cucumber.api.PendingException
import support.Http
import support.Mongo
import wslite.rest.RESTClientException

import static cucumber.api.groovy.EN.*
import static cucumber.api.groovy.Hooks.*

Before() {
    client = Http.primeRestClient()
    db = Mongo.primeDatabase("invasion")
    quotes = Mongo.createCollection(db, "quote")
}

After() {
    Mongo.dropCollection(db, "quote")
}

And(~'^an Invader named "([^"]*)"$') { String invader ->
    Mongo.insertInvader(quotes, invader)
}

And(~'^the Invader "([^"]*)" says "([^"]*)"$') { String invader, String message ->
    Mongo.updateInvader(quotes, invader, message)
}

And(~'^a Quote is requested for "([^"]*)"$') { String invader ->
    try {
        response = Http.getInvader(client, invader)
    } catch (RESTClientException rce) {
        response = rce.response
    }
}

And(~'^we hear "([^"]*)"$') { String quote ->
    assert response.statusCode == 200
    assert response.json.message == quote
}
Then(~'^the Invader is Not Found$') { ->
    assert response.statusCode == 404
}