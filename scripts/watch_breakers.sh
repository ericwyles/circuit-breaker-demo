#!/bin/bash

watch -d -n 1 -p -c '(curl -s http://localhost:8081/actuator/prometheus | grep endpoint1 | grep state | grep -v forc | grep -v disab | grep -v metrics | grep 1.0)'
