package com.mycompany.app;

import com.mycompany.app.model.Person;
import com.mycompany.app.model.Product;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Person p1 = new Person(1, "Mito", LocalDate.of(1991, 1, 21));
        Person p2 = new Person(2, "Code", LocalDate.of(1990, 2, 21));
        Person p3 = new Person(3, "Jaime", LocalDate.of(1980, 6, 23));
        Person p4 = new Person(4, "Duke", LocalDate.of(2019, 5, 15));
        Person p5 = new Person(5, "James", LocalDate.of(2010, 1, 4));

        Product pr1 = new Product(1, "Ceviche", 15.0);
        Product pr2 = new Product(2, "Chilaquiles", 25.50);
        Product pr3 = new Product(3, "Bandeja Paisa", 35.50);
        Product pr4 = new Product(4, "Ceviche", 15.0);

        List<Person> persons = Arrays.asList(p1, p2, p3, p4, p5);
        List<Product> products = Arrays.asList(pr1, pr2, pr3, pr4);

        //forEach and reference methods
//        persons.forEach(System.out::println);

        //1.Filter(param:predicate)
        List<Person> filteredList = persons.stream()
                                        .filter(p -> Main.getAge(p.getBirthDate()) >= 18)
                                        .collect(Collectors.toList());

        Main.printList(filteredList);

        //Sorting by birthday
        Comparator<Person> byNameAsc = (Person o1, Person o2) -> o1.getName().compareTo(o2.getName());
        Comparator<Person>  byNameDesc = (Person o1, Person o2) -> o2.getName().compareTo(o2.getName());
        Comparator<Person> byBirthday = (Person o1, Person o2) -> o1.getBirthDate().compareTo(o2.getBirthDate());

        List<Person> filteredList1 = persons.stream()
                .sorted(byBirthday)
                .collect(Collectors.toList());

        Main.printList(filteredList1);

        //Matching names with "J" (param: predicate)
        Predicate<Person> startsWithPredicate = person -> person.getName().startsWith("J");

        //Evaluate the existence of an element inside a set.
        boolean ans0 = persons.stream()
                .anyMatch(startsWithPredicate);

        boolean ans1 = persons.stream()
                            .allMatch(startsWithPredicate);

        boolean ans2 = persons.stream()
                            .noneMatch(startsWithPredicate);

        //5-limit/Skip
        int pageNum = 1;
        int pageSize = 2;
        List<Person> filteredList2 = persons.stream()
                .skip(pageNum*pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());

        Main.printList(filteredList2);
        Map<String, List<Product>> collect1 = products.stream()
                .filter(p -> p.getPrice() >20)
                .collect(Collectors.groupingBy(Product::getName));

        Map<String, Long>  collect2 = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getName, Collectors.counting()
                ));

        Map<String, Double>  collect3 = products.stream().collect(Collectors.groupingBy(
                        Product::getName,
                        Collectors.summingDouble(Product::getPrice)
                ));

        DoubleSummaryStatistics statistics = products.stream()
                .collect(Collectors.summarizingDouble(Product::getPrice));


        Optional<Double> sum = products.stream()
                .map(Product::getPrice)
                .reduce(Double::sum);

        System.out.println(sum.get());
    }

    private static int getAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public static void printList(List<?> list) {
        list.forEach(System.out::println);
    }
}