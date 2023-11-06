package com.hospital.core.service;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.osgi.service.component.annotations.Component;

@Component(service = AEMToMongoDB.class, name = "Aem to MongoDB")
public class AEMToMongoDB {
    public String writeDataToMongoDB() {
        // MongoDB connection settings
        String mongoHost = "localhost";
        int mongoPort = 27017;
        String mongoDatabaseName = "aem-author";
        String mongoCollectionName = "hospitaldetails";

        try (MongoClient mongoClient = new MongoClient(mongoHost, mongoPort)) {
            MongoDatabase mongoDatabase = mongoClient.getDatabase(mongoDatabaseName);
            MongoCollection<Document> collection = mongoDatabase.getCollection(mongoCollectionName);

            // Create a new document to insert into MongoDB
            Document document = new Document();
            document.append("key1", "value1");
            document.append("key2", "value2");
            // Add more fields as needed

            // Insert the document into the MongoDB collection
            collection.insertOne(document);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Data is inserted";
    }


}
