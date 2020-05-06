package com.thanyla.cepservice;


public class ViaCepService extends AbstractCepService {

    public ViaCepService(String dominio) {
        super(dominio);
    }

    @Override
    protected String buildPath(String cep) {
        return String.format("ws/%s/json", cep);
    }
    
}
