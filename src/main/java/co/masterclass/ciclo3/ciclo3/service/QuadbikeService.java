package co.masterclass.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;
import co.masterclass.ciclo3.ciclo3.model.Quadbike;
import co.masterclass.ciclo3.ciclo3.repository.QuadbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuadbikeService {

    @Autowired
    private QuadbikeRepository quadbikeRepository;

    public List<Quadbike> getAll(){
        return quadbikeRepository.getAll();
    }

    public Optional<Quadbike> getQuadbike(Integer id){
        return quadbikeRepository.getQuadbike(id);
    }

    public Quadbike save(Quadbike q){
        if(q.getId()==null){
            return quadbikeRepository.save(q);
        }else{
            Optional<Quadbike> qaux = quadbikeRepository.getQuadbike(q.getId());
            if(qaux.isEmpty()){
                return quadbikeRepository.save(q);
            }else{
                return q;
            }
        }
    }
}
