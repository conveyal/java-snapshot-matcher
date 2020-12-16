export JAVA_HOME=${JAVA_HOME:-/c/jdk}
export MAVEN_HOME=${MAVEN_HOME:-/c/maven}
export PATH=${JAVA_HOME}/bin:${PATH}
# Install java and maven
choco install jdk8 -params 'installdir=c:\\jdk' -y
choco install maven -params 'installdir=c:\\maven' -y