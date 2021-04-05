// https://leetcode-cn.com/leetbook/read/design-patterns/9e2v65/
package BehavioralPatterns;

import java.util.Arrays;

enum SortStrategy {
    BUBBLE_SORT,
    SELECTION_SORT,
    INSERT_SORT
}

interface ISort {
    void sort(int[] arr);
}

class BubbleSort implements ISort {
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j + 1] = arr[j + 1] + arr[j];
                    arr[j] = arr[j + 1] - arr[j];
                    arr[j + 1] = arr[j + 1] - arr[j];
                }
            }
        }
    }
}

class SelectionSort implements ISort {
    public void sort(int[] arr) {
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}

class InsertSort implements ISort {
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currentNumber = arr[i];
            int j = i - 1;
            while (j >= 0 && currentNumber < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = currentNumber;
        }
    }
}

class Sort implements ISort {
    private ISort sort;

    Sort(SortStrategy strategy) {
        setStrategy(strategy);
    }

    public void sort(int[] arr) {
        sort.sort(arr);
    }

    // 客户端通过此方法设置不同的策略
    public void setStrategy(SortStrategy strategy) {
        switch (strategy) {
            case BUBBLE_SORT:
                sort = new BubbleSort();
                break;
            case SELECTION_SORT:
                sort = new SelectionSort();
                break;
            case INSERT_SORT:
                sort = new InsertSort();
                break;
            default:
                throw new IllegalArgumentException("There's no such strategy yet.");
        }
    }
}

public class Strategy {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 2, 3, 5, 4};
        Sort sort = new Sort(SortStrategy.BUBBLE_SORT);
        // 可以通过选择不同的策略完成排序
        // sort.setStrategy(SortStrategy.SELECTION_SORT);
        // sort.setStrategy(SortStrategy.INSERT_SORT);
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
