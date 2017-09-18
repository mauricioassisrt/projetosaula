/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpr.trabalho;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Seduc
 */
public class FuncionarioTest {
    
    public FuncionarioTest() {
    }
    
  
    @Test
    public void salario() {
        Funcionario f = new Funcionario();
        assertEquals(new BigDecimal("2"), f.salarioBase);
        
        Folha folha = new Folha();
        folha.salario(f);
       
    }
    
}
