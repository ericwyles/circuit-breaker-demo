#!/bin/bash

while [ true ]
do
    SECONDS=0
    echo "Calling endpoint2..."
    RESULT=$(curl -s http://localhost:8080/endpoint2)
	echo "Endpoint 2 returned '$RESULT' in $SECONDS seconds..."
	sleep 1
	echo
done