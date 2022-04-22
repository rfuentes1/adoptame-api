package xyz.rociofuentes.adoptameapi.albergue;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/albergues")
public class AlbergueController {

    private final AlbergueService albergueService;

    @Autowired
    public AlbergueController(AlbergueService albergueService) {
        this.albergueService = albergueService;
    }

    @GetMapping
    public List<Albergue> listarAlbergues() {return albergueService.listarAlbergues();}

}
