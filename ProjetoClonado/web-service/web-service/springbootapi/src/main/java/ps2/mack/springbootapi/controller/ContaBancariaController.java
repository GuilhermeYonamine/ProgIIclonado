package ps2.mack.springbootapi.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ps2.mack.springbootapi.conta.ContaBancaria;
import ps2.mack.springbootapi.conta.ContaBancariaRepository;
import ps2.mack.springbootapi.conta.ContaBancariaRequestDTO;
import ps2.mack.springbootapi.conta.ContaBancariaResponseDTO;


@RestController
@RequestMapping("/contas")
public class ContaBancariaController {
    @Autowired
    private ContaBancariaRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveContaBancaria(@RequestBody ContaBancariaRequestDTO data) {
        ContaBancaria contaData = new ContaBancaria(data);
        repository.save(contaData);
        return;
    }

    @GetMapping
    public List<ContaBancariaResponseDTO> getAll() {
        List<ContaBancariaResponseDTO> conta = repository.findAll().stream()
                .map(ContaBancariaResponseDTO::new).toList();
        return conta;
    }
}
