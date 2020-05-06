package com.thanyla.cepservice;

import model.Endereco;

/**
 *
 * @author narizinho
 */
public interface CepService {
    Endereco buscaEndereco(String cep);
}
