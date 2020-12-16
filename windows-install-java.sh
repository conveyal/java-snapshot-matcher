export JAVA_HOME=${JAVA_HOME:-/c/jdk}
export MAVEN_HOME=${MAVEN_HOME:-/c/maven}
export PATH=${MAVEN_HOME}/bin:${JAVA_HOME}/bin:${PATH}
echo $PATH
# Install java and maven
choco install jdk8 --install-directory 'c:\\jdk' -y
java -version
choco install maven --install-directory 'c:\\maven'
mvn --version