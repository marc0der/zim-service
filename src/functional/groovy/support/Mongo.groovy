package support

import com.mongodb.BasicDBObject
import com.mongodb.DB
import com.mongodb.DBCollection
import com.mongodb.MongoClient
import com.mongodb.WriteConcern

class Mongo {
    static primeDatabase(String name) {
        def mongo = new MongoClient()
        mongo.writeConcern = WriteConcern.NORMAL
        mongo.getDB(name)
    }

    static createCollection(DB db, String name) {
        db.createCollection(name, new BasicDBObject())
    }

    static dropCollection(DB db, String name) {
        db.getCollection(name).drop()
    }

    static insertInvader(DBCollection collection, String invader) {
        collection.insert(new BasicDBObject("name", invader))
    }

    static updateInvader(DBCollection collection, String invader, String message) {
        def query = new BasicDBObject("name", invader)
        def update = new BasicDBObject("name", invader).append("message", message)
        collection.update(query, update)
    }
}
