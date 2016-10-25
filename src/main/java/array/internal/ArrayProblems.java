package array.internal;

import java.util.ArrayList;

/**
 * Description.
 * @author Your Name
 */
public interface ArrayProblems {

    public int[] rotateArray(int[] a, int num_of_rotations);

    public int findElementInRotateArray(int[] a, int num_to_find);

    public void mergeSort(int[] a);

    /**
     * @param a list of elements present in dm_delete_tracking table
     * @param b list of all the entire elements
     * @return only the elements that are not present in dm_delete_tracking table
     */
    public ArrayList<Integer> findIntersection(int[] a, int[] b);

    public Integer maxContigious(int[] a);

}
