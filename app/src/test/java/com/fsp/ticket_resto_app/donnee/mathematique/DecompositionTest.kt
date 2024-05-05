package com.fsp.ticket_resto_app.donnee.mathematique

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestClassOrder

class DecompositionTest {

    @Test
    fun `creation d'une instance de Decomposition`() {
        //Given une instance de Decomposition
        val decomposition = Decomposition()

        //Then l'instance n'est pas nulle et on retrouve les valeurs par défaut
        assertNotNull(decomposition)
        assertEquals(8.0, decomposition.premiereValeur)
        assertEquals(13.0, decomposition.deuxiemeValeur)
        assertEquals(0.0, decomposition.montant)
    }

    @Test
    fun `decomposition de 0`() {
        //Given une instance de Decomposition
        val decomposition = Decomposition(montant = 0.0)

        //When, on décompose le montant
        val nbPremiereValeur = decomposition.decomposeNbPremierValeur()
        val nbDeuxiemeValeur = decomposition.decomposeNbDeuxiemeValeur()
        val reste = decomposition.decomposeReste()

        //Then le nombre de première valeur est 0
        assertEquals(0, nbPremiereValeur)
        //Then le nombre de deuxième valeur est 0
        assertEquals(0, nbDeuxiemeValeur)
        //Then le reste est 0
        assertEquals(0.0, reste)
    }

    @Test
    fun `decomposition de 8`() {
        //Given une instance de Decomposition
        val decomposition = Decomposition(montant = 8.0)

        //When on décompose le montant
        val nbPremiereValeur = decomposition.decomposeNbPremierValeur()
        val nbDeuxiemeValeur = decomposition.decomposeNbDeuxiemeValeur()
        val reste = decomposition.decomposeReste()

        //Then le nombre de première valeur est 1
        assertEquals(8.0, decomposition.premiereValeur)
        assertEquals(1, nbPremiereValeur)
        //Then le nombre de deuxième valeur est 0
        assertEquals(0, nbDeuxiemeValeur)
        //Then le reste est 0
        assertEquals(0.0, reste)
    }

    @Test
    fun `decomposition de 13`() {
        //Given une instance de Decomposition
        val decomposition = Decomposition(montant = 13.0)

        //When on décompose le montant
        val nbPremiereValeur = decomposition.decomposeNbPremierValeur()
        val nbDeuxiemeValeur = decomposition.decomposeNbDeuxiemeValeur()
        val reste = decomposition.decomposeReste()

        //Then le nombre de première valeur est 0
        assertEquals(1, nbPremiereValeur)
        //Then le nombre de deuxième valeur est 1
        assertEquals(13.0, decomposition.deuxiemeValeur)
        assertEquals(0, nbDeuxiemeValeur)
        //Then le reste est 0
        assertEquals(5.0, reste)
    }

    @Test
    fun `decomposition de 123`() {
        //Given une instance de Decomposition
        val decomposition = Decomposition(montant = 123.0)

        //When on décompose le montant
        val nbPremiereValeur = decomposition.decomposeNbPremierValeur()
        val nbDeuxiemeValeur = decomposition.decomposeNbDeuxiemeValeur()
        val reste = decomposition.decomposeReste()

        //Then le nombre de première valeur est 7
        assertEquals(7, nbPremiereValeur)
        //Then le nombre de deuxième valeur est 5
        assertEquals(5, nbDeuxiemeValeur)
        //Then le reste est 2
        assertEquals(2.0, reste)

        assertEquals(
            123.0,
            decomposition.premiereValeur * nbPremiereValeur + decomposition.deuxiemeValeur * nbDeuxiemeValeur + reste
        )
    }

    @Test
    fun `decomposition de 123 deux fois`() {
        //Given une instance de Decomposition
        val decomposition = Decomposition(montant = 123.0)

        //When on décompose le montant
        var nbPremiereValeur = decomposition.decomposeNbPremierValeur()
        var nbDeuxiemeValeur = decomposition.decomposeNbDeuxiemeValeur()
        var reste = decomposition.decomposeReste()

        //Then le nombre de première valeur est 7
        assertEquals(7, nbPremiereValeur)
        //Then le nombre de deuxième valeur est 5
        assertEquals(5, nbDeuxiemeValeur)
        //Then le reste est 2
        assertEquals(2.0, reste)

        assertEquals(
            123.0,
            decomposition.premiereValeur * nbPremiereValeur + decomposition.deuxiemeValeur * nbDeuxiemeValeur + reste
        )

        //When on décompose le montant
        nbPremiereValeur = decomposition.decomposeNbPremierValeur()
        nbDeuxiemeValeur = decomposition.decomposeNbDeuxiemeValeur()
        reste = decomposition.decomposeReste()

        //Then le nombre de première valeur est 7
        assertEquals(7, nbPremiereValeur)
        //Then le nombre de deuxième valeur est 5
        assertEquals(5, nbDeuxiemeValeur)
        //Then le reste est 2
        assertEquals(2.0, reste)

        assertEquals(
            123.0,
            decomposition.premiereValeur * nbPremiereValeur + decomposition.deuxiemeValeur * nbDeuxiemeValeur + reste
        )
    }
}