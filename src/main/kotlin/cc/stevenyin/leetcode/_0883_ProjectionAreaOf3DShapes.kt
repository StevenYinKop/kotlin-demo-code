package cc.stevenyin.leetcode

import kotlin.math.max

/**
 * 883. Projection Area of 3D Shapes
 * https://leetcode.com/problems/projection-area-of-3d-shapes/
You are given an n x n grid where we place some 1 x 1 x 1 cubes that are axis-aligned with the x, y, and z axes.
Each value v = grid[i][j] represents a tower of v cubes placed on top of the cell (i, j).
We view the projection of these cubes onto the xy, yz, and zx planes.
A projection is like a shadow, that maps our 3-dimensional figure to a 2-dimensional plane. We are viewing the "shadow" when looking at the cubes from the top, the front, and the side.
Return the total area of all three projections.

Example 1:

<p>
<img src="./shadow.png"></img>
</p>

Input: grid = [[1,2],[3,4]]
Output: 17
Explanation: Here are the three projections ("shadows") of the shape made with each axis-aligned plane.

Example 2:

Input: grid = [[2]]
Output: 5

Example 3:

Input: grid = [[1,0],[0,2]]
Output: 8

 */
class _0883_ProjectionAreaOf3DShapes {
    fun projectionArea(grid: Array<IntArray>) = calcFrontView(grid) + calcSideView(grid) + calcTopView(grid)

    private fun calcTopView(grid: Array<IntArray>) = grid.fold(0) { sum, ints -> sum + ints.filter { i -> i > 0 }.size }

    private fun calcFrontView(grid: Array<IntArray>) = grid.fold(0) { sum, ints -> sum + ints.max()!! }

    private fun calcSideView(grid: Array<IntArray>): Int {
        val cacheArray = IntArray(grid.size)
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                cacheArray[j] = max(cacheArray[j], grid[i][j]);
            }
        }
        return cacheArray.sum();
    }
}

fun main() {
    _0883_ProjectionAreaOf3DShapes().projectionArea(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)));
}