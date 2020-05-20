package ch02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ex_03 {
    final List<String> startsWithN = new ArrayList<>();

    public static void main(String[] args) {
        Ex_03 ex_03 = new Ex_03();

        for (String name : Friends.friends) {
            if (name.startsWith("N")) {
                ex_03.startsWithN.add(name);
            }
        }
        System.out.println(String.format("Found %d names", ex_03.startsWithN.size()));
        System.out.println("=====");

        // Cannot assign a value to final variable 'startsWithN'
//        ex_03.startsWithN = Friends.friends.stream()
//                .filter(name -> name.startsWith("N"))
//                .collect(Collectors.toList());
        final List<String> startsWithN = Friends.friends.stream()
                .filter(name -> name.startsWith("N"))
                .collect(Collectors.toList());
        System.out.println(String.format("Found %d names", startsWithN.size()));
    }
}
