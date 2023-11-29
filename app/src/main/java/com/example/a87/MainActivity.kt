package com.example.a87

import java.lang.reflect.Array
import java.util.Arrays

/**
 * 1~10^7 : n
 * 0~n^2 : left,right
 * right- left < 10^5
 */

/**
 * n = 3  [0,0] = 1
 * 1 2 3  [0,1],[1,0] [1,1] = 2                                 0 1 2
 * 2 2 3  [0,2],[1,2],[2,2],[2,1],[2,0] = 3                     3 4 5
 * 3 3 3  [0,3],[1,3],[2,3],[3,3],[3,2],[3,1],[3,0] = 4         6 7 8
 *
 * n = 4
 * 1 2 3 4                                                      0 1 2 3
 * 2 2 3 4                                                      4 5 6 7
 * 3 3 3 4                                                      8 9 a b
 * 4 4 4 4                                                      c d e f
 *
 *
 * [0,n-1]...[n-1,n-1]...[n-1,0] = n 이 채워진다
 * n 의 count = 2n-1
 *
 * n= 3 일때,
 * 1 -> 0
 * 2 -> 1 ,3,4
 * 3 -> 2 ,5,6,7,8
 * n = 4 일때
 * 1 -> 0
 * 2 -> 1 ,4,5
 * 3 -> 2 ,6, 8,9,10
 * 4 -> 3 ,7, 11,12,13,14,15
 */
class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        var answer = intArrayOf()
        var arrList = mutableListOf<Int>()
        //2차원 배열 만들기 <= x 시간복잡도 많이 잡아먹는듯

        /// n -> (n-1)^2~n^2-1 까지 n이 채워져 있음
        var range = ((n-1)*(n-1)..n*n-1)


        return answer
    }
}

fun main(){
    val a = Solution()
    a.solution(3,2,5)//[3,2,2,3]
    a.solution(4,7,14)//[4,3,3,3,4,4,4,4]

}