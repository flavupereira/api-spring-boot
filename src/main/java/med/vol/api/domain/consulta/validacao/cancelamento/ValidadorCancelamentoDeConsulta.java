package med.vol.api.domain.consulta.validacao.cancelamento;


import med.vol.api.domain.ValidacaoException;
import med.vol.api.domain.consulta.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {

    void validar(DadosCancelamentoConsulta dados) throws ValidacaoException;

}
