# Test Connect via Java(Sync)

## 1. Write the following code snippet into ConnectDBAndGetDataTest.java

Modify the code snippet below by replacing `<username>`, `<password>`, `<host>`, `<db-name>`, `<collection-name>`

```sh
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.net.URLEncoder;
public class TryGetACollection {
    public static void main(String [] args){
        try{
            String username = URLEncoder.encode("<username>", "UTF-8");
            String password = URLEncoder.encode("<password>", "UTF-8");
            String host = "<host>";
            
            String uri = "mongodb+srv://" + username + ":" + password + "@" + host + "/?w=majority";

            MongoClient mongoClient = MongoClients.create(uri);
    
            MongoDatabase database = mongoClient.getDatabase("<db-name>");
            MongoCollection<Document> collection = database.getCollection("<collection-name>");
            
            collection.find().forEach(doc -> System.out.println(doc.toJson()));
        } catch(Exception e){
            SSystem.err.println(e);
        }
    }
}
```

## 2. Download dependencies into libs/
https://repo1.maven.org/maven2/org/mongodb/mongodb-driver-sync/5.4.0/mongodb-driver-sync-5.4.0.jar
https://repo1.maven.org/maven2/org/mongodb/mongodb-driver-core/5.4.0/mongodb-driver-core-5.4.0.jar
https://repo1.maven.org/maven2/org/mongodb/bson/5.4.0/bson-5.4.0.jar

## 3. using javac to compile the ConnectDBAndGetDataTest.java file

```sh
javac -cp ".:libs/mongodb-driver-core-5.4.0.jar:libs/mongodb-driver-sync-5.4.0.jar:libs/bson-5.4.0.jar"  ConnectDBAndGetDataTest.java
```

Or import all required dependencies from the libs directory

```sh
javac -cp libs/*:. ConnectDBAndGetDataTest.java
```

Expected Output: Generates ConnectDBAndGetDataTest.class

## 4. Run the TryGetCollectionA.class to test

```sh
java -cp libs/*:.  ConnectDBAndGetDataTest
```
