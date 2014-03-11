package com.wiredforcode.zim.config
import com.mongodb.Mongo
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration

import static com.mongodb.WriteConcern.SAFE

@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {

    String getDatabaseName() {
        "invasion"
    }

    Mongo mongo() throws Exception {
        Mongo mongo = new Mongo()
        mongo.setWriteConcern(SAFE)
        mongo
    }

    String getMappingBasePackage() {
        "com.wiredforcode.zim.model";
    }
}
