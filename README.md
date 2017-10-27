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
    
4. Application will be deployed and listening  **http://localhost:8080/v1/messages**

