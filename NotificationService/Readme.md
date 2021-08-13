Before Running
- Have docker installed and running
  Create rabbit-mq container if not created before
  docker run -it --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management

    - Start the container
    - docker start rabbitmq
  
-DB configuration
  - spring.datasource.url=jdbc:postgresql://localhost:5432/notifications?currentSchema=public&ssl=false
  - spring.datasource.username=postgres
  - spring.datasource.password=1234