package com.man1s.arithmetic;

/**
 * Title:QuickSort
 * Description:
 * Company:北京华宇元典信息服务有限公司
 *
 * @author:wangjiyu
 * @version:1.0
 * @date:2019/1/17 13:39
 */
public class QuickSort {
    static Integer[] array = {4313131, 442423, 77, 221, 31444, 119, 423, 536, 1, 2, 3, 4, 5};

    public static void main(String[] args) {
        sort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void sort(Integer[] array, int standard, int end) {
        if (standard >= array.length) {
            return;
        }
        dealSort(standard, end, array);

    }

    private static void dealSort(int standard, int end, Integer[] array) {
        if (standard > end) {
            return;
        }
        int temp = array[standard];
        int start = standard;
        int endoffset = end;
        while (start != end) {
            while (array[end] >= temp && end > start) {//循环直到array[end]<temp
                end--;
            }
            while (array[start] <= temp && end > start) {//循环直到arry[standard]>temp
                start++;
            }
            if (end > start) {
                array[start] = array[start] + array[end];
                array[end] = array[start] - array[end];
                array[start] = array[start] - array[end];
            }
        }
        array[standard] = array[end];
        array[end] = temp;

        dealSort(standard, end - 1, array);
        dealSort(end + 1, endoffset, array);
    }
}
