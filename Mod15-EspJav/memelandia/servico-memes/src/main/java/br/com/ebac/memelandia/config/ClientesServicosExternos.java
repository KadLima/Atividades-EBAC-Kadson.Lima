package br.com.ebac.memelandia.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class ClientesServicosExternos {

    private static final Logger log = LoggerFactory.getLogger(ClientesServicosExternos.class);

    private final RestTemplate restTemplate = new RestTemplate();
    private final String usuariosUrl;
    private final String categoriasUrl;

    public ClientesServicosExternos(
            @Value("${servicos.usuarios.url}") String usuariosUrl,
            @Value("${servicos.categorias.url}") String categoriasUrl) {
        this.usuariosUrl = usuariosUrl;
        this.categoriasUrl = categoriasUrl;
    }

    public boolean usuarioExiste(Long usuarioId) {
        return verificaExistencia(usuariosUrl + "/usuarios/" + usuarioId, "usuário", usuarioId);
    }

    public boolean categoriaExiste(Long categoriaId) {
        return verificaExistencia(categoriasUrl + "/categorias/" + categoriaId, "categoria", categoriaId);
    }

    private boolean verificaExistencia(String url, String tipo, Long id) {
        log.debug("Verificando existência de {} id={} em {}", tipo, id, url);
        try {
            restTemplate.getForObject(url, Object.class);
            log.debug("{} id={} confirmado", tipo, id);
            return true;
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                log.warn("{} id={} não encontrado", tipo, id);
                return false;
            }
            log.error("Erro ao verificar {} id={}: {}", tipo, id, e.getMessage());
            throw new RuntimeException("Falha ao consultar serviço externo (" + tipo + "): " + e.getMessage(), e);
        }
    }
}
