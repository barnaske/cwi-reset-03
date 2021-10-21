package br.com.cwi.reset.augustobarnaske.classes;

import br.com.cwi.reset.augustobarnaske.enums.StatusCarreira;
import br.com.cwi.reset.augustobarnaske.exceptions.atores.ListaAtoresEmAtividadeSemCorrespondenciaException;
import br.com.cwi.reset.augustobarnaske.exceptions.atores.ListaAtoresEmAtividadeVaziaException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/atores")
public class AtorController {
    private AtorService atorService;

    public AtorController() {
        this.atorService = new AtorService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAtor(@RequestBody AtorRequest atorRequest) throws Exception {
        String nome = atorRequest.getNome();
        LocalDate dataNascimento = LocalDate.of(1996,10,2);
        StatusCarreira statusCarreira = atorRequest.getStatusCarreiraCrude();
        Integer anoInicioAtividade = atorRequest.getAnoInicioAtividade();

        atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);
        atorService.criarAtor(atorRequest);
    }

    @GetMapping("/atores/em_atividade/{filtroNome}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Ator> listarAtoresEmAtividade(@PathVariable String filtroNome) throws ListaAtoresEmAtividadeVaziaException, ListaAtoresEmAtividadeSemCorrespondenciaException {
        return atorService.listarAtoresEmAtividade(filtroNome);
    }

    @GetMapping("/{id}")
    public List<Ator> consultarAtor(@PathVariable Integer id) throws Exception{
        return atorService.consultarAtor(id);
    }

    @RequestMapping(value={},method = RequestMethod.GET)
    public List<Ator> consultaAtores() throws Exception {
        return atorService.consultarAtores();
    }

}
