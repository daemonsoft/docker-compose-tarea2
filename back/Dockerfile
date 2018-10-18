FROM bigtruedata/sbt:0.13.15-2.12.2 as sbt
COPY . .
RUN sbt dist && unzip -d /svc target/universal/*-1.0-SNAPSHOT.zip &&mv svc/*/* svc/ && rm /svc/bin/*.bat && mv /svc/bin/* /svc/bin/start && set -x /svc/bin/start

FROM openjdk:8-jre
COPY --from=sbt /svc /app
EXPOSE 9000 9443
CMD /app/bin/start -Dhttps.port=9443 -Dplay.crypto.secret=secret