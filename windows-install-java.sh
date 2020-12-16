export JAVA_HOME=${JAVA_HOME:-/c/jdk}
export MAVEN_HOME=${MAVEN_HOME:-/c/ProgramData/chocolatey/lib/maven}
export PATH=${MAVEN_HOME}/bin:${JAVA_HOME}/bin:${PATH}
echo $PATH
# Install java and maven
choco install jdk8 -params 'installdir=c:\\jdk' -y
choco install maven -y
# Call choco's RefreshEnv so that new environment variable is recognized.
C:\ProgramData\chocolatey\bin\RefreshEnv