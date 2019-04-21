import java.util.HashMap;
import java.util.Map;

/**
 * Q. 정수(홀수) N개의 수로 이루어진 배열 A의 동일한 값을 쌍으로 이루지 않은 요소를 찾아라. A.
 * https://app.codility.com/demo/results/training8DZYSM-P7E/ Test Score. 100%
 * Time complexity. O(N) or O(N*log(N))
 */
class Solution {
    public int solution(int[] A) {
        Map<Integer, Integer> aMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < A.length; i++) {
            if (aMap.containsKey(A[i])) {
                int value = aMap.get(A[i]) + 1;
                aMap.put(A[i], value);
            } else {
                aMap.put(A[i], 1);
            }
        }

        int aMapOddValue = 0;
        for (Integer key : aMap.keySet()) {
            aMapOddValue = (aMap.get(key) % 2 == 1) ? key : aMapOddValue;
        }

        return aMapOddValue;
    }
}