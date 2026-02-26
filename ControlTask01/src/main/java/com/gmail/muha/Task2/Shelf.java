package com.gmail.muha.Task2;

import java.util.ArrayList;
import java.util.List;

public class Shelf {
    public static void main(String[] args) {

        int[] books = {4, 8, 1, 4, 2, 1, 7, 3, 2, 6, 2, 3, 5, 2, 4, 3, 6, 2, 1, 5};
        int shelfWidth = 10;

        calculation(books, shelfWidth);
    }

    private static void calculation(int[] books, int shelfWidth) {

        List<int[]> listShelf = new ArrayList<>();
        int countArrayElements = 0;

        int countWidth = 0;

        for (int i = 0; i < books.length; i++) {
            countWidth += books[i];
            countArrayElements++;

            if (i == books.length - 1) {

                addShelfInList(books, countArrayElements, i, listShelf);
                break;
            }

            if (countWidth + books[i + 1] > shelfWidth) {

                addShelfInList(books, countArrayElements, i, listShelf);
                countWidth = 0;
                countArrayElements = 0;
            }
        }
        printShelf(listShelf);
    }

    private static void addShelfInList(int[] books, int count, int i, List<int[]> listArrays) {
        int[] array = new int[count];

        for (int j = 0, k = i - count + 1; j < array.length; j++, k++) {
            array[j] = books[k];
        }
        listArrays.add(array);
    }

    private static void printShelf(List<int[]> listShelf) {
        System.out.println("Number of shelves: " + listShelf.size());
        for (int[] shelf : listShelf) {
            System.out.print("[");
            int sum = 0;
            for (int book : shelf) {
                sum += book;
                System.out.print(book + " ");
            }
            System.out.println("] —— " + sum + " cm");
        }
    }
}
