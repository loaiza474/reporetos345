package co.usa.mintic.retotres.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.mintic.retotres.model.client;
import co.usa.mintic.retotres.repository.clientRepositorio;

@Service
public class clientServicio {

    @Autowired
    private clientRepositorio clientRepositorio;

    public List<client> getAll(){
        return clientRepositorio.getAll();
    }

    public Optional<client>getCliente(int id){
        return clientRepositorio.getClient(id);
    }

    
    
    public client save(client clt){
        if(clt.getIdClient()==null){
            return clientRepositorio.save(clt);
        }else{
            Optional<client> consulta=clientRepositorio.getClient(clt.getIdClient());
            if(consulta.isEmpty()){
                return clientRepositorio.save(clt);
            }else{
                return clt;
            }
        }
    }

    public boolean deleteClient(int numId){

        Optional<client> consulta=clientRepositorio.getClient(numId);

        if(!consulta.isEmpty()){

            clientRepositorio.delete(consulta.get());
            
            return true;
        }
        return false;
    }

 




    
}
