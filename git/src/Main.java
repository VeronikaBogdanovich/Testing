// First commit develop
public class Main {
    public static void main(String[] args) {
        int[] marks1 = {1,2,3,4};
        int[] marks2 = {5,6,7};
        int[] marksBest = {9,7,8};

        // ---------------------------------------

        Student student4 = new Student("ann", "bola");
        student4.addMarks(marks1);
        System.out.println("Среднее первого студента: " + student4.getAVG());

        Student student1 = new Student("cia", "dia");
        student1.addMarks(marks2);
        System.out.println("Среднее второго студента: " + student1.getAVG());

        Student student2 = new Student("emma", "forse");
        student2.addMarks(marksBest);
        System.out.println("Среднее третьего студента: " + student2.getAVG());


        Group group = new Group();

        group.addStudent(student4);
        group.addStudent(student1);
        group.addStudent(student2);

        System.out.println(student4.toString());
        System.out.println(student1.toString());
        System.out.println(student2.toString());

        System.out.println("Средняя по группе: " + group.getAVG());
    }
}
