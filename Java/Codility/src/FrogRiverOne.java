import java.util.HashMap;
import java.util.Map;

/**
 * Q. 개구리가 이동하는 최소 경로를 구하라. 
 * A. https://app.codility.com/demo/results/training7P743J-6AP/
 * Test Score. 27%
 * 
 * Analysis summary.
 * For example, for the input (3, [1, 3, 1, 3, 2, 1, 3]) the solution returned a wrong answer (got 6 expected 4).
 */
class Solution {
    public int solution(int X, int[] A) {
        // xMap(좌표, 시간)
        Map<Integer, Integer> xMap = new HashMap<>();
    
        // A[시간] = 좌표
        for (int k = 0; k < A.length; k++) {
            // 원하는 좌표(X)보다 이전의 좌표들이 있는 경우 xMap에 저장
            if (A[k] <= X) {
                xMap.put(A[k], k);
            }
        }

        // xMap에 좌표가 원하느 좌표(X)의 시간 안에 있는지 확인
        int result = 0;
        for(int xLocation = 1; xLocation < X+1; xLocation++){
            if(result != -1) {
                result = (xMap.keySet().contains(xLocation) ? xMap.get(xLocation) : -1);
            }
        }
        
        return result;
    }
}