package biydaalt;
import dataStructures.ArrayLinearList;
public class Registration {
	public ArrayLinearList studentList = new ArrayLinearList();
    public ArrayLinearList subjectList = new ArrayLinearList();
    public ArrayLinearList majorList = new ArrayLinearList();
    public void setSub(String[] elements, int index) {
        Subject subject = new Subject();
        subject.setCode(elements[0]);
        subject.setName(elements[1]);
        subject.setCre((Float.parseFloat(elements[2])));
        subjectList.add(index, subject);
    }
    public Subject getSub(int index) {
        return (Subject) subjectList.get(index);
    }
    public void setMaj(String[] elements, int index) {
        Major major = new Major();
        major.setCode(elements[0]);
        major.setName(elements[1]);
        majorList.add(index, major);
    }
    public Major getMaj(int index) {
        return (Major) majorList.get(index);
    }
    public void setStu(String[] elements, int index) {
        Student student = new Student();
        student.setCode(elements[0]);
        student.setMaj(elements[3]);
        Subject subject = new Subject();
        subject.setCode(elements[1]);
        Lessons tmpLessons = new Lessons();
        tmpLessons.setLearn(subject);
        tmpLessons.setScore((Integer.parseInt(elements[2])));
        student.setLes(tmpLessons);
        studentList.add(index, student);
    }
    public Student getStu(int index) {
        return (Student) studentList.get(index);
    }
}
