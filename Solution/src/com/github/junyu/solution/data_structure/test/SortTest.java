package com.github.junyu.solution.data_structure.test;


import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 排序测试类
 *
 * @author ShaoJunyu
 * @since 2018/6/15 08:57
 */
public class SortTest {

    private static final boolean isShowLog = true;
    private static final String packageName = "com.github.junyu.solution.data_structure.sort.";


    private static int[] generateArr(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = length;
            length--;
        }
        return arr;
    }

    private static void printArr(int arr[]) {
        if (isShowLog)
            System.out.println(Arrays.toString(arr));
    }

    /**
     * 生成随机内容的数组
     *
     * @param n   数组长度
     * @param min 随机最小值
     * @param max 随机最大值
     * @return 随机内容的数组
     */
    private static int[] generateRandomArr(int n, int min, int max) {

        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = (int) (Math.random() * (max - min + 1) + min);
        }

        return arr;
    }

    /**
     * 生成几乎有序的数组
     *
     * @param n     数组长度
     * @param count 数组中交换次数
     * @return 数组
     */
    private static int[] generateNearlyArr(int n, int count) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < count; i++) {
            int left = (int) (Math.random() * n);
            int right = (int) (Math.random() * n);
            swap(arr, left, right);
        }
        return arr;
    }

    /**
     * 利用反射调用待测试的排序类，并统计消耗的时长
     *
     * @param className 类名
     * @param arr       待排序的数组
     */
    private static void testSort(String className, int[] arr) {
        try {
            Class sortClass = Class.forName(className);
            Method sortMethod = sortClass.getMethod("sort", int[].class, int.class);

            long startTime = System.currentTimeMillis();
            sortMethod.invoke(null, arr, arr.length);
            long endTime = System.currentTimeMillis();

            String sortName = sortClass.getSimpleName();

            isSorted(arr, arr.length, sortName);

            System.out.println(sortName + " : " + (double) (endTime - startTime) / 1000 + "s");
            printArr(arr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void isSorted(int[] arr, int length, String sortName) {
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                throw new RuntimeException(sortName + " : " + "array is not sorted");
            }
        }
    }

    private static void swap(int arr[], int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


    public static void main(String[] args) {

        int length = 10;
//        int[] arr = generateArr(length);
        int[] arr = generateRandomArr(length, 0, 10);
//        int[] arr = generateNearlyArr(length, 10);
//        System.out.println(Arrays.toString(arr));
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int[] arr3 = Arrays.copyOf(arr, arr.length);
        int[] arr4 = Arrays.copyOf(arr, arr.length);
        int[] arr5 = Arrays.copyOf(arr, arr.length);
        int[] arr6 = Arrays.copyOf(arr, arr.length);
        int[] arr7 = Arrays.copyOf(arr, arr.length);
        int[] arr8 = Arrays.copyOf(arr, arr.length);
        int[] arr9 = Arrays.copyOf(arr, arr.length);
        int[] arr10 = Arrays.copyOf(arr, arr.length);
        int[] arr11 = Arrays.copyOf(arr, arr.length);
        int[] arr12 = Arrays.copyOf(arr, arr.length);
        int[] arr13 = Arrays.copyOf(arr, arr.length);
        int[] arr14 = Arrays.copyOf(arr, arr.length);

//        testSort(packageName + "InsertionSort", arr2);
//        testSort(packageName + "InsertionSort2", arr7);
//        testSort(packageName + "SelectionSort", arr);
//        testSort(packageName + "BubbleSort", arr1);

//        testSort(packageName + "ShellSort", arr8);
//        testSort(packageName + "MergeSort", arr3);
//        testSort(packageName + "MergeSort2", arr9);
        testSort(packageName + "MergeSortBU", arr10);
        testSort(packageName + "HeapSort", arr11);
//        testSort(packageName + "HeapSort2", arr12);
//        testSort(packageName + "HeapSort3", arr13);
//        testSort(packageName + "QuickSort", arr4);
//        testSort(packageName + "QuickSort2", arr5);
//        testSort(packageName + "QuickSort3", arr6);
//        testSort(packageName + "QuickSort4", arr14);


    }


}
