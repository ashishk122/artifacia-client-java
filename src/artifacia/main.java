/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artifacia; 

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author ashish
 */
public class main {
    public static void main(String[] args)throws Exception{ 
        JSONParser parser = new JSONParser();

        Object obj = parser.parse(new FileReader("/Users/unbreakable/snapshopr/sample_purchased_items.json"));
        JSONObject jsonObject = (JSONObject) obj;
//        System.out.println(jsonObject);
        
//	Artifacia a = new Artifacia("RzhTSlBVMTBsTEJ0a09XM25VUFJDUjhYdXhHRmZ0UW4=");
        Client client = new Client("S0pzaE9pRUcyb1lmRjZvc0w4dDIyV2k1UUNHZkpoRzQ=");
	client.upload_user_viewed_items(123, jsonObject);
	}
    
}
