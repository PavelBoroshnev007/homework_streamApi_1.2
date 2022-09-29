import java.util.*;
import java.util.stream.Collectors;

public class Man {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long count = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println(count);

        List<String> familys = persons.stream()
                .filter(person -> person.getAge() >= 18 && person.getAge() <= 27)
                .map(person -> (String) person.getFamily())
                .collect(Collectors.toList());
        //System.out.println(familys);

        List<Person> workablePersons = persons.stream()
                .filter(person -> person.getAge() >= 18 && person.getAge() <= 60 && person.getSex() == Sex.WOMAN)
                .filter(person -> person.getAge() >= 18 && person.getAge() <= 65 && person.getSex() == Sex.MAN)
                .filter(person -> person.getEducation() == Education.HIGHER)
                .sorted(Comparator.comparing(person -> person.getFamily()))
                .collect(Collectors.toList());
        //System.out.println(workablePersons);


    }
}
