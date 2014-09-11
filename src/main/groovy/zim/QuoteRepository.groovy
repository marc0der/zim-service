package zim

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface QuoteRepository extends MongoRepository<Quote, BigInteger> {
    Quote findByName(String name)
}