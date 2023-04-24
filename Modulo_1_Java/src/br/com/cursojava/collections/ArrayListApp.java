package br.com.cursojava.collections;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayListApp {
    public static void main(String[] args) {
        exercicioEmployee();
    }

    public static void exercicioEmployee(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Jane", 29));
        list.add(new Employee("Alex", 54));
        list.add(new Employee("Matt", 19));
        list.add(new Employee("Roy", 72));

        System.out.printf("ArrayList inicial is: %s\n", list);
        Collections.sort(list);
        System.out.printf("ArrayList inicial is: %s\n", list);
        list.sort(Collections.reverseOrder());
        System.out.printf("ArrayList inicial is: %s\n", list);

        Spliterator<Employee> spliterator = list.spliterator();
    }
    public static void exemplos(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        list.add(4);
        System.out.println(list);

        list.add(1, 50);
        System.out.println(list);

        List<Integer> newList = new ArrayList<>();
        newList.add(150);
        newList.add(160);

        list.replaceAll(c -> c * Double.valueOf(Math.PI).intValue());
        list.set(0, list.get(0) * 200);
//        System.out.println(list);
//        System.out.println(list.contains(12));
//        System.out.println(list.contains(120));
//
//        for (int i=0; i < list.size(); i++)
//            System.out.print(list.get(i));
//
//        for (Integer i: list) {
//            System.out.print(i);
//        }

        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        System.out.println(list);
        System.out.println(collect);

        Collections.sort(list);

        Integer integer = list.get(1);
        integer++;
        System.out.println(list);
        System.out.println(collect);
    }
}