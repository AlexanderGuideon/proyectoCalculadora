package com.example.proyectocalculadora

class Matriz {
    private val M: Int             // numero de filas
    private val N: Int             // numero de columnas
    private val data: Array<IntArray>   // matriz

    // constructor
    constructor(M: Int, N: Int) {
        this.M = M
        this.N = N
        data = Array(M) { IntArray(N) }
    }

    // crea una matriz a traves de un array bidimensional
    constructor(data: Array<IntArray>) {
        M = data.size
        N = data[0].size
        this.data = Array(M) { IntArray(N) }
        for (i in 0 until M)
            for (j in 0 until N)
                this.data[i][j] = data[i][j]
    }



    // crea y devuelve la traspuesta de la matriz
    fun traspuesta(): Matriz {
        val A = Matriz(N, M)
        for (i in 0 until M)
            for (j in 0 until N)
                A.data[j][i] = this.data[i][j]
        return A
    }

    // suma de matrices
    fun suma(B: Matriz): Matriz {
        val A = this
        if (B.M != A.M || B.N != A.N) throw RuntimeException("Dimensiones no validas para la matriz")
        val C = Matriz(M, N)
        for (i in 0 until M)
            for (j in 0 until N)
                C.data[i][j] = A.data[i][j] + B.data[i][j]
        return C
    }


    // resta de matrices
     fun restar(B: Matriz): Matriz {
        val A = this
        if (B.M != A.M || B.N != A.N) throw RuntimeException("Dimensiones no validas para la matriz")
        val C = Matriz(M, N)
        for (i in 0 until M)
            for (j in 0 until N)
                C.data[i][j] = A.data[i][j] - B.data[i][j]
        return C
    }

    // compara dos matrices
    fun comparar(B: Matriz): Boolean {
        val A = this
        if (B.M != A.M || B.N != A.N) throw RuntimeException("Dimensiones no validas para la matriz")
        for (i in 0 until M)
            for (j in 0 until N)
                if (A.data[i][j] != B.data[i][j]) return false
        return true
    }

    // producto de dos matrices
    fun producto(B: Matriz): Matriz {
        val A = this
        if (A.N != B.M) throw RuntimeException("Dimensiones no validas para la matriz")
        val C = Matriz(A.M, B.N)
        for (i in 0 until C.M)
            for (j in 0 until C.N)
                for (k in 0 until A.N)
                    C.data[i][j] += A.data[i][k] * B.data[k][j]
        return C
    }


}
