package zim

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Quote {
    @Id BigInteger id
    String name
    String message
}
