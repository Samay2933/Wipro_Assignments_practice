import java.io.*;

class Student implements Serializable {
    public int rollno;
    public String name;
}
public class DeserializationDemo {
    public static void main(String[] args) {
        

        String fileName = "D:\\work\\VS code projects\\File Handling\\Serializable\\register.txt";

        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            Student obj = (Student) ois.readObject();
            System.out.println(obj.rollno);
            System.out.println(obj.name);

            ois.close();
            fis.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    
}
