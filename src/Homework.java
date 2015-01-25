import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.QueryBuilder;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;



public class Homework {


  public static void main(String[] args) {
		MongoClient client = null;
		try {
			client = new MongoClient();
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
		
		Morphia morphia = new Morphia();
		morphia.map(Student.class).map(Score.class);
		Datastore ds = morphia.createDatastore(client, "school");
        Query <Student> students = ds.find(Student.class);
        for (Student s : students.fetch()) {
        	System.out.println(s.getName());
        	for ()
        }
		
		/*Query <Student> students = ds.createQuery(Student.class).field("scores.type").equal("homework");//filter("scores.type", "homework").order("scores");
        DBObject query = QueryBuilder.start("scores.type").is("homework").get();
        DBCursor cur = students.getCollection().find(query, new BasicDBObject("scores", true));
        while (cur.hasNext()) {
        	System.out.println(cur.next().toString());
        }
        */
		
		
		
		 

	}

}
