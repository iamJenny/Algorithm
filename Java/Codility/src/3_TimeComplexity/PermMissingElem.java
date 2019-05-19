/**
 * Q. 주어진 순열에서 누락 된 원소를 찾아라. 
 * A. https://app.codility.com/demo/results/trainingAHFD25-87G/ 
 * Test Score. 10%
 * 
 * Analysis summary. 
 * For example, For example, for the input [] the solution terminated unexpectedly.
 */
class Solution1 {
    public int solution(int[] A) {
        // 현재 A의 마지막 Index까지의 value의 합
        int aSum = 0;
        for (int aIndex = 0; aIndex < A.length; aIndex++) {
            aSum += A[aIndex];
        }
        // A의 마지막 Index까지 value가 누락되지 않고 정상적으로 있는 경우
        int bSum = 0;
        for (int bIndex = 0; bIndex < A.length; bIndex++) {
            bSum += bIndex + 1;
        }

        // result = A의 마지막 요소 - (정상요소에서 누락요소의 차이)
        int result = A[A.length - 1] - (aSum - bSum);

        return result;
    }
}

/**
 * Q. 주어진 순열에서 누락 된 원소를 찾아라. 
 * A. https://app.codility.com/demo/results/training8UWCJ3-CZ8/
 * Test Score. 100%
 */
class Solution2 {
    public int solution(int[] A) {
        // 현재 A의 마지막 Index까지의 value의 합
        int aSum = 0;
        for (int aIndex = 0; aIndex < A.length; aIndex++) {
            aSum += A[aIndex];
        }
        // A의 마지막 Index까지 value가 누락되지 않고 정상적으로 있는 경우
        int bSum = 0;
        for (int bIndex = 0; bIndex < A.length + 2; bIndex++) {
            bSum += bIndex;
        }

        // 정상요소에서 누락요소의 차이
        return bSum - aSum;
    }
}