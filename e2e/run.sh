# specify KARATE_SOURCE_PATH relative to e2e module path
export KARATE_SOURCE_PATH=src/test/java
mvn clean install

export URL=http://localhost:8080
export NUMBER_OF_USERS=1
export DURATION=1
export FEATURE_REGEX=".*(hello2)\\.feature"

java -jar target/karate-gatling.e2e-0.0.1-SNAPSHOT.jar
