# Demo 2

Introduces circuit breaker. Thread pool is occasionally exhausted but recovers quickly when the circuit opens. Calls not to the slow endpoint are briefly affected.

[![Watch the video](https://i9.ytimg.com/vi/0dLcjU529Tg/mq2.jpg?sqp=CIr8v_IF&rs=AOn4CLCUxtmHWYCCNRbg0xvh-CUJGqGb_g)](https://youtu.be/0dLcjU529Tg)

# Build the app

mvn clean package

# Run the app and clients

java -jar target/circuit-breaker-demo-0.0.1-SNAPSHOT.jar

cd scripts && ./watch.sh

cd scripts && ./endpoint2_client.sh

cd scripts && ./endpoint1_client.sh

