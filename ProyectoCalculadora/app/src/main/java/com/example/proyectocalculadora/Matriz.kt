package com.example.proyectocalculadora

class Matriz() {


    var row = 0
    var column = 0
   

    fun Matriz(row:Int,column:Int, matriz:Array<IntArray>?){
        this.row = row
        this.column = column
        
    }

    /*Funcion que calcula la traspuesta*/
    fun traspuestaMatrix(matrix: Matriz) {

        // Display current matrix
        display(matrix.matriz)

        // Transpose the matrix
        val transpose = Array(column) { IntArray(row) }
        for (i in 0..row - 1) {
            for (j in 0..column - 1) {
                transpose[j][i] = matrix.matriz!![i][j]
            }
        }

        // Resultado traspuesta matriz
        display(transpose)
    }


    fun display(matriz: Array<IntArray>?) {
        println("La matriz traspuesta es: ")
        if (matriz != null) {
            for (row in matriz) {
                for (column in row) {
                    print("$column    ")
                }
                println()
            }
        }
    }

    /*Funcion que multiplica la multiplicacion de matrices*/

    fun main(firstMatrix: Matriz, secondMatrix: Matriz) {


        // Mutliplica dos matrices
        val product = Array(firstMatrix.row) { IntArray(secondMatrix.column) }
        for (i in 0 until firstMatrix.row) {
            for (j in 0 until secondMatrix.column) {
                for (k in 0 until firstMatrix.column) {
                    product[i][j] += firstMatrix.matriz!![i][k] * secondMatrix.matriz!![k][j]
                }
            }
        }

        // Resultado
        println("Producto de dos matrices: ")
        for (row in product) {
            for (column in row) {
                print("$column    ")
            }
            println()
        }
    }

    /*Funcion que suma matrices*/
    fun sumaMatrix() {
        val rows = 2
        val columns = 3
        val firstMatrix = arrayOf(intArrayOf(2, 3, 4), intArrayOf(5, 2, 3))
        val secondMatrix = arrayOf(intArrayOf(-4, 5, 3), intArrayOf(5, 6, 3))

        // Adding Two matrices
        val sum = Array(rows) { IntArray(columns) }
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                sum[i][j] = firstMatrix[i][j] + secondMatrix[i][j]
            }
        }

        // Displaying the result
        println("Resultado suma: ")
        for (row in sum) {
            for (column in row) {
                print("$column    ")
            }
            println()
        }
    }
}
