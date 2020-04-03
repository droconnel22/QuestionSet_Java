package com.binarySearch;

/*
You are a product manager and currently leading a
 team to develop a new product. Unfortunately,
  the latest version of your product fails the quality check.
  Since each version is developed based on the previous version,
 all the versions after a bad version are also bad.
 */


interface IsBadVersion {
    default boolean isBadVersion(int version) {
        return true;
    }
}

public class FirstBadVersion implements IsBadVersion {

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while(low < high)
        {
            int midpoint = (high-low)/2 +low;
            boolean midResult = isBadVersion(midpoint);
            if(!midResult) {
                low = midpoint+1;
            } else {
                high = midpoint;
            }
        }

        return low;
    }
}
