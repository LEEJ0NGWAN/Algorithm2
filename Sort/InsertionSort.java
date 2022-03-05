public class InsertionSort {

    // 오름차순 삽입 정렬
    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int j, k, tmp; boolean flag = false;
            
            for (j = 0; j < i; j++) if (arr[j] > arr[i]) { flag = true; break; }

            if (flag) {

                for (tmp = arr[i], k = i; k > j; k--) arr[k] = arr[k-1]; // shift
                arr[j] = tmp; // insert
            }
        }
    }
}