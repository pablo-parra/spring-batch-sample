# spring-batch-sample
Sample project with a simple Spring Batch implementation.

The project contains two jobs, related to different endpoints. One Job is synchronous and the other asynchronous, although both use the same reader, processor and writer.

The steps used by the jobs read the students from a _student_ table, discard the ones that have the 'enabled' attribute to false, and finally the remaining students are written to a different table _enabled__student_.

Both jobs can be launched using dedicated rest endpoints:

* `/startjob` : to start the sync one.
* `/startjobasync` : to start the async one.

## DB with docker

### Creation of the db container with Docker (first time)
`C:\...\spring-batch-sample\docker_MySQL> docker build -t batch_db_img:0.0.1 .`

`C:\...> docker run -d --name batch_db -p 3306:3306 batch_db_img:0.0.1`

### Start the db container (rest of the times)

`C:\...> docker start batch_db`

## Resources

* https://docs.spring.io/spring-batch/4.0.x/reference/html/
* https://www.toptal.com/spring/spring-batch-tutorial
* https://www.baeldung.com/spring-batch-tasklet-chunk
* https://spring.io/projects/spring-batch
* https://docs.spring.io/spring-boot/docs/current/reference/html/howto-batch-applications.html
* https://www.baeldung.com/introduction-to-spring-batch
* https://www.petrikainulainen.net/programming/spring-framework/spring-batch-tutorial-reading-information-from-a-database/
