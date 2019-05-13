package com.example.proyectocalculadora

class Matrix {
    private val M: Int             // numero de filas
    private val N: Int             // numero de columnas
    private val data: Array<DoubleArray>   // matriz

    // crea matriz con ceros
    constructor(M: Int, N: Int) {
        this.M = M
        this.N = N
        data = Array(M) { DoubleArray(N) }
    }

    // crea una matriz a traves de un array bidimensional
    constructor(data: Array<DoubleArray>) {
        M = data.size
        N = data[0].size
        this.data = Array(M) { DoubleArray(N) }
        for (i in 0 until M)
            for (j in 0 until N)
                this.data[i][j] = data[i][j]
    }

    // constructor copia
    private constructor(A: Matrix) : this(A.data) {}

    // intercambia las columnas
    private fun intercambio(i: Int, j: Int) {
        val temp = data[i]
        data[i] = data[j]
        data[j] = temp
    }

    // crea y devuelve la traspuesta de la matriz 
    fun traspuesta(): Matrix {
        val A = Matrix(N, M)
        for (i in 0 until M)
            for (j in 0 until N)
                A.data[j][i] = this.data[i][j]
        return A
    }

    // suma de matrices
    operator fun suma(B: Matrix): Matrix {
        val A = this
        if (B.M != A.M || B.N != A.N) throw RuntimeException("Dimensiones no validas para la matriz")
        val C = Matrix(M, N)
        for (i in 0 until M)
            for (j in 0 until N)
                C.data[i][j] = A.data[i][j] + B.data[i][j]
        return C
    }


    // resta de matrices
    operator fun restar(B: Matrix): Matrix {
        val A = this
        if (B.M != A.M || B.N != A.N) throw RuntimeException("Dimensiones no validas para la matriz")
        val C = Matrix(M, N)
        for (i in 0 until M)
            for (j in 0 until N)
                C.data[i][j] = A.data[i][j] - B.data[i][j]
        return C
    }

    // compara dos matrices 
    fun comparar(B: Matrix): Boolean {
        val A = this
        if (B.M != A.M || B.N != A.N) throw RuntimeException("Dimensiones no validas para la matriz")
        for (i in 0 until M)
            for (j in 0 until N)
                if (A.data[i][j] != B.data[i][j]) return false
        return true
    }

    // producto de dos matrices
    operator fun producto(B: Matrix): Matrix {
        val A = this
        if (A.N != B.M) throw RuntimeException("Dimensiones no validas para la matriz")
        val C = Matrix(A.M, B.N)
        for (i in 0 until C.M)
            for (j in 0 until C.N)
                for (k in 0 until A.N)
                    C.data[i][j] += A.data[i][k] * B.data[k][j]
        return C
    }


    // devuelve x = A^-1 b, asumiendo que A es cuadrada
    fun resolver(rhs: Matrix): Matrix {
        if (M != N || rhs.M != N || rhs.N != 1)
            throw RuntimeException("Dimensiones no validas para la matriz")


        // Eliminación gaussiana 
        for (i in 0 until N) {

            
            var max = i
            for (j in i + 1 until N)
                if (Math.abs(A.data[j][i]) > Math.abs(A.data[max][i]))
                    max = j
            A.swap(i, max)
            b.swap(i, max)

            
            if (A.data[i][i] == 0.0) throw RuntimeException("Dimensiones no validas para la matriz")

           
            for (j in i + 1 until N)
                b.data[j][0] -= b.data[i][0] * A.data[j][i] / A.data[i][i]

            
            for (j in i + 1 until N) {
                val m = A.data[j][i] / A.data[i][i]
                for (k in i + 1 until N) {
                    A.data[j][k] -= A.data[i][k] * m
                }
                A.data[j][i] = 0.0
            }
        }

        
        val x = Matrix(N, 1)
        for (j in N - 1 downTo 0) {
            var t = 0.0
            for (k in j + 1 until N)
                t += A.data[j][k] * x.data[k][0]
            x.data[j][0] = (b.data[j][0] - t) / A.data[j][j]
        }
        return x

    }

    companion object {

        // crea una matriz aleatoria
        fun aleatorio(M: Int, N: Int): Matrix {
            val A = Matrix(M, N)
            for (i in 0 until M)
                for (j in 0 until N)
                    A.data[i][j] = Math.random()
            return A
        }

    }

}
