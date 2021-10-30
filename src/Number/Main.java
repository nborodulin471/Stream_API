package Number;


import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4));

        // 1. Отфильтруйте положительные числа.
        // 2. Найдите среди этих положительных чисел четные.
        Iterator<Integer> iterator = intList.iterator();
        while (iterator.hasNext()) {
            int x = iterator.next();
            if (!(x > 0) || !(x % 2 == 0)) {
                iterator.remove();
            }
        }
        // 3. Отсортируйте отфильтрованные числа в порядке возрастания
        quickSort(intList, 0, intList.size() - 1);

        // 4. Выведите результат на экран.
        for (int x : intList) {
            System.out.println(x);
        }

    }

    public static void quickSort(List<Integer> source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source.get((leftMarker + rightMarker) / 2);
        do {
            while (source.get(leftMarker) < pivot) {
                leftMarker++;
            }
            while (source.get(rightMarker) > pivot) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    int tmp = source.get(leftMarker);
                    source.set(leftMarker, source.get(rightMarker));
                    source.set(rightMarker, tmp);
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }

}



