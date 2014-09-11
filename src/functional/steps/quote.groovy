import support.Http
import support.Mongo
import wslite.http.HTTPClientException

import static cucumber.api.groovy.EN.*
import static cucumber.api.groovy.Hooks.After
import static cucumber.api.groovy.Hooks.Before
import static support.Http.getInvader
import static support.Mongo.*
import static support.Mongo.primeDatabase

client = Http.primeRestClient()
db = primeDatabase("invasion")

Before() {
    quotes = createCollection(db, "quote")
}

After() {
    dropCollection(db, "quote")
}

Given(~'^an Invader named "([^"]*)"$') { String name ->
    insertInvader(quotes, name)
}

And(~'^the Invader "([^"]*)" says "([^"]*)"$') { String name, String message ->
    updateInvader(quotes, name, message)
}

When(~'^a Quote is requested for "([^"]*)"$') { String name ->
    try {
        response = getInvader(client, name)
    } catch (HTTPClientException rce) {
        response = rce.response
    }
}

Then(~'^the status is (\\d+)$') { int status ->
    assert response.statusCode == status
}

And(~'^we hear "([^"]*)"$') { String message ->
    assert response.json.message == message
}