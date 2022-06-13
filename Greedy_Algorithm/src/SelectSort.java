public class SelectSort {
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min=i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            swap(arr,i,min);
        }
    }

    private static void swap(int[] arr, int i, int min) {
        int t=arr[i];
        arr[i]=arr[min];
        arr[min]=t;
    }
}
