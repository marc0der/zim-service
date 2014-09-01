import support.Http
import support.Mongo

import static cucumber.api.groovy.EN.And
import static cucumber.api.groovy.Hooks.After
import static cucumber.api.groovy.Hooks.Before

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
    response = Http.getInvader(client, invader)
}

And(~'^we hear "([^"]*)"$') { String quote ->
    assert response.statusCode == 200
    assert response.json.message == quote
}