package biydaalt;
public class Lessons {
	public Subject learned; //үзсэн хичээл
    public int score;    	//шалгалтын тоо
    public Subject getLearn() {
        return learned;
    }

    public void setLearn(Subject learned) {
        this.learned = learned;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
