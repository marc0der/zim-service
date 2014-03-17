package com.wiredforcode.zim.repos

import com.wiredforcode.zim.model.Quote
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface QuoteRepository extends MongoRepository<Quote, BigInteger> {
    List<Quote> findByName(String name)
}
