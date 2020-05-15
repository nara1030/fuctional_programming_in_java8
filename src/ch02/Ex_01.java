package ch02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Ex_01 {
    public static void main(String[] args) {
        for (int i = 0; i < Friends.friends.size(); i++) {
            System.out.println(Friends.friends.get(i));
        }

        for (String name : Friends.friends) {
            System.out.println(name);
        }

        System.out.println("//" + "START:INTERNAL_FOR_EACH_OUTPUT");

        Friends.friends.forEach(new Consumer<String>() {
            @Override
            public void accept(final String name) {
                System.out.println(name);
            }
        });

        System.out.println("//" + "END:INTERNAL_FOR_EACH_OUTPUT");

        System.out.println("//" + "START:INTERNAL_OUTPUT");
        Friends.friends.forEach((final String name) -> System.out.println(name));
        System.out.println("//" + "End:INTERNAL_OUTPUT");

        Friends.friends.forEach((name) -> System.out.println(name));
        Friends.friends.forEach(name -> System.out.println(name));
        Friends.friends.forEach(System.out::println);
    }
}

class Friends {
    static final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
}