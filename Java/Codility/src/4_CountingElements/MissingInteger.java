import java.util.Arrays;

/**
 * Q. N 개의 정수 중 A 배열이 주어지면 A에서 발생하지 않는 가장 작은 양의 정수를 반환해라. 
 * A. https://app.codility.com/demo/results/trainingUNQX9C-MKR/
 * TestScore. 100%
 * Time complexity. O(N) or O(N * log(N))
 */
class Solution {
    public int solution(int[] A) {
        int result = 1;

        //배열 A의 값을 순서대로 정렬
        Arrays.sort(A);

        //A에서 발생하지 않는 가장 작은 양의 정수를 찾기
        for (int aValue : A) {
            if (aValue == result) {
                result++;
            }
        }

        return result;
    }
}