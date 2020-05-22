package ch02;

import java.util.function.Function;
import java.util.function.Predicate;

public class Ex_05 {
    public static void main(String[] args) {
        final Predicate<String> startsWithN = name -> name.startsWith("N");
        final Predicate<String> startsWithB = name -> name.startsWith("B");

        final long countFriendsStartN1 = Friends.friends.stream()
                .filter(startsWithN)
                .count();

        final long countFriendsStartB1 = Friends.friends.stream()
                .filter(startsWithB)
                .count();

        System.out.println("N1: " + countFriendsStartN1);
        System.out.println("B1: " + countFriendsStartB1);

        // Refactoring 1
        final long countFriendsStartN2 = Friends.friends.stream()
                .filter(checkIfStartsWith("N"))
                .count();

        final long countFriendsStartB2 = Friends.friends.stream()
                .filter(checkIfStartsWith("B"))
                .count();

        System.out.println("N2: " + countFriendsStartN2);
        System.out.println("B2: " + countFriendsStartB2);

        // Refactoring 2
        final Function<String, Predicate<String>> startsWithLetter1 = (String letter) -> {
            Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
            return checkStarts;
        };

        // Refactoring 3
        final Function<String, Predicate<String>> startsWithLetter2 =
                letter -> name -> name.startsWith(letter);

        final long countFriendsStartN3 = Friends.friends.stream()
                .filter(startsWithLetter2.apply("N"))
                .count();

        final long countFriendsStartB3 = Friends.friends.stream()
                .filter(startsWithLetter2.apply("B"))
                .count();

        System.out.println("N3: " + countFriendsStartN3);
        System.out.println("B3: " + countFriendsStartB3);
    }

    public static Predicate<String> checkIfStartsWith(final String letter) {
        return name -> name.startsWith(letter);
    }
}
