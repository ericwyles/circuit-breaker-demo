#!/bin/bash

watch -d -n 1 -p -c '(curl -s http://localhost:8081/actuator/prometheus | grep endpoint1 | grep -v http | grep -v seconds | grep -v buffered | grep -v total | grep -v failure | grep -v slow | sort)'
