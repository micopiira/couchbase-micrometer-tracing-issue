# Steps to reproduce

1. Start Couchbase & Jaeger
    ```
   docker compose up -d
   ```
   
2. Initialize Couchbase cluster
   1. Go to http://localhost:8091/ (Couchbase admin UI)
   2. Set up cluster with user 'Administrator' and password 'password'
   3. Create bucket with name 'test'

3. Start the Spring Boot application

```
./mvnw spring-boot:run
```

4. Visit http://localhost:8080/ (The Spring Boot app)

5. Visit to http://localhost:16686/ (Jaeger UI) and see the incorrect traces