package com.example.danielmoreno.androidcourse.dependency;

public class Sort {
    private SortMethod mSortMethod;

    public Sort() {
        mSortMethod = new QuickSort();
    }

    public Sort(SortMethod sortMethod) {
        mSortMethod = sortMethod;
    }

    public int[] sort(int[] array){
        return mSortMethod.sort(array);
    }

}
