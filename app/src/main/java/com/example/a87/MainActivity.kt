package com.example.a87

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.reflect.Array
import java.util.Arrays

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        class Solution {
            fun solution(n: Int, left: Long, right: Long): IntArray {
                var answer = intArrayOf()
                /**
                 * n = 2  [0,0]= 1 [0,1],[1,0] [1,1] = 2
                 * 1 2 3  [0,2],[1,2],[2,2],[2,1],[2,0] =3
                 * 2 2 3  [0,3],[1,3],[2,3],[3,3],[3,2],[3,1],[3,0] =4
                 * 3 3 3
                 *
                 * n = 3
                 * 1 2 3 4
                 * 2 2 3 4
                 * 3 3 3 4
                 * 4 4 4 4
                 *
                 *
                 * [0,n-1]...[n-1,n-1]...[n-1,0] = n
                 *
                 */
                //2차원 배열 만들기
                var matrix = Array(n,{IntArray(n,{1})})
                var count = 2

                while(count != n+1){
                    matrix[count-1][count-1]=count
                    for(i in 0..count-2){
                        matrix[i][count-1]=count
                    }
                    for(j in 0..count-2){
                        matrix[count-1][j]=count
                    }
                    //입력이후 count ++
                    count++
                }

                //2차원 배열값에서 순서대로 세어서 값 인출하기.
                var res = mutableListOf<Int>()
                //n진수값 계산하여 위치 파악가능.

                var left_i = 0
                var left_j = 0
                var left_res = ""
                left_res = left.toString(n)
                if(left_res.length ==1){
                    left_res = "0"+left_res
                }
                left_i = left_res[0].toString().toInt()
                left_j = left_res[1].toString().toInt()

                var right_i = 0
                var right_j = 0
                var right_res = ""
                right_res = right.toString(n)
                if(right_res.length ==1){
                    right_res = "0"+right_res
                }
                right_i = right_res[0].toString().toInt()
                right_j = right_res[1].toString().toInt()
                //값들 입력


                var i = left_i
                var j = left_j
                do{

                    res.add(matrix[i].get(j))
                    j++
                    if(j==n) {
                        j=0
                        i++
                    }

                }
                while(!(i==right_i && j==right_j))
                res.add(matrix[right_i].get(right_j))
                answer=res.toIntArray()

                return answer
            }
        }

        val a = Solution()
        a.solution(3,2,5)
        a.solution(4,7,14)
    }
}