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

    static insertInvader(DBCollection collection, String name, String message) {
        collection.insert(new BasicDBObject("name", name).append("message", message))
    }
}
