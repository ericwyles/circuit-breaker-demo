#!/bin/bash

n=1

while [ true ]
do
    ./getendpoint1.sh $n &
	sleep 1
	n=$(( n+1 ))
done