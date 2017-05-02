package alg.string.sort;

import alg.util.ListU;

import java.util.List;

/**
 * Created by Yuhuan Jiang on 4/30/17.
 */
public class Test {
    
    static class Student {
        String name;
        int section;
        
        public Student(String name, int section) {
            this.name = name;
            this.section = section;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSection() {
            return section;
        }

        public void setSection(int section) {
            this.section = section;
        }
        
        @Override
        public String toString() {
            return name + " (" + section + ")"; 
        }
    }
    
    public static void main(String[] args) {
        
        List<Student> students = ListU.of(
                new Student("Anderson", 2),
                new Student("Brown",    3),
                new Student("Davis",    3),
                new Student("Garcia",   4),
                new Student("Harris",   1),
                new Student("Jackson",  3),
                new Student("Johnson",  4),
                new Student("Jones",    3),
                new Student("Martin",   1),
                new Student("Martinez", 2),
                new Student("Miller",   2),
                new Student("Moore",    1),
                new Student("Robinson", 2),
                new Student("Smith",    4),
                new Student("Taylor",   3),
                new Student("Thomas",   4),
                new Student("Thompson", 4),
                new Student("White",    2),
                new Student("Williams", 3),
                new Student("Wilson",   4)
        );
        
        List<Student> sorted = KeyIndexCounting.sort(students, Student::getSection);
        
        KeyIndexCounting.sortInplace(students, Student::getSection);
        
        int bp = 0;
    }
}
