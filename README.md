# Rest Jersey Messenger

## Sumary

Basic example of a REST API using Jersey.
 
Jersey is a Framework created under the JAX-RS Reference implementation (JSR 311 & JSR 339).
It provides a set of tools that easily helps to develop consistent Web Services in Java.

This project is a basic setup to start using Jersey to create REST services. 
It's intention is to get a general idea of it's usage and get and overview of it's main features.

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

### Messages Endpoint

To test the service make the following calls:

1. To get all messages
    
    `curl -X GET http://localhost:8080/v1/messages`

    It should return a response like:
    
    ```Json
    [
        {
            "author": "eddard",
            "id": 1,
            "lastModified": "2017-11-14T20:27:15.471",
            "links": [],
            "message": "Winter is coming"
        },
        {
            "author": "daenerys",
            "id": 2,
            "lastModified": "2010-05-15T10:51:30",
            "links": [],
            "message": "Mother of Dragons"
        },
        {
            "author": "cercei",
            "id": 3,
            "lastModified": "2017-11-14T20:27:15.472",
            "links": [],
            "message": "Queen of the Seven Kingdoms"
        }
    ]
    ```
    Also you can get a xml response adding an *Accept* header in the request
    
    `curl -X GET --header "Accept: application/xml" http://localhost:8080/v1/messages`
    
    ```XML
    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    <messages>
        <message>
            <author>eddard</author>
            <id>1</id>
            <lastModified/>
            <message>Winter is coming</message>
        </message>
        <message>
            <author>daenerys</author>
            <id>2</id>
            <lastModified/>
            <links>
                <rel>comments</rel>
                <url>http://localhost:8080/v1/messages/2/comments/</url>
            </links>
            <links>
                <rel>self</rel>
                <url>http://localhost:8080/v1/messages/2</url>
            </links>
            <links>
                <rel>author</rel>
                <url>http://localhost:8080/v1/profiles/daenerys</url>
            </links>
            <message>Mother of Dragons</message>
        </message>
        <message>
            <author>cercei</author>
            <id>3</id>
            <lastModified/>
            <message>Queen of the Seven Kingdoms</message>
        </message>
    </messages>
    ```
    
    
    
2. To get a single message:

    `curl -X GET http://localhost:8080/v1/messages/2`
    
    ```Json
    {
        "author": "daenerys",
        "id": 2,
        "lastModified": "2010-05-15T10:51:30",
        "links": [
            {
                "rel": "comments",
                "url": "http://localhost:8080/v1/messages/2/comments/"
            },
            {
                "rel": "self",
                "url": "http://localhost:8080/v1/messages/2"
            },
            {
                "rel": "author",
                "url": "http://localhost:8080/v1/profiles/daenerys"
            }
        ],
        "message": "Mother of Dragons"
    }
    ```
    Xml Response
    
    `curl -X GET --header "Accept: application/xml" http://localhost:8080/v1/messages/2`
    
    ```XML
    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    <message>
        <author>daenerys</author>
        <id>2</id>
        <lastModified/>
        <links>
            <rel>comments</rel>
            <url>http://localhost:8080/v1/messages/2/comments/</url>
        </links>
        <links>
            <rel>self</rel>
            <url>http://localhost:8080/v1/messages/2</url>
        </links>
        <links>
            <rel>author</rel>
            <url>http://localhost:8080/v1/profiles/daenerys</url>
        </links>
        <message>Mother of Dragons</message>
    </message>
    ```
    
    
    
### Profiles Endpoint

1. To get all Profiles:

    `curl -X GET http://localhost:8080/v1/profiles`
    
    It should return a response like :
    
    ```Json
    [
        {
            "firstName": "Cercei",
            "id": 3,
            "lastModified": "2009-06-03T05:30:30",
            "lastName": "Lannister",
            "profileName": "cercei"
        },
        {
            "firstName": "Daenerys",
            "id": 2,
            "lastModified": "2017-11-14T20:28:40.877",
            "lastName": "Targaryen",
            "profileName": "daenerys"
        },
        {
            "firstName": "Eddard",
            "id": 1,
            "lastModified": "2017-11-14T20:28:40.877",
            "lastName": "Stark",
            "profileName": "eddard"
        }
    ]
    ```
2. To get a single Profile:

    `curl -X GET http://localhost:8080/v1/profiles/cercei`
    
    It should get a response like:
    
    ```JSON
    {
        "firstName": "Cercei",
        "id": 3,
        "lastModified": "2009-06-03T05:30:30",
        "lastName": "Lannister",
        "profileName": "cercei"
    }
    ```
 

