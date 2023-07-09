package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, ArrayList<String>> telbook = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Добро пожаловать в справочник!");
            System.out.println("Введите имя контакта: ");
            String name = scanner.nextLine().toLowerCase();
            System.out.println("Введите номер контакта: ");
            String phone = scanner.nextLine();
            if(!telbook.containsKey(name)){
                ArrayList<String> phones = new ArrayList<>();
                phones.add(phone);
                telbook.put(name, phones);
                System.out.println("Контакт успешно добавлен!");
            }
            else {
                ArrayList<String> addnum = telbook.get(name);
                addnum.add(phone);
                telbook.put(name, addnum);
                System.out.println("Номер успешно добавлен!");
            }
            System.out.println("Добавить ещё? да/нет: ");
            String choice = scanner.nextLine();
            if (choice.toLowerCase().equals("нет")){
                break;
            }
        }
        System.out.println("Показать контакты? да/нет: ");
        String choice = scanner.nextLine();
        if (choice.toLowerCase().equals("да")){
            telbook
                    .entrySet()
                    .stream()
                    .sorted(Map
                            .Entry
                            .comparingByValue(new Comparator<ArrayList<String>>() {
                @Override
                public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                    return o2.size() - o1.size();
                }
            })).forEach(System.out::println);
        }
        else {
            System.out.println("До свидания!");
        }


    }
}