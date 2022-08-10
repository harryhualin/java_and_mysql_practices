package day4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
class Person {
    public String name;
    public int age;
    public Person(String name,int age){this.name=name;this.age=age;}
}

public class PersonStream {
    public static void main(String[] args){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("tarun", 28));
        personList.add(new Person("arun", 29));
        personList.add(new Person("varun", 12));
        personList.add(new Person("arun", 22));
        personList.add(new Person("Jrun", 25));
        personList.add(new Person("J45un", 22));
        personList.add(new Person("J45465arun", 20));
        List<Person> newList=personList.stream().filter((a)->a.name.startsWith("J")).
                sorted(new Comparator<Person>() {
          @Override
          public int compare(Person o1, Person o2) {
              return o2.age- o1.age;
          }
      }).toList();

     newList.stream().forEach(x->System.out.println(x.name+" "+x.age));

    }

}
