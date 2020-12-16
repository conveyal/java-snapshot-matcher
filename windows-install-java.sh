export JAVA_HOME=${JAVA_HOME:-/c/jdk}
export PATH=${JAVA_HOME}/bin:${PATH}
# Install java
choco install jdk8 -params 'installdir=c:\\jdk' -y