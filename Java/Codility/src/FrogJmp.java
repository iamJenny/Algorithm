 /**
 * Q. 작은 개구리가 표적에 도달하기 위해 수행해야하는 최소 점프 수를 세십시오. 
 * A. https://app.codility.com/demo/results/trainingJ42Y8P-523/
 * Test Score. 100%
 */
class Solution {
    public int solution(int X, int Y, int D) {
        int jumpCnt = (Y - X) / D;
        return (jumpCnt * D >= Y - X) ? jumpCnt : jumpCnt + 1;
    }
}
