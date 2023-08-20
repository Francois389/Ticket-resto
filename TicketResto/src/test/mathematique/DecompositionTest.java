/*
 * DecompositionTest.java                                    20 août 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */

package test.mathematique;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mathematique.Decomposition;

/** TODO comment class responsibility (SRP)
 * @author FranÃ§ois
 *
 */
class DecompositionTest {
    
    private ArrayList<Decomposition> jeuxTest = new ArrayList<>();
    
    @BeforeEach
    void genererJeuxTest () {
        jeuxTest.add(new Decomposition(8,13,22));
        jeuxTest.add(new Decomposition(1,1,1));
    }

    /**
     * Méthode de test pour {@link mathematique.Decomposition#Decomposition(int, int, int)}.
     */
    @Test
    void testDecompositionIntIntInt() {
        assertDoesNotThrow(() -> new Decomposition(8,13,22));
        assertDoesNotThrow(() -> new Decomposition(1,1,1));
        
        assertThrows(IllegalArgumentException.class, ()->new Decomposition(0,13,22));
        assertThrows(IllegalArgumentException.class, ()->new Decomposition(8,0,22));
        assertThrows(IllegalArgumentException.class, ()->new Decomposition(8,13,0));
    }

    /**
     * Méthode de test pour {@link mathematique.Decomposition#Decomposition()}.
     */
    @Test
    void testDecomposition() {
        assertDoesNotThrow(() -> new Decomposition());
    }

    /**
     * Méthode de test pour {@link mathematique.Decomposition#getPremiereValeur()}.
     */
    @Test
    void testGetPremiereValeur() {
        assertEquals(8, jeuxTest.get(0).getPremiereValeur());
        assertEquals(1, jeuxTest.get(1).getPremiereValeur());
    }

    /**
     * Méthode de test pour {@link mathematique.Decomposition#getDeuxiemeValeur()}.
     */
    @Test
    void testGetDeuxiemeValeur() {
        assertEquals(13, jeuxTest.get(0).getDeuxiemeValeur());
        assertEquals(1, jeuxTest.get(1).getDeuxiemeValeur());
    }
    
    /**
     * Méthode de test pour {@link mathematique.Decomposition#getMontant()}.
     */
    @Test
    void testGetMontant() {
        assertEquals(22, jeuxTest.get(0).getMontant());
        assertEquals(1, jeuxTest.get(1).getMontant());
    }

    /**
     * Méthode de test pour {@link mathematique.Decomposition#setPremiereValeur(int)}.
     */
    @Test
    void testSetPremiereValeur() {
        assertDoesNotThrow(() ->jeuxTest.get(0).setPremiereValeur(6));
        assertEquals(6,jeuxTest.get(0).getPremiereValeur());
        assertThrows(IllegalArgumentException.class,
                     () -> jeuxTest.get(0).setPremiereValeur(0));
        assertThrows(IllegalArgumentException.class,
                     () -> jeuxTest.get(0).setPremiereValeur(-1));
    }


    /**
     * Méthode de test pour {@link mathematique.Decomposition#setDeuxiemeValeur(int)}.
     */
    @Test
    void testSetDeuxiemeValeur() {
        assertDoesNotThrow(() ->jeuxTest.get(0).setDeuxiemeValeur(6));
        assertEquals(6,jeuxTest.get(0).getDeuxiemeValeur());
        assertThrows(IllegalArgumentException.class,
                     () -> jeuxTest.get(0).setDeuxiemeValeur(0));
        assertThrows(IllegalArgumentException.class,
                     () -> jeuxTest.get(0).setDeuxiemeValeur(-1));
    }


    /**
     * Méthode de test pour {@link mathematique.Decomposition#setMontant(int)}.
     */
    @Test
    void testSetMontant() {
        assertDoesNotThrow(() ->jeuxTest.get(0).setMontant(6));
        assertEquals(6,jeuxTest.get(0).getMontant());
        assertThrows(IllegalArgumentException.class,
                     () -> jeuxTest.get(0).setMontant(0));
        assertThrows(IllegalArgumentException.class,
                     () -> jeuxTest.get(0).setMontant(-1));
    }

}
