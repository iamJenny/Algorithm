import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Q. 배열 A가 순열이면 1을, 그렇지 않으면 0을 반환해라. 
 * A. https://app.codility.com/demo/results/trainingVS45E8-GY5/ 
 * Test Score. 75%
 * 
 * Analysis summary. 
 * For example, for the input [1, 4, 1] the solution returned a wrong answer (got 1 expected 0).
 */
class Solution1 {
    public int solution(int[] A) {
        int result = 0;

        int keyA = 0;
        int valueA = 0;

        // 배열 A의 key와 value의 각각의 총 합 구하기
        for (int i = 0; i < A.length; i++) {
            keyA += i;
            valueA += A[i];
        }

        // 배열 A의 key는 (마지막 인덱스 +1) 포함
        keyA += A.length;

        // 배열 A의 순열여부
        result = (keyA - valueA) == 0 ? 1 : 0;

        return result;
    }
}

/**
 * Q. 배열 A가 순열이면 1을, 그렇지 않으면 0을 반환해라. 
 * A. https://app.codility.com/demo/results/trainingRPPSCR-E29/ 
 * Test Score. 66%
 * Time complexity. O(N ** 2)
 * 
 * Analysis summary.
 * timeout errors.
 */
class Solution2 {
    public int solution(int[] A) {
        int result = 0;

        int keyA = 0;

        List<Integer> valueAList = new ArrayList<>();
        int valueA = 0;

        // 배열 A의 value의 중복 제거
        for (int i : A) {
            valueAList.add(i);
        }
        Set<Integer> valueANotDupilcation = new TreeSet<>(valueAList);

        // 배열 A의 중복제거한 value의 총 합
        for (Integer i : valueANotDupilcation) {
            valueA += i;
        }

        // 배열 A의 key의 총 합 ((마지막 인덱스 +1) 포함)
        for (int i = 0; i <= A.length; i++) {
            keyA += i;
        }

        // 배열 A의 순열여부
        result = (keyA - valueA) == 0 ? 1 : 0;

        return result;
    }
}

/**
 * Q. 배열 A가 순열이면 1을, 그렇지 않으면 0을 반환해라. 
 * A. https://app.codility.com/demo/results/trainingHR7K7J-ZS3/
 * Test Score. 50%
 * Time complexity. O(N ** 2)
 * 
 * Analysis summary.
 * timeout errors.
 */
class Solution3 {
    public int solution(int[] A) {
        int result = 0;

        int keyA = 0;
        int valueA = 0;
        List<Integer> DuplicateValue = new ArrayList<>();

        // 배열 A의 key와 value의 총 합
        for (int i = 0; i < A.length; i++) {
            keyA += i;
            valueA += A[i];
            DuplicateValue.add(A[i]);
        }

        // 배열 A의 key는 (마지막 인덱스 +1) 포함
        keyA += A.length;

        // 배열 A의 value 중복여부
        for (int i = 1; i <= A.length; i++) {
            result = DuplicateValue.contains(i) && result == 0 ? 0 : 1;
        }

        // 배열 A의 순열여부
        result = (keyA - valueA) == 0 && result == 0 ? 1 : 0;

        return result;
    }
}