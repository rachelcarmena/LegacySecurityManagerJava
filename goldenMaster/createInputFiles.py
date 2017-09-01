#!/usr/bin/python

for i in range(1, 12):
    f = open("equalsPasswords"+str(i)+".input", 'w')
    print >>f, "Rachel"
    print >>f, "Rachel M. Carmena"
    print >>f, "".join(map(str, range(i)))
    print >>f, "".join(map(str, range(i)))

for i in range(1, 12):
    f = open("notEqualsPasswords"+str(i)+".input", 'w')
    print >>f, "Rachel"
    print >>f, "Rachel M. Carmena"
    print >>f, "".join(map(str, range(i)))
    print >>f, "".join(map(str, range(i+1)))

