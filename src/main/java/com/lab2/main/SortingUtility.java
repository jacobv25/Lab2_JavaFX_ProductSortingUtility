package com.lab2.main;

import com.lab2.main.Product.Product;
import com.lab2.main.sortingAlgorithms.BubbleSort;
import com.lab2.main.sortingAlgorithms.QuickSort;

import java.util.ArrayList;
import java.util.List;

public class SortingUtility {
    public List<Product> sortProducts(List<Product> list, int sortingAlgorithm) {
        switch (sortingAlgorithm) {
            case 0:
                BubbleSort<Product> bubbleSorter = new BubbleSort<Product>(list);
                List<Product> finalList = new ArrayList<Product>(bubbleSorter.bubbleSort());
                return finalList;
            case 1:
                QuickSort<Product> quickSorter = new QuickSort<Product>();
                quickSorter.quicksort(list, 0, list.size()-1);
                return list;
            default:
                return null;
        }
    }
}
