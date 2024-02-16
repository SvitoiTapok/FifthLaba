package MainClasses;

import InnerClasses.Person;
import enums.HairColor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(8);
        set.addAll(Stream.of(1).collect(Collectors.toSet()));
        System.out.println(set);
        long x = 456454564564L;
        for (int i = 0; i<12;i++) {
            Date data = new Date(456454564564L+ i * 2592000000L);
            System.out.println(data);
        }
        //System.out.println(HairColor.valueOf(null));
        Person person = new Person();
        person.setEyeColor(null);
        System.out.println(person);

    }
};
