package Lesson3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

 public class Spravochnik {
     public static HashMap<String, String> map = new HashMap<>();
     public static void main(String[] args) {
        map.put("+79031234567", "Иванов");
        map.put("+79031235437", "Сидоров");
        map.put("+79053764567", "Петров");
        map.put("+79079834567", "Малышев");
        map.put("+79030098767", "Новосельцев");
        map.put("+79161243567", "Уткин");
        map.put("+77777777777", "Путин");
        map.put("+79131236547", "Медведев");
        map.put("+79631235467", "Кабаева");
        map.put("+79630000567", "Мишустин");
        map.put("+79831234567", "Иванов");
        map.put("+79931234567", "Новосельцев");


        TreeSet<String> uniqum = new TreeSet<>();
        for (Map.Entry<String, String> entry : map.entrySet()){
            uniqum.add(entry.getValue());
        }

        for (String a: uniqum){
           int kolvo = 0;
            for (Map.Entry<String, String> entry : map.entrySet()){
                if(entry.getValue().equals(a)) kolvo++;
            }
            System.out.println("Слово " + a + " встречается " + kolvo + " раз.");
        }

        add("+79991234391", "Добавленов");
        get("Новосельцев");
        get("Путин");
        get("Петров");
        get("Непонятнова");


    }

    public static void add(String number, String family){
         map.put(number,family);
    }

    public static void get(String family) {
         int count = 0;
         for (Map.Entry<String, String> entry: map.entrySet()){
             if (family.equals(entry.getValue())) {
                 count++;
                 System.out.println(family + " телефон " + count +": " + entry.getKey());
             }
         }
         if (count == 0) System.out.println(" Фамилии " + family + " в телефонном справочнике нет");
    }

}
