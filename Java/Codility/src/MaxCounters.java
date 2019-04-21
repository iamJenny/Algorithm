/**
 * For example, given integer N = 5 and array A such that:
    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
 * the values of the counters after each consecutive operation will be:
    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
 */

/**
 * Q. 주어진 A에 대한 작업 후 모든 카운터의 값을 계산하는 것 
 * A. https://app.codility.com/demo/results/trainingSPE9PT-Z3T/ 
 * TestScore. 77%
 * 
 * Analysis summary.
 * timeout errors.
 */
class Solution1 {
    public int[] solution(int N, int[] A) {
        int[] X = new int[N];

        // 증가 - 카운터 X가 1 씩 증가하며,
        // 최대 카운터 - 모든 카운터는 모든 카운터의 최대 값으로 설정.
        int maxValue = 0;
        for (int aValue : A) {
            int xIndex = aValue - 1;

            // 1 ≤ X ≤ N이되는 A[K] = X이면, 연산 K는 증가
            if (aValue >= 1 && aValue <= N) {
                ++X[xIndex];

                // 최대 카운터 비교
                if (maxValue < X[xIndex]) {
                    maxValue = X[xIndex];
                }
            }
            // A[K] = N + 1이면 연산 K는 최대 카운터로 초기화
            else if (aValue == N + 1) {
                for (int i = 0; i < X.length; i++) {
                    X[i] = maxValue;
                }
            }
        }

        return X;
    }
}

/**
 * Q. 주어진 A에 대한 작업 후 모든 카운터의 값을 계산하는 것 
 * A. https://app.codility.com/demo/results/training6THH6U-6B2/
 * TestScore. 100%
 * Time complexity. O(N + M)
 */
class Solution2 {
    public int[] solution(int N, int[] A) {
        int[] X = new int[N];

        // 증가 - 카운터 X가 1 씩 증가하며,
        // 최대 카운터 - 모든 카운터는 모든 카운터의 최대 값으로 설정.
        int maxValue = 0;
        int tempValue = 0;

        for (int aValue : A) {
            int xIndex = aValue - 1;

            // 1 ≤ X ≤ N이되는 A[K] = X이면, 연산 K는 증가
            if (aValue >= 1 && aValue <= N) {
                // 최대 카운터 임시저장한 값과 비교 (이전 계산 값은 무시)
                if (tempValue > X[xIndex]) {
                    X[xIndex] = tempValue;
                }

                ++X[xIndex];
                // 최대 카운터 비교
                if (maxValue < X[xIndex]) {
                    maxValue = X[xIndex];
                }
            }
            // A[K] = N + 1이면 연산 K는 최대 카운터에 대해 임시저장
            else if (aValue == N + 1) {
                tempValue = maxValue;
            }
        }

        // 최대 카운터에 대한 추가 계산 (무시된 이전 계산값을 임시저장 값으로 초기화)
        for (int i = 0; i < X.length; i++) {
            if (X[i] < tempValue) {
                X[i] = tempValue;
            }
        }

        return X;
    }
}