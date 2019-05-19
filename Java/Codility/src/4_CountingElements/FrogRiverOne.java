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
class Solution1 {
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
        for (int xLocation = 1; xLocation < X + 1; xLocation++) {
            if (result != -1) {
                result = (xMap.keySet().contains(xLocation) ? xMap.get(xLocation) : -1);
            }
        }

        return result;
    }
}

/**
 * Q. 개구리가 이동하는 최소 경로를 구하라. 
 * A. https://app.codility.com/demo/results/trainingAVE2CA-CDU/
 * Test Score. 72%
 * 
 * Analysis summary.
 * For example, for the input (1, [1]) the solution returned a wrong answer (got -1 expected 0).
 */
class Solution2 {
    public int solution(int X, int[] A) {
        // 개구리의 현재 위치 및 소요 시간 xMap(좌표, 시간)
        Map<Integer, Integer> xMap = new HashMap<>();

        // 개구리가 원하는 좌표(X)까지 도달하는 좌표들의 시간 초기화
        for (int location = 1; location <= X; location++) {
            xMap.put(location, 0);
        }

        // A[시간] = 좌표
        for (int k = 0; k < A.length; k++) {
            // 좌표가 생긴 시점의 시간만 저장
            if (xMap.get(A[k]) == 0) {
                xMap.put(A[k], k);
            }
        }

        // xMap에 좌표가 원하느 좌표(X)까지 도달하는 동안 시간 여부
        int resultTime = 0;
        for (int xLocation : xMap.keySet()) {
            // 시간이 없는 경우
            if (xMap.get(xLocation) == 0) {
                resultTime = -1;
            }
            // 시간이 있는 경우
            else if (resultTime != -1) {
                if (resultTime < xMap.get(xLocation)) {
                    resultTime = xMap.get(xLocation);
                }
            }
        }

        return resultTime;
    }
}

/**
 * Q. 개구리가 이동하는 최소 경로를 구하라. 
 * A. https://app.codility.com/demo/results/trainingBBMYXN-Q9J/
 * Test Score. 90%
 * Time complexity. O(N)
 * 
 * Analysis summary.
 * timeout errors.
 */
class Solution3 {
    public int solution(int X, int[] A) {
        // 개구리의 현재 위치 및 소요 시간 xMap(좌표, 시간)
        Map<Integer, Integer> xMap = new HashMap<>();

        // 개구리가 원하는 좌표(X)까지 도달하는 좌표들의 시간 초기화
        for (int location = 1; location <= X; location++) {
            xMap.put(location, -1);
        }

        // A[시간] = 좌표
        for (int k = 0; k < A.length; k++) {
            // 좌표가 생긴 시점의 시간만 저장
            if (xMap.get(A[k]) == -1) {
                xMap.put(A[k], k);
            }
        }

        // xMap에 좌표가 원하느 좌표(X)까지 도달하는 동안 시간 여부
        int resultTime = 0;
        for (int xLocation : xMap.keySet()) {
            // 시간이 없는 경우
            if (xMap.get(xLocation) == -1) {
                resultTime = -1;
            }
            // 시간이 있는 경우
            else if (resultTime != -1) {
                if (resultTime < xMap.get(xLocation)) {
                    resultTime = xMap.get(xLocation);
                }
            }
        }

        return resultTime;
    }
}

/**
 * Q. 개구리가 이동하는 최소 경로를 구하라. 
 * A. https://app.codility.com/demo/results/trainingZ8RHNY-7ST/
 * Test Score. 100%
 * Time complexity. O(N)
 */
class Solution4 {
    public int solution(int X, int[] A) {
        // 개구리의 현재 위치 및 소요 시간 xMap(좌표, 시간)
        Map<Integer, Integer> xMap = new HashMap<>();

        // 개구리가 원하는 좌표(X)까지 도달하는 좌표들의 시간 초기화
        for (int location = 1; location <= X; location++) {
            xMap.put(location, -1);
        }

        // A[시간] = 좌표
        for (int k = 0; k < A.length; k++) {
            // 좌표가 생긴 시점의 시간만 저장
            if (xMap.get(A[k]) == -1) {
                xMap.put(A[k], k);
            }
        }

        // xMap에 좌표가 원하느 좌표(X)까지 도달하는 동안 시간 여부
        int resultTime = 0;
        for (int xLocation : xMap.keySet()) {
            // 시간이 없는 경우
            if (xMap.get(xLocation) == -1) {
                resultTime = -1;
            }
            // 시간이 있는 경우
            else if (resultTime < xMap.get(xLocation) && resultTime != -1){
                resultTime = xMap.get(xLocation);
            }
        }

        return resultTime;
    }
}