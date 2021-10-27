package co.usa.mintic.retotres.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.mintic.retotres.model.bike;
import co.usa.mintic.retotres.repository.bikeRepositorio;


@Service
public class bikeServicio {

    @Autowired
    private bikeRepositorio bikeRepositorio;
    public List<bike>getAll(){
        return bikeRepositorio.getAll();
    }

    public Optional<bike>getBike(int id){
        return bikeRepositorio.getBike(id);
    }

    public bike save(bike audi){
        if(audi.getId()==null){
            return bikeRepositorio.save(audi);
        }else{Optional<bike> consulta=bikeRepositorio.getBike(audi.getId());
            if(consulta.isEmpty()){
                return bikeRepositorio.save(audi);
            }else{
                return audi;
            }
        
        }
    }

    public boolean deleteBike(int numId){

        Optional<bike> consulta=bikeRepositorio.getBike(numId);

        if(!consulta.isEmpty()){

            bikeRepositorio.delete(consulta.get());

            return true;

        }
        return false;
    }
    
    // public Empleado update(Empleado empleado){
    //     if(empleado.getNumId()!=null){
    //         Optional<Empleado> consulta=empleadorepositorio.getEmpleado(empleado.getNumId());
    //         if(!consulta.isEmpty()){
    //             if(empleado.getNombre()!=null){
    //                 consulta.get().setNombre(empleado.getNombre());
    //             }
    //         if(empleado.getEdad()!=null){
    //             consulta.get().setEdad(empleado.getEdad());
    //             }
    //         if(empleado.getCiudad()!=null){
    //             consulta.get().setCiudad(empleado.getCiudad());
    //             }
    //         if(empleado.getSalario()!=null){
    //             consulta.get().setSalario(empleado.getSalario());
    //         }
    //         return empleadorepositorio.save(consulta.get());
    //         }
    //     }
    //     return empleado;
    // }
}
