package zim

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface QuoteRepository extends MongoRepository<Quote, BigInteger> {
    List<Quote> findByName(String name)
}
