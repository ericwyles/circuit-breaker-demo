
* **demo1** - no resilience4j patterns at all. Frequent calls to endpoint1 will eventually starve the app of resources (threads) affecting all endpoints and grinding the app to a halt.

[![Watch the video](https://i9.ytimg.com/vi/bP8rpTYJ10w/mq2.jpg?sqp=CPf6v_IF&rs=AOn4CLCKftGrO2q-W3bfHJzRwvbqWZYsQw)](https://youtu.be/bP8rpTYJ10w)

# Build the app

mvn clean package

# Run the app and clients

java -jar target/circuit-breaker-demo-0.0.1-SNAPSHOT.jar

cd scripts && ./endpoint2_client.sh

cd scripts && ./endpoint1_client.sh

