package xyz.rociofuentes.adoptameapi.albergue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbergueServiceImpl implements AlbergueService {
    private final AlbergueRepository albergueRepository;

    @Autowired
    public AlbergueServiceImpl(AlbergueRepository albergueRepository){
        this.albergueRepository = albergueRepository;
    }

    @Override
    public List<Albergue> listarAlbergues(){
        return albergueRepository.findAll();
    }
}
