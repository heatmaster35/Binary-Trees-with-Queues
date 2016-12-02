###################################
# Name: Anthony Lampi & Leo Gomez #
# CruzID: alampi & legomez        #
# Class: CMPS-12B                 #
# Date: Nov 19, 2014              #
# filename: Makefile              #
# Details: a simple make file for #
#    asg3                         #
###################################

JAVASRC    = xref.java auxlib.java Tree.java Queue.java
SOURCES    = ${JAVASRC} Makefile
ALLSOURCES = ${SOURCES}
MAINCLASS  = xref
CLASSES    = ${patsubst %.java, %.class, ${JAVASRC}}

all: ${CLASSES}

%.class: %.java
	javac -Xlint $<

clean:
	rm -f *.class

test: all
	java xref test.txt

debug: all
	java xref -d test.txt

.PHONY: clean all test debug
