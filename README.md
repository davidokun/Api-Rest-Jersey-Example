# Rest Jersey Messenger

## Sumary

Basic example of a REST API using Jersey.
 
Jersey is a Framework created under the JAX-RS Reference implementation (JSR 311 & JSR 339).
It provides a set of tools that easily helps to develop consistent Web Services in Java.

This project is a basic setup to start using Jersey to create REST services. It's intention is to get a general idea of it's usage.

---

## How to run

1. Clone repository to a local directory.

    `git clone https://github.com/davidokun/Api-Rest-Jersey-Messenger.git`
    
2. `cd` into the directory and execute:

    `mvn clean package`
    
3. `cd` into `{base.dir}/docker` and run:

    `docker-compose up`
    
4. Application will be deployed and listening on  **http://localhost:8080/v1/messages**

---

## Verify

To test the service make the following calls:

1. To get all messages
    
    `curl -X GET http://localhost:8080/v1/messages`

    It should return a response like:
    
    ```Json
    [
        {
            "author": "Eddard Stark",
            "created": "2017-10-27T20:17:58.147-05:00",
            "id": 1,
            "message": "Winter is coming"
        },
        {
            "author": "Daenerys Targaryen",
            "created": "2017-10-27T20:17:58.147-05:00",
            "id": 2,
            "message": "Mother of Dragons"
        },
        {
            "author": "Cercei Lannister",
            "created": "2017-10-27T20:17:58.147-05:00",
            "id": 3,
            "message": "Queen of the Seven Kingdoms"
        }
    ]
    ```
    
2. To get a single message:

    `curl -X GET http://localhost:8080/v1/messages/2`
    
    ```Json
    {
        "author": "Daenerys Targaryen",
        "created": "2017-10-27T20:20:05.572-05:00",
        "id": 2,
        "message": "Mother of Dragons"
    }
    ```
    
 

