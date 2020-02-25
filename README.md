# Demo 3

Introduces bulkhead in addition to circuit breaker. Thread pool is never fully exhausted. Slow endpoint still has problems but does not cause problems for other endpoints.

[Watch the video](https://youtu.be/H5IUkvINgwM)

# Build the app

mvn clean package

# Run the app and clients

java -jar target/circuit-breaker-demo-0.0.1-SNAPSHOT.jar

cd scripts && ./watch.sh

cd scripts && ./endpoint2_client.sh

cd scripts && ./endpoint1_client.sh

