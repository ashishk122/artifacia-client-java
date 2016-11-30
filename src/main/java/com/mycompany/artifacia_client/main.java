/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.artifacia_client; 

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author ashish
 */
public class main {
    public static void main(String[] args)throws Exception{ 
//        JSONParser parser = new JSONParser();
        File jsonInputFile = new File("/Users/unbreakable/snapshopr/sample_purchased_items.json");
        InputStream is;
        is = new FileInputStream(jsonInputFile);
        JsonReader reader = Json.createReader(is);
        JsonObject empObj = reader.readObject();
//        Object obj = parser.parse(new FileReader("/Users/unbreakable/snapshopr/sample_purchased_items.json"));
//         JSONObject jsonObject = (JSONObject) obj;
//        System.out.println(jsonObject);
        System.out.println(empObj);
//	Artifacia a = new Artifacia("RzhTSlBVMTBsTEJ0a09XM25VUFJDUjhYdXhHRmZ0UW4=");
        Client client = new Client("RzhTSlBVMTBsTEJ0a09XM25VUFJDUjhYdXhHRmZ0UW4=");
	client.visual_recommendation("20160620173921_67027", 5);
	}
    
}
