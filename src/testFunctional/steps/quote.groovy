import com.mongodb.BasicDBObject
import com.mongodb.MongoClient
import com.mongodb.WriteConcern
import wslite.rest.RESTClient

import static cucumber.api.groovy.EN.And
import static cucumber.api.groovy.Hooks.*

Before(){
    client = new RESTClient("http://localhost:8080")
    def mongo = new MongoClient()
    mongo.writeConcern = WriteConcern.NORMAL
    db = mongo.getDB("invasion")
    quotes = db.createCollection("quote", new BasicDBObject())
}

After(){
    db.getCollection("quote").drop()
}

And(~'^an Invader named "([^"]*)"$') { String invader ->
    quotes.insert(new BasicDBObject("name", invader))
}

And(~'^the Invader "([^"]*)" says "([^"]*)"$') { String invader, String message ->
    def query = new BasicDBObject("name", invader)
    def update = new BasicDBObject("name", invader).append("message", message)
    quotes.update(query, update)
}

And(~'^a Quote is requested for "([^"]*)"$') { String invader ->
    response = client.get(path:"/invasion/${invader}")
}

And(~'^we hear "([^"]*)"$') { String quote ->
    assert response.statusCode == 200
    assert response.json.message == quote
}