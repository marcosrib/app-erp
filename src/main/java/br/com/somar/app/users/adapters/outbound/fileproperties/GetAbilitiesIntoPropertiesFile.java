package br.com.somar.app.users.adapters.outbound.fileproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix ="permissions")
@PropertySource("classpath:abilities.properties")
public class GetAbilitiesIntoPropertiesFile {

    private List<GroupFileProperties> abilityGroups = new ArrayList<>();

    public List<GroupFileProperties> getAbilityGroups() {
        return abilityGroups;
    }

    public void setAbilityGroups(List<GroupFileProperties> abilityGroups) {
        this.abilityGroups = abilityGroups;
    }
}



