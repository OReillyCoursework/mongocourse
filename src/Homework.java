import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.BasicBSONList;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.query.Query;

@Entity (value = "students", noClassnameStored = true)
class Student {
	
	@Id private int id;
	private String name;
	private List<Score> scores;
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

@Embedded
class Score {
	private String type;
	private long score;
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public long getScore() {
		return score;
	}
	
	public void setScore(long score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return type + ": " + score;
	}
}

public class Homework {


Student removeLowestHomeWorkScore(Student student) {
     // check only homework scores returned
     if (student.scores.length > 1) throw Exception;
       
        
    }
}
	
  public static void main(String[] args) {
		MongoClient client = null;
		try {
			client = new MongoClient();
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
		
		Morphia morphia = new Morphia();
		morphia.map(Student.class);
		Datastore ds = morphia.createDatastore(client, "school");
		
		Query<Student> query = ds.createQuery(Student.class);
		Student student = query.get();
		System.out.println(student.getName());

	}

}
