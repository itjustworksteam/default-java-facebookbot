FROM therickys93/ubuntu14java
ADD . /facebookbot
WORKDIR /facebookbot
RUN ./gradlew clean stage
CMD bash run.sh