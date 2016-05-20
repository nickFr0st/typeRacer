package com.treeCard;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Hello world!
 *
 */
public class ProgramDriver {
    public static void main(String[] args) {
        MongoClientURI clientUri = new MongoClientURI("mongodb://nick:Admin101@ds011943.mlab.com:11943/typeracer");
        MongoClient client = new MongoClient(clientUri);

        MongoDatabase db = client.getDatabase("typeracer");

        FindIterable<Document> iterable = db.getCollection("quote").find();

        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
            }
        });
    }
}
