##### project description :
a tool to generate a gatling fat jar for external karate acceptance test , it is only require java v8 or v11 to be installed as a prerequisite  

##### steps to run the code :

1- generate jars including external project karate test
```
# specify KARATE_SOURCE_PATH relative to e2e module path
export KARATE_SOURCE_PATH=src/test/java
mvn clean install
```

2- run app sample api
```
java -jar app/target/karate-gatling.app-0.0.1-SNAPSHOT.jar
```

3- open a new terminal  and run gatling over karate tests
```
export URL=http://localhost:8080
export NUMBER_OF_USERS=1
export DURATION=1
export FEATURE_REGEX=".*(hello1|hello2)\\.feature"

java -jar e2e/target/karate-gatling.e2e-0.0.1-SNAPSHOT.jar.jar    
```

##### Note:
please use environment variables inside your karate test instead of system properties 
in order to make the tool run smoothly without extra customizations