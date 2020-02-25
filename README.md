Navigate to the project on github to clone the repo and explore the code branches: https://github.com/ericwyles/circuit-breaker-demo

## Demo 1
* **Code**: [https://github.com/ericwyles/circuit-breaker-demo/tree/demo1](https://github.com/ericwyles/circuit-breaker-demo/tree/demo1)
* **Description**: No resilience4j patterns at all. Frequent calls to endpoint1 will eventually starve the app of resources (threads) affecting all endpoints and grinding the app to a halt.

[![Watch the video](https://i9.ytimg.com/vi/bP8rpTYJ10w/mq2.jpg?sqp=CPf6v_IF&rs=AOn4CLCKftGrO2q-W3bfHJzRwvbqWZYsQw)](https://youtu.be/bP8rpTYJ10w)



## Demo2
* **Code**: [https://github.com/ericwyles/circuit-breaker-demo/tree/demo2](https://github.com/ericwyles/circuit-breaker-demo/tree/demo2)
* **Description**: Introduces circuit breaker. Thread pool is occasionally exhausted but recovers quickly when the circuit opens. Calls not to the slow endpoint are briefly affected.

[![Watch the video](https://i9.ytimg.com/vi/0dLcjU529Tg/mq2.jpg?sqp=CIr8v_IF&rs=AOn4CLCUxtmHWYCCNRbg0xvh-CUJGqGb_g)](https://youtu.be/0dLcjU529Tg)


## Demo 3
* **Code**:
  [https://github.com/ericwyles/circuit-breaker-demo/tree/demo3](https://github.com/ericwyles/circuit-breaker-demo/tree/demo3)
* **Description**: Introduces bulkhead in addition to circuit breaker. Thread pool is never fully exhausted. Slow endpoint still has problems but does not cause problems for other endpoints.

[![Watch the video](https://i9.ytimg.com/vi/H5IUkvINgwM/mq2.jpg?sqp=CIb9v_IF&rs=AOn4CLA7-ncuobgA6H76ioIjQSA_Z80HGg)](https://youtu.be/H5IUkvINgwM)


## Additional resources
* https://resilience4j.readme.io/docs/getting-started
* https://github.com/resilience4j/resilience4j

