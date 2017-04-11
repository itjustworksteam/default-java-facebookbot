FROM therickys93/alpinejava
ADD . /facebookbot
WORKDIR /facebookbot
RUN ./gradlew clean stage
CMD bash run.sh
