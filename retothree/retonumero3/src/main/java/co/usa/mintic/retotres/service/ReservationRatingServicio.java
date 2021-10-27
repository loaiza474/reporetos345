package co.usa.mintic.retotres.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.mintic.retotres.model.ReservationRating;
import co.usa.mintic.retotres.repository.ReservationRatingRepositorio;

@Service
public class ReservationRatingServicio {
    @Autowired
    private ReservationRatingRepositorio reservationRatingRepositorio;

    public List<ReservationRating> getAll(){
        return reservationRatingRepositorio.getAll();
    }

    public Optional<ReservationRating> getMensaje(int id){
        return reservationRatingRepositorio.getMensaje(id);
    }
    
    
    public ReservationRating save(ReservationRating calificacionReserva){
        if(calificacionReserva.getId()==null){
            return reservationRatingRepositorio.save(calificacionReserva);
        }else{
            Optional<ReservationRating> consulta=reservationRatingRepositorio.getMensaje(calificacionReserva.getId());
            if(consulta.isEmpty()){
                return reservationRatingRepositorio.save(calificacionReserva);
            }else{
                return calificacionReserva;
            }
        }
    }

    public boolean deleteReservationRating(int numId){

        Optional<ReservationRating> consulta=reservationRatingRepositorio.getMensaje(numId);

        if(!consulta.isEmpty()){

            reservationRatingRepositorio.delete(consulta.get());
            
            return true;
        }
        return false;
    }
}
