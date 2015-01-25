import java.util.List;


import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;


@Entity (value = "students", noClassnameStored = true)
public class Student {
	
	
		
		@Id private int id;
		private String name;
		
		private List<Score> scores;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<Score> getScores() {
			return scores;
		}
		public void setScores(List<Score> scores) {
			this.scores = scores;
		}
		
      
	  
	  
	


	
}
