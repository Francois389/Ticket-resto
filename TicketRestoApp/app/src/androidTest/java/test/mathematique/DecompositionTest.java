/*
 * DecompositionTest.java                                    20 août 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */

package test.mathematique;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.fsp.ticket_resto_app.modele.mathematique.Decomposition;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

/** TODO comment class responsibility (SRP)
 * @author François de Saint Palais
 *
 */
@RunWith(AndroidJUnit4.class)
class DecompositionTest {
    
    private ArrayList<Decomposition> jeuxTest = new ArrayList<>();
    
    @Before
    void genererJeuxTest () {
        jeuxTest.add(new Decomposition(8,13,22));
        jeuxTest.add(new Decomposition(1,1,1));
    }

    /**
     * Méthode de test pour {@link Decomposition#Decomposition(int, int, int)}.
     */
    @Test
    void testDecompositionIntIntInt() {
        try {
            new Decomposition(8, 13, 22);
            new Decomposition(1, 1, 1);
            new Decomposition(0,13,22);
            new Decomposition(8,0,22);
            new Decomposition(8,13,0);
        } catch (IllegalArgumentException iE) {
            fail("Erreur soulevé : IllegalArgumentException " + iE.getMessage());
        }
        catch (Exception e) {
            fail("Erreur " + e.getMessage());
        }
    }

    /**
     * Méthode de test pour {@link Decomposition#Decomposition()}.
     */
    @Test
    void testDecomposition() {
        try {
            new Decomposition();
        } catch (Exception e) {
            fail("Erreur " + e.getMessage());
        }
    }

    /**
     * Méthode de test pour {@link Decomposition#getPremiereValeur()}.
     */
    @Test
    void testGetPremiereValeur() {
        assertEquals(8, jeuxTest.get(0).getPremiereValeur());
        assertEquals(1, jeuxTest.get(1).getPremiereValeur());
    }

    /**
     * Méthode de test pour {@link Decomposition#getDeuxiemeValeur()}.
     */
    @Test
    void testGetDeuxiemeValeur() {
        assertEquals(13, jeuxTest.get(0).getDeuxiemeValeur());
        assertEquals(1, jeuxTest.get(1).getDeuxiemeValeur());
    }
    
    /**
     * Méthode de test pour {@link Decomposition#getMontant()}.
     */
    @Test
    void testGetMontant() {
        assertEquals(22, jeuxTest.get(0).getMontant());
        assertEquals(1, jeuxTest.get(1).getMontant());
    }

    /**
     * Méthode de test pour {@link Decomposition#setPremiereValeur(int)}.
     */
    @Test
    void testSetPremiereValeur() {
        try {
            jeuxTest.get(0).setPremiereValeur(6);
        } catch (Exception e) {
            fail("Erreur une exception est levé " + e.getMessage());
        }
        assertEquals(6,jeuxTest.get(0).getPremiereValeur());
        assertThrows(IllegalArgumentException.class,
                     () -> jeuxTest.get(0).setPremiereValeur(0));
        assertThrows(IllegalArgumentException.class,
                     () -> jeuxTest.get(0).setPremiereValeur(-1));
    }


    /**
     * Méthode de test pour {@link Decomposition#setDeuxiemeValeur(int)}.
     */
    @Test
    void testSetDeuxiemeValeur() {
        try {
            jeuxTest.get(0).setDeuxiemeValeur(6);
        } catch (Exception e) {
            fail("Erreur " + e.getMessage());
        }

        assertEquals(6,jeuxTest.get(0).getDeuxiemeValeur());
        assertThrows(IllegalArgumentException.class,
                     () -> jeuxTest.get(0).setDeuxiemeValeur(0));
        assertThrows(IllegalArgumentException.class,
                     () -> jeuxTest.get(0).setDeuxiemeValeur(-1));
    }


    /**
     * Méthode de test pour {@link Decomposition#setMontant(int)}.
     */
    @Test
    void testSetMontant() {
        try {
            jeuxTest.get(0).setMontant(6);
        } catch (Exception e) {
            fail("Erreur " + e.getMessage());
        }
        
        assertEquals(6,jeuxTest.get(0).getMontant());
        assertThrows(IllegalArgumentException.class,
                     () -> jeuxTest.get(0).setMontant(0));
        assertThrows(IllegalArgumentException.class,
                     () -> jeuxTest.get(0).setMontant(-1));
    }

}
