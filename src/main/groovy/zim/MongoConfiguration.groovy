package zim

import com.mongodb.Mongo
import com.mongodb.MongoClient
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration

@Configuration
class MongoConfiguration extends AbstractMongoConfiguration {

    String getDatabaseName() {
        "invasion"
    }

    Mongo mongo() throws Exception {
        new MongoClient()
    }
}
