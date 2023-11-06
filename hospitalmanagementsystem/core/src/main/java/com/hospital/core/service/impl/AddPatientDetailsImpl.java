package com.hospital.core.service.impl;


import com.hospital.core.service.AddPatientDetails;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = AddPatientDetails.class, name = "Patient Details Service")
public class AddPatientDetailsImpl implements AddPatientDetails {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public String addPatientDetails(String patientName, String patientId, String assignedRoomNumber) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("aem-author");
        MongoCollection<Document> collection = mongoDatabase.getCollection("patient-details");
        Document document = new Document();
        document.append("patientname" , patientName);
        document.append("patientID" , patientId);
        document.append("assgnedroomnumber" , assignedRoomNumber);
        collection.insertOne(document);

        return "Patient Details are added";
    }
}
