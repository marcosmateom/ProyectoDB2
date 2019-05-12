/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.seguros;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author migue
 */
public class getHospIp {
    public static String getIP(int hospNum){
        MongoCollection<Document> coll = collHospIp();
        Document ipDoc;
        ipDoc = coll.find(new BasicDBObject("_id", hospNum)).first();
        String res = ipDoc.getString("ip");
        return res;
    }
    public static MongoCollection collHospIp(){
        String db_name = "SegurosGio", db_col_name = "HospitalesIp";
        MongoClient conn = gio.co.seguros.MongoConnectDB.connectMongo();
        MongoDatabase db = conn.getDatabase(db_name);
        MongoCollection<Document> coll = db.getCollection(db_col_name);
        return coll;
    }
}
