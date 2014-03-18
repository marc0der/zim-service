package zim

import com.mongodb.Mongo
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration

@Configuration
class MongoConfiguration extends AbstractMongoConfiguration {

    String getDatabaseName() {
        "invasion"
    }

    Mongo mongo() throws Exception {
        new Mongo()
    }

    String getMappingBasePackage() {
        "zim"
    }
}
