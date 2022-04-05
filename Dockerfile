#define base docker image
FROM openjdk:11
LABEL maintainer="kalia.network"
ADD target/SubscriptionAPI-0.0.1-SNAPSHOT.jar kn_subscription_api.jar
ENTRYPOINT ["java", "-jar", "kn_subscription_api.jar"]