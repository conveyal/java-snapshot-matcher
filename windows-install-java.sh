export JAVA_HOME=${JAVA_HOME:-/c/jdk}
export PATH=${JAVA_HOME}/bin:${PATH}
# Install java and maven
choco install jdk8 -params 'installdir=c:\\jdk' -y
choco install maven
# Refresh shell (so that PATH variable changed by choco is valid)
refreshenv