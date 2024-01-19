package br.com.erp.app.users.application.ports.out.groupFileProperties;

import br.com.erp.app.users.adapters.outbound.fileproperties.GroupFileProperties;

import java.util.List;

public interface GroupFilePropertiesAdapterPort {
    List<GroupFileProperties> findAll();
}
