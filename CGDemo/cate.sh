
JMETERDIR=/home/cgadmin/catemeter/catemeter-3.0

HOSTNAME=$1
PORT=$2
JMXSOURCE=$3

sh $JMETERDIR/bin/catemeter.sh -Jhostname=$HOSTNAME -Jport=$PORT -n -t $JMXSOURCE

