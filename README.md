This project contains code, demos, and other resources to accompany the
presentation given at the J.B. Hunt "Skill Up" on February 25, 2020.
Please contact me if you have any questions or need any further
resources. Session recordings will be available to employees from the
J.B. Hunt training department.

Navigate to the project on github to clone the repo and explore the code branches: https://github.com/ericwyles/circuit-breaker-demo

## Demo 1
* **Code**: [https://github.com/ericwyles/circuit-breaker-demo/tree/demo1](https://github.com/ericwyles/circuit-breaker-demo/tree/demo1)
* **Description**: No resilience4j patterns at all. Frequent calls to endpoint1 will eventually starve the app of resources (threads) affecting all endpoints and grinding the app to a halt.
*  **Watch the video**: [https://youtu.be/bP8rpTYJ10w](https://youtu.be/bP8rpTYJ10w)



## Demo2
* **Code**: [https://github.com/ericwyles/circuit-breaker-demo/tree/demo2](https://github.com/ericwyles/circuit-breaker-demo/tree/demo2)
* **Description**: Introduces circuit breaker. Thread pool is occasionally exhausted but recovers quickly when the circuit opens. Calls not to the slow endpoint are briefly affected.
*  **Watch the video**: [https://youtu.be/0dLcjU529Tg](https://youtu.be/0dLcjU529Tg)


## Demo 3
* **Code**:
  [https://github.com/ericwyles/circuit-breaker-demo/tree/demo3](https://github.com/ericwyles/circuit-breaker-demo/tree/demo3)
* **Description**: Introduces bulkhead in addition to circuit breaker. Thread pool is never fully exhausted. Slow endpoint still has problems but does not cause problems for other endpoints.
*  **Watch the video**: [https://youtu.be/H5IUkvINgwM](https://youtu.be/H5IUkvINgwM)


## Additional resources
* https://resilience4j.readme.io/docs/getting-started
* https://github.com/resilience4j/resilience4j

