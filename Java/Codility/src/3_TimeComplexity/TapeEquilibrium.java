
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Q. |(A [0] + ... + A [P-1]) - (A [P] + ... + A [N-1])| 값을 최소화하라. 
 * A. https://app.codility.com/demo/results/trainingABDV4R-THQ/ 
 * Test Score. 53%
 * Time complexity. O(N * N)
 * 
 * Analysis summary. 
 * timeout errors.
 */
class Solution {
    public int solution(int[] A) {
        List<Integer> aList = new ArrayList<>();

        for (int cnt = 1; cnt < A.length; cnt++) {
            int indexSum = 0;
            for (int index = 0; index < A.length; index++) {
                if (index >= cnt) {
                    indexSum -= A[index];
                } else {
                    indexSum += A[index];
                }
            }
            aList.add(Math.abs(indexSum));
        }

        return (int) Collections.min(aList);
    }
}