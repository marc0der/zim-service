import sun.security.util.PendingException
import support.Http
import support.Mongo

import static cucumber.api.groovy.EN.*
import static cucumber.api.groovy.Hooks.After
import static cucumber.api.groovy.Hooks.Before

client = Http.primeRestClient()
db = Mongo.primeDatabase("invasion")

Before() {
    coll = Mongo.createCollection(db, "quote")
}

After() {
    Mongo.dropCollection(db, "quote")
}

Given(~'^invader "([^"]*)" says "([^"]*)"$') { String name, String message ->
    throw new PendingException("not implemented")
}

When(~'^a quote is requested for "([^"]*)"$') { String name ->
    throw new PendingException("not implemented")
}

Then(~'^the status is (\\d+)$') { int status ->
    throw new PendingException("not implemented")
}

And(~'^we receive "([^"]*)"$') { String message ->
    throw new PendingException("not implemented")
}