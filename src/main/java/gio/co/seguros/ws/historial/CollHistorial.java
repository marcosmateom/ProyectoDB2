/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.seguros.ws.historial;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author C.V
 */
public class CollHistorial {
    public static MongoCollection collHistorial(){
        String db_name = "SegurosGio", db_col_name = "Historiales";
        MongoClient conn = gio.co.seguros.MongoConnectDB.connectMongo();
        MongoDatabase db = conn.getDatabase(db_name);
        MongoCollection<Document> coll = db.getCollection(db_col_name);
        return coll;
    }
    
}


