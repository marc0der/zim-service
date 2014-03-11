package com.wiredforcode.zim

import com.wiredforcode.zim.config.MongoConfiguration
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import

@EnableAutoConfiguration
@ComponentScan("com.wiredforcode.zim.controllers")
@Import(MongoConfiguration)
class Application {
    static void main(String[] args){
        new SpringApplication(Application).run(args)
    }
}
