package OPP;

public class Main {
    public static void main(String[] args) {
        int[] roll =new int[5];
        String[] name=new String[5];
        float[] marks=new float[5];

        Student students=new Student();
        Student neww=new Student(128,"Madhur",9.44f);

//        students.name="Madhur Rastogi";
//        students.roll=128;
//        students.marks= 9.54f;
//        students.bool=true;
        students.greeting();
        System.out.println(students.bool);
        System.out.println(students.marks);
        System.out.println(students.roll);
        System.out.println(students.name);
        System.out.println(" ");
        System.out.println(" ");



        System.out.println(neww.marks);
        System.out.println(neww.roll);
        System.out.println(neww.name);

        Student random=new Student(students);

        Student another=new Student();
        System.out.println(another.name);


//        for(int i=0;i<10000000;i++)
//        {
//            A dest=new A();
//        }

        A obj=new A("hchsdc");
        System.out.println(obj);
    }

}
class Student
{
    // global variables
    int roll;
    String name;
    float marks=9.68f;      // overriding
    boolean bool;
    // 2 constructors of same name with different args--> Constructor overloading;
    // without args
//    Student(){
//        this.name="Madhur Rastogi";
//        this.roll=128;
//        this.marks= 9.54f;
//        this.bool=true;
//    }
    Student() {
        this(14,"defalut",10);
    }

    // Student one=new Student (128,"Madhur",85.6);
    // here, this will be replaced by one;
    Student(int roll, String name, float marks){
        this.roll=roll;
        this.name=name;
        this.marks=marks;
    }

    //
    Student (Student other)
    {
        this.marks=other.marks;
        this.name=other.name;
        this.roll=other.roll;
    }

    void greeting()
    {
        System.out.println("Hello! My name is "+this.name);
    }

}
class A
{
    String name;
    final int num=0;

    public A(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is destroyed");
    }
}
