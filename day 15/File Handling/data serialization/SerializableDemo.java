import java.io.*;

class Student implements Serializable{
    public int rollno;
    public String name;
}

public class SerializableDemo {
    public static void main(String[] args) {
        
        Student s1 = new Student(); //calling an object
        s1.rollno = 1;
        s1.name = "Phantoos";

        String fileName = "D:\\work\\VS code projects\\File Handling\\Serializable\\register.txt";

        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s1);

            oos.close();
            fos.close();

            System.out.println("Object saved in file");


        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
