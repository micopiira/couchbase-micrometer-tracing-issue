package io.github.micopiira.couchbasemicrometertracingissue;

import org.springframework.data.couchbase.core.CouchbaseOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class HelloWorldController {
    private final CouchbaseOperations couchbaseOperations;

    public HelloWorldController(CouchbaseOperations couchbaseOperations) {
        this.couchbaseOperations = couchbaseOperations;
    }

    @GetMapping("/")
    @ResponseBody
    public String helloWorld() {
        couchbaseOperations.save(new TestEntity(UUID.randomUUID().toString(), UUID.randomUUID().toString()));
        return "Hello world!";
    }

}
