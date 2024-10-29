package br.com.iago.restap.converter;

import br.com.iago.restap.domain.Departamento;
import br.com.iago.restap.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class StringToDepartamentConverter implements Converter<String, Departamento> {
    @Autowired
    private DepartamentoService departamentoService;

    @Override
    public Departamento convert(String source) {
        if (source.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(source);
        return departamentoService.findById(id);
    }
}
