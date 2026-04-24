package com.example.cadastroDePedidos.converter;

import com.example.cadastroDePedidos.entity.Cliente;
import com.example.cadastroDePedidos.repository.ClienteRepository;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

@FacesConverter(value = "clienteConverter", managed = true)
public class ClienteConverter implements Converter<Cliente> {

    @Override
    public Cliente getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) return null;

        ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(context);
        ClienteRepository repository = ctx.getBean(ClienteRepository.class);

        return repository.findById(Long.valueOf(value)).orElse(null);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Cliente cliente) {
        if (cliente == null || cliente.getId() == null) return "";
        return cliente.getId().toString();
    }
}