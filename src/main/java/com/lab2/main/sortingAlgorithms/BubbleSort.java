package com.lab2.main.sortingAlgorithms;

import java.util.List;

public class BubbleSort<T extends Comparable<? super T>> {
    List<T> list;

    BubbleSort(List<T> list) {
        this.list = list;
    }

    public List<T> bubbleSort() {
        for (int i = list.size(); i > 1; i--) {
            for (int j = 0; j < i - 1; j++) {
                //if greater swap elements
                if (list.get(j).compareTo(list.get(j+1)) > 0) {
                    swapElements(j, list);
                }
            }
        }
        return list;
    }

    private void swapElements(int index, List<T> list) {
        T temp = list.get(index);
        list.set(index, list.get(index + 1));
        list.set(index + 1, temp);
    }
}