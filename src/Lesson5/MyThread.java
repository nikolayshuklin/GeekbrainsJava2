package Lesson5;

import javax.swing.table.TableRowSorter;
import java.util.SimpleTimeZone;

public class MyThread extends Thread{
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    float [] arr;
    public MyThread(float [] arr){
        this.arr = arr;
    }

    @Override
    public void run() {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            ;
        }
//        try {
//            this.join();
//        } catch (InterruptedException e){
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {
        metod1();
        metod2();
    }

    private static void metod1() {
        float[] arr = new float[SIZE];
        for(int i = 0; i< SIZE; i++){
            arr[i]=1;
        }
        long a = System.currentTimeMillis();
        Thread thread1 = new MyThread(arr);
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long b = System.currentTimeMillis();
        System.out.println(b-a);
    }

    private static void metod2() {
        float[] arr = new float[SIZE];
        for(int i = 0; i<arr.length; i++){
            arr[i]=1;
        }
        long a = System.currentTimeMillis();
        float [] arr1 = new float[HALF];
        float [] arr2 = new float[HALF];
        System.arraycopy(arr,0,arr1,0,HALF);
        System.arraycopy(arr,HALF,arr2,0,HALF);
        Thread thread2 = new MyThread(arr1);
        Thread thread3 = new MyThread(arr2);
        thread2.start();
        thread3.start();
        try {
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1,0, arr, 0, HALF);
        System.arraycopy(arr2,0, arr, HALF, HALF);
        long b = System.currentTimeMillis();
        System.out.println(b-a);

    }

}
