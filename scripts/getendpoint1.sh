#!/bin/bash

echo "ATTEMPT $1 starting..."
RESULT=$(curl -s http://localhost:8080/endpoint1)
echo "ATTEMPT $1 returned '$RESULT'"
echo
