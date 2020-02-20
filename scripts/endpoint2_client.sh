#!/bin/bash

n=1

while [ true ]
do
    SECONDS=0
    echo "Calling endpoint2. Attempt #$n..."
    RESULT=$(curl -s http://localhost:8080/endpoint2)
	echo "Endpoint 2 returned '$RESULT' in $SECONDS seconds..."
	sleep 1
	echo
	n=$(( n+1 ))
done