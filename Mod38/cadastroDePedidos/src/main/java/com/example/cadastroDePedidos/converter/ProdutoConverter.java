package com.example.cadastroDePedidos.converter;

import com.example.cadastroDePedidos.entity.Produto;
import com.example.cadastroDePedidos.repository.ProdutoRepository;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

@FacesConverter(value = "produtoConverter", managed = true)
public class ProdutoConverter implements Converter<Produto> {

    @Override
    public Produto getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) return null;

        ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(context);
        ProdutoRepository repository = ctx.getBean(ProdutoRepository.class);

        return repository.findById(Long.valueOf(value)).orElse(null);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Produto produto) {
        if (produto == null || produto.getId() == null) return "";
        return produto.getId().toString();
    }
}