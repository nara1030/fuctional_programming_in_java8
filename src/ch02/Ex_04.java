package ch02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Ex_04 {
    public static void main(String[] args) {
        final long countFriendsStartN = Friends.friends.stream()
                .filter((final String name) -> name.startsWith("N"))
                .count();

        final long countEditorsStartN = new Editors().editors.stream()
                .filter((final String name) -> name.startsWith("N"))
                .count();

        final long countComradesStartN = new Comrades().comrades.stream()
                .filter((final String name) -> name.startsWith("N"))
                .count();

        // Refactoring: ↓
        final Predicate<String> startsWithN = (final String name) -> name.startsWith("N");
        final long recountFriendsStartN = Friends.friends.stream()
                .filter(startsWithN)
                .count();

        final long recountEditorsStartN = new Editors().editors.stream()
                .filter(startsWithN)
                .count();

        final long recountComradesStartN = new Comrades().comrades.stream()
                .filter(startsWithN)
                .count();
    }
}

class Editors {
    final List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");
}

final class Comrades {
    final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
}