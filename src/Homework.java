import java.net.UnknownHostException;
import com.mongodb.MongoClient;

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
		
		
		//Query<Student> query = ds.find(Student.class);
		//for (Student s : query.fetch()) {
		    
			//System.out.println(s.getScores());
		//}

	}

}
