FROM bigtruedata/sbt:0.13.15-2.12.2
RUN git clone https://github.com/jpoh97/PlayFramework-Java /app \
    && cd /app \
    && sbt clean compile
ENTRYPOINT [ "sbt run" ]
