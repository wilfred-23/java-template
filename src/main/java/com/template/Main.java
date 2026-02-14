package com.template;

import java.util.Random;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] sizes = {10, 100, 500, 1000, 2000, 3000};

        for (int size : sizes) {

            System.out.println("Tamaño: " + size);

            Integer[] data = generateRandomArray(size);

            // ==========================
            // CASO 1: DESORDENADO
            // ==========================
            System.out.println("---- DESORDENADO ----");
            ejecutarSorts(data.clone());

            // ==========================
            // CASO 2: ORDENADO
            // ==========================
            System.out.println("---- ORDENADO ----");

            Integer[] ordered = data.clone();
            Arrays.sort(ordered);  // ya lo ordenamos

            ejecutarSorts(ordered);

            System.out.println("-----------------------------");
        }
    }

    private static void ejecutarSorts(Integer[] data) {

        long start, end;

        Integer[] copy1 = data.clone();
        Integer[] copy2 = data.clone();
        Integer[] copy3 = data.clone();
        Integer[] copy4 = data.clone();
        Integer[] copy5 = data.clone();

        start = System.nanoTime();
        GnomeSort.sort(copy1);
        end = System.nanoTime();
        System.out.println("Gnome: " + (end - start));

        start = System.nanoTime();
        MergeSort.sort(copy2);
        end = System.nanoTime();
        System.out.println("Merge: " + (end - start));

        start = System.nanoTime();
        QuickSort.sort(copy3);
        end = System.nanoTime();
        System.out.println("Quick: " + (end - start));

        start = System.nanoTime();
        RadixSort.sort(copy4);
        end = System.nanoTime();
        System.out.println("Radix: " + (end - start));

        start = System.nanoTime();
        SelectionSort.sort(copy5);
        end = System.nanoTime();
        System.out.println("Selection: " + (end - start));
    }

    private static Integer[] generateRandomArray(int size) {
        Random random = new Random();
        Integer[] array = new Integer[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);
        }

        return array;
    }
}