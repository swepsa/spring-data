@echo off
set M2_REPO=C:\.m2\repository

set CLASSPATH=%M2_REPO%/org/springframework/spring-core/5.2.2.RELEASE/spring-core-5.2.2.RELEASE.jar
set CLASSPATH=%CLASSPATH%;%M2_REPO%/org/springframework/spring-jcl/5.2.2.RELEASE/spring-jcl-5.2.2.RELEASE.jar
set CLASSPATH=%CLASSPATH%;%M2_REPO%/org/springframework/spring-context/5.2.2.RELEASE/spring-context-5.2.2.RELEASE.jar
set CLASSPATH=%CLASSPATH%;%M2_REPO%/org/springframework/spring-aop/5.2.2.RELEASE/spring-aop-5.2.2.RELEASE.jar
set CLASSPATH=%CLASSPATH%;%M2_REPO%/org/springframework/spring-beans/5.2.2.RELEASE/spring-beans-5.2.2.RELEASE.jar
set CLASSPATH=%CLASSPATH%;%M2_REPO%/org/springframework/spring-expression/5.2.2.RELEASE/spring-expression-5.2.2.RELEASE.jar
set CLASSPATH=%CLASSPATH%;%M2_REPO%/org/springframework/spring-jdbc/5.2.2.RELEASE/spring-jdbc-5.2.2.RELEASE.jar
set CLASSPATH=%CLASSPATH%;%M2_REPO%/org/springframework/spring-tx/5.2.2.RELEASE/spring-tx-5.2.2.RELEASE.jar
set CLASSPATH=%CLASSPATH%;%M2_REPO%/org/apache/derby/derby/10.14.2.0/derby-10.14.2.0.jar
set CLASSPATH=%CLASSPATH%;%M2_REPO%/org/apache/commons/commons-dbcp2/2.7.0/commons-dbcp2-2.7.0.jar
set CLASSPATH=%CLASSPATH%;%M2_REPO%/org/apache/commons/commons-pool2/2.7.0/commons-pool2-2.7.0.jar
set CLASSPATH=%CLASSPATH%;%M2_REPO%/commons-logging/commons-logging/1.2/commons-logging-1.2.jar

set CLASSPATH=%CLASSPATH%;target/classes

rem echo %CLASSPATH%

java -cp %CLASSPATH% project.App
