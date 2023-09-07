package br.com.somar.app.users.application.ports.out.profiles;

import br.com.somar.app.users.application.core.domain.Profile;

public interface FindProfileAdapterPort {
     Profile findProfileBydId(Long id);
}
