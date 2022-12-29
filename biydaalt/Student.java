package biydaalt;
import dataStructures.Chain;
public class Student { 					//Оюутан
    public String code; 				//код
    public float gpa;       			//голч дүн
    public Chain lessons = new Chain(); // үзсэн хичээлүүд
    public Major major = new Major(); 
	public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public float getGPA() {
        float sum = 0;
        for (int i = 0; i < lessons.size(); i++) {
            sum += pointToFloat(((Lessons) lessons.get(i)).getScore());
        }
        gpa = sum / lessons.size();
        return gpa;
    }
    public float pointToFloat(float point) {
        float gpa = 3;
        if (point >= 96 && point <= 100)
            gpa = (float) 4.0;
        else if (point >= 91 && point < 95)
            gpa = (float) 3.7;
        else if (point >= 88 && point < 90)
            gpa = (float) 3.4;
        else if (point >= 84 && point < 87)
            gpa = (float) 3.0;
        else if (point >= 81 && point < 83)
            gpa = (float) 2.7;
        else if (point >= 78 && point < 80)
            gpa = (float) 2.4;
        else if (point >= 74 && point < 77)
            gpa = (float) 2.0;
        else if (point >= 71 && point < 73)
            gpa = (float) 1.7;
        else if (point >= 68 && point < 70)
            gpa = (float) 1.3;
        else if (point >= 64 && point < 67)
            gpa = (float) 1.0;
        else if (point >= 60 && point < 63)
            gpa = (float) 0.7;
        else if (point >= 0 && point < 59)
            gpa = (float) 0.0;
        return gpa;
    }
    public Chain getLes() {
        return this.lessons;
    }
    public void setLes(Lessons lesson) {
    	lessons.add(lessons.size(), lesson);
    }
     public void setMaj(String major) {
         this.major.setName(major);
     }
     public String getMaj() {
         return this.major.getName();
    }
}
