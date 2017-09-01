#!/bin/bash

echo "Creating input files..."
./createInputFiles.py
echo "Executing..."
for i in {1..11}; do
    echo "Equals passwords - Length: "${i}
    java -classpath ../target/classes/ Main < equalsPasswords${i}.input > equalsPasswords${i}.output
done

for i in {1..11}; do
    echo "Not equals passwords - Base length: "${i}
    java -classpath ../target/classes/ Main < notEqualsPasswords${i}.input > notEqualsPasswords${i}.output
done
