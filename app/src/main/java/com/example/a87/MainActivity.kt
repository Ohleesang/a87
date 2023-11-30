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
 * 1 2 3  [0,1],[1,0] [1,1] = 2
 * 2 2 3  [0,2],[1,2],[2,2],[2,1],[2,0] = 3
 * 3 3 3  [0,3],[1,3],[2,3],[3,3],[3,2],[3,1],[3,0] = 4
 *
 * n = 4
 * 1 2 3 4
 * 2 2 3 4
 * 3 3 3 4
 * 4 4 4 4
 *
 *
 * [0,n-1]...[n-1,n-1]...[n-1,0] = n 이 채워진다
 * n 의 count = 2n-1
 *
 *  n = 1
 *  1
 *  n = 2
 *  1 2 / 2 2
 *  n = 3
 *  1 2 3 / 2 2 3 / 3 3 3
 *  n = 4
 *  1 2 3 4 / 2 2 3 4 / 3 3 3 4 / 4 4 4 4
 *  n = 5
 *  1 2 3 4 5 / 2 2 3 4 5 / 3 3 3 4 5 / 4 4 4 4 5 / 5 5 5 5 5
 */
class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        var answer = intArrayOf()
        var arrList = mutableListOf<Int>()
        //2차원 배열 만들기 <= x 시간복잡도 많이 잡아먹는듯
        var count = 1
        var index = 0
        loop@ for(i in 1..n){
            for(j in 1..n){
                if(left<=index && index<=right){
                    if(count>=j)
                        arrList.add(count)
                    else
                        arrList.add(j)
                }
                else if(index>right) {
                    break@loop
                }
                index++
            }
            count++
        }
        answer = arrList.toIntArray()
        return answer
    }
}

fun main(){
    val a = Solution()
    a.solution(3,2,5)//[3,2,2,3]
    a.solution(4,7,14)//[4,3,3,3,4,4,4,4]

}