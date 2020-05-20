package ch02;

import java.util.ArrayList;
import java.util.List;

public class Ex_02 {
    final List<String> uppercaseNames = new ArrayList<>();

    public static void main(String[] args) {
        Ex_02 ex_02 = new Ex_02();

        for (String name : Friends.friends) {
            ex_02.uppercaseNames.add(name.toUpperCase());
        }
        System.out.println(ex_02.uppercaseNames);
        ex_02.uppercaseNames.clear();      // 컬렉션 아닌 원소에 대한 작업이라 가능
        // ex_02.uppercaseNames = null;    // Cannot assign a value to final variable 'uppercaseNames'
        System.out.println("리스트 비어있는지?: " + ex_02.uppercaseNames.isEmpty());

        System.out.println("=====");

        Friends.friends.forEach(name -> ex_02.uppercaseNames.add(name.toUpperCase()));
        System.out.println(ex_02.uppercaseNames);
        ex_02.uppercaseNames.clear();

        System.out.println("=====");
        Friends.friends.stream()
                .map(name -> name.toUpperCase())
                .forEach(name -> System.out.print(name + ", "));

        System.out.println();
        System.out.println("=====");
        Friends.friends.stream()
                .map(name -> name.length())
                .forEach(count -> System.out.print(count + ", "));

        System.out.println();
        System.out.println("=====");
        Friends.friends.stream()
                .map(String::toUpperCase)
                .forEach(name -> System.out.print(name + ", "));
    }
}
