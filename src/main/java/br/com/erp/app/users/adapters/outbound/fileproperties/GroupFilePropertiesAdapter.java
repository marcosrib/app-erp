package br.com.erp.app.users.adapters.outbound.fileproperties;

import br.com.erp.app.users.application.ports.out.groupFileProperties.GroupFilePropertiesAdapterPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupFilePropertiesAdapter implements GroupFilePropertiesAdapterPort {
    @Override
    public List<GroupFileProperties> findAll() {
        return new GetAbilitiesIntoPropertiesFile().getAbilityGroups();
    }
}
