package biydaalt;
import java.io.*;
import dataStructures.Chain;
public class Main {
        public static void main(String[] args) throws IOException {
        Registration registration = new Registration();
        try {
            BufferedReader input = new BufferedReader(new FileReader("src/biydaalt/Subject.txt"));
            String line;
            int index = 0;
            while ((line = input.readLine()) != null) {
                String values[] = line.split("/");
                registration.setSub(values, index);
                index++;
            }
            System.out.println("Хичээлүүдийн жагсаалт: ");
            for (int i = 0; i < index; i++) {
                System.out.println(registration.getSub(i).getCode()+" "+registration.getSub(i).getName()+" "+registration.getSub(i).getCre());
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File олдсонгүй: " + "subject");
            System.exit(1);
        }
        try {
            BufferedReader input = new BufferedReader(new FileReader("src/biydaalt/Professions.txt"));
            String line;
            int index = 0;
            while ((line = input.readLine()) != null) {
                String values[] = line.split("/");
                registration.setMaj(values, index);
                index++;
            }
            System.out.println(" Нийт мэргэжилийн жягсаалт: ");
            for (int i = 0; i < index; i++) {
                System.out.println(registration.getMaj(i).getCode()+" "+registration.getMaj(i).getName());
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File олдсонгүй: " + "Professions");
            System.exit(1);
        }
        try {
            BufferedReader input = new BufferedReader(new FileReader("src/biydaalt/Exams.txt"));
            String line;
            int index = 0;
            while ((line = input.readLine()) != null ) {
                String values[] = line.split("/");
                registration.setStu(values, index);
                index++;
            }
            System.out.println("Оюутнуудын голч дүн: ");
            float sum = 0;
            for (int i = 0; i < index; i++) {
                sum += registration.getStu(i).getGPA();
                System.out.println(registration.getStu(i).getCode()+" "+registration.getStu(i).getGPA());
            }
            System.out.println("Нийт оюутнуудын дундаж голч: " + sum / index);
            System.out.println("3-аас дээш F үнэлгээ авсан хасагдах оюутан: ");
            for (int i = 0; i < index; i++) {
                if (registration.getStu(i).getGPA() < 0.7) {
                    System.out.println(registration.getStu(i).getCode());
                }
            }
            System.out.println("Хичээл бүрээр оюутны дүнг харуулах: ");
            for (int i = 0; i < index; i++) {
                System.out.print(registration.getStu(i).getCode() + " : ");
                Chain tmpchain = registration.getStu(i).getLes();
                for (int j = 0; j < registration.getStu(i).getLes().size(); j++) {
                    Lessons tmpLessons = (Lessons) tmpchain.get(j);
                    System.out.println(tmpLessons.getLearn().getCode() + " " + tmpLessons.getScore());
                }
            }
            System.out.println("Мэргэжил бүрээр оюутны дүнг харуулах: ");
            for (int i = 0; i < index; i++) {
                System.out.print(registration.getStu(i).getMaj() + " : ");
                Chain tmpchain = registration.getStu(i).getLes();
                for (int j = 0; j < registration.getStu(i).getLes().size(); j++) {
                    Lessons tmpLessons = (Lessons) tmpchain.get(j);
                    System.out.println(registration.getStu(i).getCode()+" "+tmpLessons.getLearn().getCode() + " " + tmpLessons.getScore());
                }
            }
            input.close();
            } catch (FileNotFoundException e) {
                     System.out.println("File oldsongui: " + "Professions");
            System.exit(1);
            }
            } 
}
