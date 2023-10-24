package br.com.somar.app.users.adapters.outbound.fileproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix ="permissions")
@PropertySource("classpath:abilities.properties")
public class GetAbilitiesIntoYMLFile {

    private List<Group> groups = new ArrayList<>();
    public List<Group> getGroups() {
        return groups;
    }
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

}



