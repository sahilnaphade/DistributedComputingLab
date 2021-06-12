#!/bin/bash
export MPJ_HOME=/usr/mpj/
export PATH=$MPJ_HOME/bin:$PATH

javac -cp $MPJ_HOME/lib/mpj.jar Hasher.java

$MPJ_HOME/bin/mpjrun.sh -np 4 Hasher
