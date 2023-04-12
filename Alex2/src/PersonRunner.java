
public class PersonRunner
{
    public static void main(String[] args)
    {
        String tn = "Thomas Edison";
        String tb = "Feburary 11,1847";
        String an = "Albert Einstein";
        String ab = "March 14, 1879";
        int g = 12;
        double gpa = 5.0;
        
        Person Te = new Person(tn,tb);
        System.out.println(Te.getName());
        System.out.println(Te.getBirthday());
        Student ae = new Student(an,ab,g,gpa);
        System.out.println(ae.getName());
        System.out.println(ae.getBirthday());
        System.out.println(ae.getGrade());
        System.out.println(ae.getGpa());
    }
}