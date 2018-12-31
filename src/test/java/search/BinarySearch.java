package search;

public class BinarySearch {

    int Search(Integer[] array, int key, int low, int high)
    {
        if(high < low){
            return -1; // not found
        } else {
            int mid = (low + high) /2;

            if(array[mid] > key) {
                return Search(array, key, low, mid-1);
            } else  if (array[mid] < key){
                return  Search(array, key, mid+1, high);
            } else {
                return mid; // found
            }
        }
    }

    int SearchIterative(Integer[] array, int N, int key) {
        int low, high, mid;
        low = 0;
        high = N-1;
        while(low <= high) {
            mid = (low+high)/2;
            if(array[mid] > key) {
                high = mid-1;
            } else  if (array[mid] < key){
                low = mid+1;
            } else {
                return  mid;
            }
        }

        return -1; // no key exists.
    }

}
