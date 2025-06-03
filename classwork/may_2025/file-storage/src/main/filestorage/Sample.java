package filestorage;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Sample {
    public static void main(String[] args) {
        System.out.println(IntStream.rangeClosed(0, 10).sum());
//        difference between stream and for loop

        List<Integer> number = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Comparator<Integer> comparable = (first, second) -> {
            if (first > second) return -1;
            else if (first < second) return 1;
            else return 0;
        };

        List<Integer> evenNumber = number
                .stream()
                .filter(n -> n % 2 == 0)
                .sorted(comparable)
                .toList();
        System.out.println(evenNumber);

        User user = new User();
        user.setEmail("gloria@gmail.com");
        user.setFirstName("Gloria");
        user.setLastName("Oyewusi");
        user.setPassword("123456");

        User user2 = new User();
        user2.setEmail("bimbo@gmail.com");
        user2.setFirstName("Bimbo");
        user2.setLastName("Santino");
        user2.setPassword("123456");


        List<User> users = List.of(user, user2);
        List<String> stringUsers = users
                .stream()
                .map(User::getEmail)
                .toList();

        List<UserDto> stringUser2 = users
                .stream()
                .sorted((first, second) -> {
                    if (first.getEmail().length() > second.getEmail().length()) return 1;
                    else if (first.getEmail().length() < second.getEmail().length()) return -1;
                    else return 0;
                })
                .map(UserDto::new)
                .toList();
        System.out.println(stringUser2);
    }

//reduce
//compare
//    collect
//    forEach
//    range
//map
//    rangeClosed
}

//comperator are abstract method
