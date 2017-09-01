#!/bin/bash

RESULT=0
echo "Comparing files..."
for i in {1..11}; do
    echo "Equals passwords - Length: "${i}
    java -classpath ../target/classes/ Main < equalsPasswords${i}.input > equalsPasswords${i}.output.new
    diff equalsPasswords${i}.output equalsPasswords${i}.output.new
    if [[ $? -ne 0 ]]; then 
        RESULT=1
    fi
done

for i in {1..11}; do
    echo "Not equals passwords - Base length: "${i}
    java -classpath ../target/classes/ Main < notEqualsPasswords${i}.input > notEqualsPasswords${i}.output.new
    diff notEqualsPasswords${i}.output notEqualsPasswords${i}.output.new
    if [[ $? -ne 0 ]]; then
        RESULT=1
    fi
done

echo "-----------------------"
if [[ $RESULT -eq 0 ]]; then
    echo "OK"
else
    echo "KO - There are differences"
fi
exit $RESULT
