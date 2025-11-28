package med.vol.api.domain.consulta.validacao.agendamento;

import med.vol.api.domain.ValidacaoException;
import med.vol.api.domain.consulta.DadosAgendamentoConsulta;


public interface ValidadorAgendamentoDeConsulta {

    void validar(DadosAgendamentoConsulta dados) throws ValidacaoException;

}