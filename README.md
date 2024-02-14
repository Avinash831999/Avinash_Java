Rabbit Mq :
Use below chat gpt chat for durable messages and queues 
https://chat.openai.com/share/70cb5864-a3e8-4b29-ba9e-cae7c2aea9dd

Docker command for running RabbitMQ 
docker run --rm -it -p 15672:15672 -p 5672:5672 rabbitmq:3.12.12-management


#Docker postgresql 3 databases
docker run --name productdatabase -e POSTGRES_DB=productdb -e POSTGRES_USER=productdbuser -e POSTGRES_PASSWORD=Login@123 -p 5436:5432 -d postgres:16


docker run --name userdatabase -e POSTGRES_DB=userdb -e POSTGRES_USER=userdbuser -e POSTGRES_PASSWORD=Login@123 -p 5434:5432 -d postgres:16

docker run --name orderdatabase -e POSTGRES_DB=orderdb -e POSTGRES_USER=orderuser -e POSTGRES_PASSWORD=Login@123 -p 5438:5432 -d postgres:16
