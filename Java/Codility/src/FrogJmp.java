/**
 * Q. 작은 개구리가 표적에 도달하기 위해 수행해야하는 최소 점프 수를 세십시오. 
 * A. https://app.codility.com/demo/results/trainingXRZYNC-CZU/ 
 * Test Score. 44%
 * Time complexity. O(Y-X)
 * 
 * Analysis summary. 
 * For example, for the input (3, 999111321, 7) the solution exceeded the time limit.
 */
class Solution1 {
    public int solution(int X, int Y, int D) {
        int jumpCnt = 0;

        while (X < Y) {
            X = X + D;
            jumpCnt += 1;
        }

        return jumpCnt;
    }
}

/**
 * Q. 작은 개구리가 표적에 도달하기 위해 수행해야하는 최소 점프 수를 세십시오. 
 * A. https://app.codility.com/demo/results/trainingJ42Y8P-523/ 
 * Test Score. 100%
 * Time complexity. O(1)
 */
class Solution2 {
    public int solution(int X, int Y, int D) {
        int jumpCnt = (Y - X) / D;
        return (jumpCnt * D >= Y - X) ? jumpCnt : jumpCnt + 1;
    }
}
