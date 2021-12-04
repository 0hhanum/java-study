package MidtermStudy;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrList {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        CustomArrayList<String> arr = new CustomArrayList<>();

        for(int i=0; i<4;i++){
            System.out.print("이름을 입력하세요 >> ");
            String name = scanner.next();
            arr.add(name);
        }

        String longestName = arr.get(0);
        for(int i=0; i<arr.size(); i++){
            String name = arr.get(i);
            if (longestName.length() < name.length()) longestName = name;
            System.out.print(name + " ");
        }
        System.out.println();
        System.out.println("가장 긴 이름은 : " + longestName);

        scanner.close();
    }
}
class CustomArrayList<E>{
    private E[] arr;
    int size;
    public CustomArrayList(){
        arr =  (E[]) new Object[50];
        size = 0;
    }
    public E get(int i){
        return arr[i];
    }

    public int size(){
        return size;
    }

    public void add(E item){
        arr[size++] = item;
    }
}
