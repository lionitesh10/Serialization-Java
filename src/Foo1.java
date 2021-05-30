import java.io.*;

public class Foo1 implements Serializable {
    private static final long serialVersionUID=1L;
    private int x;
    private String s;
    public Foo1(){
        this(100,"Hello World");
    }
    public Foo1(int x,String s){
        this.x=x;
        this.s=s;
    }
    public String toString(){
        return s+" "+x;
    }

    public static void main(String[] args) {

        try{
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("foo.bin"));
            Foo1 f1=new Foo1();
            Foo1 f2=new Foo1(99,"JavaLoons");
            o.writeObject(f1);
            o.writeObject(f2);
            o.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        getFooObjects();
    }
    static void getFooObjects(){
        try{
            ObjectInputStream o=new ObjectInputStream(new FileInputStream("foo.bin"));
            Foo1 f1=(Foo1)o.readObject();
            Foo1 f2=(Foo1) o.readObject();
            System.out.println(f1);
            System.out.println(f2);
            o.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
