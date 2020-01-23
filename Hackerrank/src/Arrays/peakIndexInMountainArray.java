package Arrays;

public class peakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] A) {
        int tmp = 0;
        for(int i = 0; i < A.length; i++){
            tmp = A[i];

            if (tmp > A[i + 1] && tmp > A[i -1]){
                return tmp;
            }
        }
        return tmp;
    }

    //https://leetcode.com/submissions/detail/288477780/
    //TODO look up binary search again
}
