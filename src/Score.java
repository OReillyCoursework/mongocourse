import org.mongodb.morphia.annotations.Embedded;


@Embedded
public class Score {
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

