package br.com.somar.app.application.ports.out.profiles;

import br.com.somar.app.application.domain.Profile;

import java.util.List;

public interface FindProfileAdapterPort {
     Profile findProfileBydId(Long id);
}
