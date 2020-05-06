package com.thanyla.cepservice;

import javax.enterprise.context.Dependent;

@Dependent
public class PostmonCepService extends AbstractCepService {

    public PostmonCepService() {
        super("https://api.postmon.com.br");
    }

    @Override
    protected String buildPath(String cep) {
        return String.format("/v1/cep/%s", cep);
    }
    
}
