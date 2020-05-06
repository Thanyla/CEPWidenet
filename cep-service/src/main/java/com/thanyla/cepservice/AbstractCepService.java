package com.thanyla.cepservice;

import java.util.logging.Logger;
import model.Endereco;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;


public abstract class AbstractCepService implements CepService {

    private static final Logger LOG = Logger.getLogger(AbstractCepService.class.getName());
    
    private final String dominio;
    private final WebTarget target;

    public AbstractCepService(String dominio) {
        this.dominio = insertTrailingSlash(dominio);
        Client client = ClientBuilder.newClient();
        this.target = client.target(dominio);
    }

    
    
    protected final String insertTrailingSlash(String path){
        return path.endsWith("/") ? path : path +"/";
    }

    protected abstract String buildPath(String cep);
    
    protected String getFullPath(String cep){
        return  this.dominio + buildPath(cep);
    }
    
    @Override
    public Endereco buscaEndereco(String cep) {
        LOG.info(
                String.format("Buscando endereço para o CEP %s usando serviço %s",
                        cep, dominio)
        );
        return target.path(buildPath(cep)).request().get(Endereco.class);
    }
    
}
