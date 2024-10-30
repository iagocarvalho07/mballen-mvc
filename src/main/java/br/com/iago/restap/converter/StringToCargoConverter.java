package br.com.iago.restap.converter;

import br.com.iago.restap.domain.Cargo;
import br.com.iago.restap.domain.Departamento;
import br.com.iago.restap.service.CargoService;
import br.com.iago.restap.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class StringToCargoConverter implements Converter<String, Cargo> {
    @Autowired
    private CargoService cargoService;

    @Override
    public Cargo convert(String source) {
        if (source.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(source);
        return cargoService.buscarPorId(id);
    }
}
