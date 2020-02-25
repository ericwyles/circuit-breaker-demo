
* **demo3** - introduces bulkhead in addition to circuit breaker. Thread pool is never fully exhausted. Slow endpoint still has problems but does not cause problems for other endpoints.
mvn clean package

[![Watch the video](https://i9.ytimg.com/vi/H5IUkvINgwM/mq2.jpg?sqp=CIb9v_IF&rs=AOn4CLA7-ncuobgA6H76ioIjQSA_Z80HGg)](https://youtu.be/H5IUkvINgwM)

# Build the app

mvn clean package

# Run the app and clients

java -jar target/circuit-breaker-demo-0.0.1-SNAPSHOT.jar

cd scripts && ./watch.sh

cd scripts && ./endpoint2_client.sh

cd scripts && ./endpoint1_client.sh

