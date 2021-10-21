package br.com.cwi.reset.augustobarnaske.classes;

import br.com.cwi.reset.augustobarnaske.enums.StatusCarreira;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {
    private DiretorService diretorService;

    public DiretorController() {
        this.diretorService = new DiretorService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAtor(@RequestBody DiretorRequest diretorRequest) throws Exception {
        String nome = diretorRequest.getNome();
        LocalDate dataNascimento = LocalDate.of(1996,10,2);
        Integer anoInicioAtividade = diretorRequest.getAnoInicioAtividade();

        diretorRequest = new DiretorRequest(nome, dataNascimento, anoInicioAtividade);
        diretorService.criarAtor(diretorRequest);
    }

    @GetMapping("/diretores/em_atividade/{filtroNome}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Diretor> listarAtoresEmAtividade(@PathVariable String filtroNome) throws Exception {
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
