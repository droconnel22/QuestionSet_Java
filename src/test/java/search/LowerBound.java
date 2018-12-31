package search;

/*
NOTE : C++ STL (Standard Template Library) already contains implementation of all of these
functions. Check out here for additional knowledge binarysearch, lowerbound, upperbound

Lower bound: find an element X in a sorted array of integer such that  X > K where key K
is given.


 */


public class LowerBound {

    public int Lower_Bound_Search(Integer[] array, int n, int k) {
        int low, high, mid;
        low = 0;
        high = n-1;
        while(low <= high) {
            mid = (low + high) / 2;
            if(array[mid] >= k && (mid ==0 || array[mid-1] < k)){
                return  mid;
            } else if(array[mid] < k) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}
