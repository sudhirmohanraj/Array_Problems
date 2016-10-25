package array.internal.impl;

import java.util.ArrayList;
import java.util.HashSet;

import array.internal.ArrayProblems;

/**
 * Description.
 * @author Your Name
 */
public class ArrayProblemsImpl implements ArrayProblems {

    /**
     * {@inheritDoc}
     */
    @Override
    public int[] rotateArray(final int[] a, final int num_of_rotations) {
        final int[] temp = new int[a.length];
        final int[] result = new int[a.length];
        for (int i = 0; i < num_of_rotations; i++) {
            temp[i] = a[i];
        }

        int j = 0;
        for (int i = num_of_rotations; i < a.length; i++) {
            result[j] = a[i];
            j++;
        }
        for (int i = 0; i < num_of_rotations; i++) {
            result[j] = temp[i];
            j++;
        }
        return result;
    }

    @Override
    public int findElementInRotateArray(final int[] A, final int N) {
        int L = 0;
        int R = N - 1;

        while (L <= R) {
            // Avoid overflow, same as M=(L+R)/2
            final int M = L + ((R - L) / 2);
            if (A[M] == N) {
                return M;
            }

            // the bottom half is sorted
            if (A[L] <= A[M]) {
                if (A[L] <= N && N < A[M]) {
                    R = M - 1;
                } else {
                    L = M + 1;
                }
            }
            // the upper half is sorted
            else {
                if (A[M] < N && N <= A[R]) {
                    L = M + 1;
                } else {
                    R = M - 1;
                }
            }
        }
        return -1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mergeSort(final int[] a) {
        final int length = a.length;
        doMergeSort(a, 0, length - 1);
    }

    /**
     * @param a
     * @param i
     * @param j
     * @return
     */
    private void doMergeSort(final int[] a, final int l, final int h) {
        if (l < h) {
            final int middle = l + (h - l) / 2;

            doMergeSort(a, l, middle);

            doMergeSort(a, middle + 1, h);

            mergeParts(a, l, middle, h);
        }
    }

    /**
     * @param l
     * @param middle
     * @param h
     */
    private void mergeParts(final int[] a, final int l, final int middle, final int h) {
        final int[] temp = new int[a.length];
        for (int i = 0; i < a.length - 1; i++) {
            temp[i] = a[i];
        }

        int i = l;
        int j = middle + 1;
        int k = l;

        while (i <= middle && j <= h) {
            if (temp[i] <= temp[j]) {
                a[k] = temp[i];
                i++;
            } else {
                a[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            a[k] = temp[i];
            k++;
            i++;
        }

    }

    /**
     * @param a list of elements present in dm_delete_tracking table
     * @param b list of all the entire elements
     * @return only the elements that are not present in dm_delete_tracking table
     */
    @Override
    public ArrayList<Integer> findIntersection(final int[] a, final int[] b) {
        final HashSet<Integer> set = new HashSet<Integer>();
        final ArrayList<Integer> output = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            if (!set.contains(b[i])) {
                output.add(b[i]);
            }
        }
        return output;
    }

    @Override
    public Integer maxContigious(int[] a) {

        int cs = 0;
        int ms =0;
        for(int l = 0; l<a.length; l++){
            cs = a[l];
            for(int m=l+1;m<a.length;m++) {
                cs = a[m]+cs;
                if (cs > ms) {
                    ms = cs;
                }
            }
        }
        System.out.println(ms);
        return ms;
    }
}
