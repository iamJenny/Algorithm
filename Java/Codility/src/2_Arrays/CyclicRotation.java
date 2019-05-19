/**
 * Q. 배열을 회전하면 각 요소가 하나의 인덱스만큼 오른쪽으로 이동하고 배열의 마지막 요소가 첫 번째 위치로 이동.
 * A. https://app.codility.com/demo/results/training9VQ668-86W/
 * Test Score. 100%
 */

class Solution {
    public int[] solution(int[] A, int K) {
        int aSize = A.length;
        int[] result = new int [aSize];

        for (int i = 0; i < aSize; i++) {
            // 배열 A보다 인덱스 범위가 큰 경우
            int rotationIndex = i + K;
            if (rotationIndex >= aSize) {
                rotationIndex = rotationIndex % aSize;
            }

            // 배열에 이동한 인덱스만큼의 값 넣기
            result[rotationIndex] = A[i];
        }

        return result;
    }
}