package br.com.ebac.memelandia.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class ClienteServicoUsuarios {

    private static final Logger log = LoggerFactory.getLogger(ClienteServicoUsuarios.class);

    private final RestTemplate restTemplate;
    private final String usuariosUrl;

    public ClienteServicoUsuarios(@Value("${servicos.usuarios.url}") String usuariosUrl) {
        this.restTemplate = new RestTemplate();
        this.usuariosUrl = usuariosUrl;
    }

    public boolean usuarioExiste(Long usuarioId) {
        String url = usuariosUrl + "/usuarios/" + usuarioId;
        log.debug("Validando usuário no servico-usuarios: url={}", url);
        try {
            restTemplate.getForObject(url, Object.class);
            log.debug("Usuário id={} confirmado no servico-usuarios", usuarioId);
            return true;
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                log.warn("Usuário id={} não encontrado no servico-usuarios", usuarioId);
                return false;
            }
            log.error("Erro ao consultar servico-usuarios para usuário id={}: {}", usuarioId, e.getMessage());
            throw new RuntimeException("Falha ao consultar servico-usuarios: " + e.getMessage(), e);
        }
    }
}
