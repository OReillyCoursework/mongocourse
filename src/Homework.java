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
import com.mongodb.MongoClient;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.query.Query;

@Entity
class Student {
	
	@Id private ObjectId id;
	private String name;
	
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
	public Score getScores() {
		return scores;
	}
	public void setScores(Score scores) {
		this.scores = scores;
	}
	private Score scores;
	
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
		
		Morphia morphia = new Morphia();
		morphia.map(Student.class).map(Score.class);
		Datastore ds = morphia.createDatastore(client, "school");
		
		Query query = ds.createQuery(Score.class).filter("type", "homework");
		Score score = (Score) query.get();
		System.out.println(score);
		
		
		
	}

}
