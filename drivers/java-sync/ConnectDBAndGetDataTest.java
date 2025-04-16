import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.net.URLEncoder;
public class ConnectDBAndGetDataTest {
    public static void main(String [] args){
        try{
            String username = URLEncoder.encode("user1", "UTF-8");
            String password = URLEncoder.encode("pwduser1", "UTF-8");
            String host = "cluster0.xxxxx.mongodb.net:27017";
            
            String uri = "mongodb://" + username + ":" + password + "@" + host + "/?w=majority";
            // For a standard URI connection, use the prefix "mongodb://"
            //String uri = "mongodb://" + username + ":" + password + "@" + host + "/?w=majority";

            MongoClient mongoClient = MongoClients.create(uri);
    
            MongoDatabase database = mongoClient.getDatabase("local");
            MongoCollection<Document> collection = database.getCollection("startup_log");
            
            collection.find().forEach(doc -> System.out.println(doc.toJson()));
        } catch(Exception e){
            System.err.println(e);
        }
    }
}