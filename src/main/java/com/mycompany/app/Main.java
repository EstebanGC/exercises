package com.mycompany.app;

import com.mycompany.app.model.Person;
import com.mycompany.app.model.Product;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    }

    private static int getAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public static void printList(List<?> list) {
        list.forEach(System.out::println);
    }
}