#!/bin/bash
export MPJ_HOME=/usr/mpj/
export PATH=$MPJ_HOME/bin:$PATH

javac -cp $MPJ_HOME/lib/mpj.jar Hasher_Scatter_Gather.java

$MPJ_HOME/bin/mpjrun.sh -np 5 Hasher_Scatter_Gather
