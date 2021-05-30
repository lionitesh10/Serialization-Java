import java.io.*;

public class Foo {
    public static void main(String[] args) {
        getBinaryDataFiles();
//        try{
//            ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("numbers.bin"));
//            for(int i=0;i<10;i++){
//                o.writeInt(i);
//            }
//            o.writeDouble(655565);
//            o.writeDouble(1);
//            o.writeFloat(2);
//            o.writeChar('A');
//            o.writeUTF("Hello World");
//            o.close();
//        }catch (IOException e){
//            System.out.println(e.getMessage());
//        }
    }
    static void getBinaryDataFiles(){
        try{
            ObjectInputStream o=new ObjectInputStream(new FileInputStream("numbers.bin"));
            for(int i=0;i<10;i++){
                int num;
                num=o.readInt();
                System.out.println("Read : "+num);
            }
            long l=o.readLong();
            System.out.println(l);
            Double d=o.readDouble();
            System.out.println(d);
            Float f=o.readFloat();
            System.out.println(f);
            char c= o.readChar();
            System.out.println(c);
            String s=o.readUTF();
            System.out.println(s);
            int noInt=o.readInt();
            o.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
