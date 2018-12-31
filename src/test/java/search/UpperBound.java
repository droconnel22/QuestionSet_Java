package search;

/*
Common variations of Binary Search

Upper Bound: find an element X in a sorted array of integers such that  X > K ,
where key K is given.

*/



public class UpperBound {

    public int Upper_Bound_Search(Integer[] array, int N, int k) {
        int low, high, mid;
        low = 0;
        high = N-1;

        while(low <= high) {
            mid = (low + high)/2;

            // checking conditions for upper bound.
            if(array[mid] > k && (mid == 0 || array[mid-1] <=k )) {
                return  mid;
            } else if(array[mid] > k) {
                high = mid-1;
            } else {
                low  = mid+1;
            }
        }

        return  -1; // not found
    }

}

