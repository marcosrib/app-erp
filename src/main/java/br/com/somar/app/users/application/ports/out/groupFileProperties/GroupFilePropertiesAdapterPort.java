package br.com.somar.app.users.application.ports.out.groupFileProperties;

import br.com.somar.app.users.adapters.outbound.fileproperties.GroupFileProperties;

import java.util.List;

public interface GroupFilePropertiesAdapterPort {
    List<GroupFileProperties> findAll();
}
