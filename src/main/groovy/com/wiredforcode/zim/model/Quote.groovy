package com.wiredforcode.zim.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document()
class Quote {

    @Id
    BigInteger id

    @Field
    String name

    @Field
    String message
}
