import java.net.UnknownHostException;
import java.util.ArrayList;

import org.bson.types.BasicBSONList;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Homework {

	public static void main(String[] args) {
		MongoClient client = null;
		try {
			client = new MongoClient();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB db = client.getDB("school");
		DBCollection students = db.getCollection("students");
		long count = students.count();
		System.out.println(count);
		
		DBObject query = new BasicDBObject(); 
		DBCursor cursor = students.find(query);
		BasicDBList scores = new BasicDBList();
				
		try {
			while (cursor.hasNext()) {
			    DBObject student = cursor.next();
				System.out.println(student);
			}
		} finally {
			cursor.close();
		}
	}

}
