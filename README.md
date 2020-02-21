See Branches for version of the circuit breaker demo
* **demo1** - no resilience4j patterns at all. Frequent calls to endpoint1 will eventually starve the app of resources (threads) affecting all endpoints and grinding the app to a halt.
* **demo2** - introduces circuit breaker. Thread pool is occasionally exhausted but recovers quickly when the circuit opens. Calls not to the slow endpoint are briefly affected.
* **demo3** - introduces bulkhead in addition to circuit breaker. Thread pool is never fully exhausted. Slow endpoint still has problems but does not cause problems for other endpoints.

Additional resources
* https://resilience4j.readme.io/docs/getting-started
* https://github.com/resilience4j/resilience4j

Demo Videos

