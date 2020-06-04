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
        new MyThread(arr).start();
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
        new MyThread(arr1).start();
        new MyThread(arr2).start();
        System.arraycopy(arr1,0, arr, 0, HALF);
        System.arraycopy(arr2,0, arr, HALF, HALF);
        float b = System.currentTimeMillis();
        System.out.println(b-a);

    }

}
