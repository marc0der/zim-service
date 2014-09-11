package zim

import com.mongodb.Mongo
import com.mongodb.MongoClient
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration

@Configuration
class MongoConfig extends AbstractMongoConfiguration {
    @Override
    String getDatabaseName() {
        "invasion"
    }

    @Override
    Mongo mongo() throws Exception {
        new MongoClient()
    }
}
