package med.vol.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.vol.api.domain.medico.Especialidade;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
        public DadosDetalhamentoConsulta(Consulta consulta) {
                this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
        }
}




//public record DadosDetalhamentoConsulta(
//
//        Long idMedico,
//
//        @NotNull
//        Long idPaciente,
//
//        @NotNull
//        @Future
//        LocalDateTime data,
//
//        Especialidade especialidade) {
//
//        public DadosDetalhamentoConsulta(Consulta consulta) {
//                this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
//        }
//}

