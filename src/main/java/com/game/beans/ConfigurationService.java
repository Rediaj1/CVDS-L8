package com.game.beans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService {
    private final ConfigurationRepository configurationRepository;
    @Autowired
    public ConfigurationService(ConfigurationRepository configurationRepository){
        this.configurationRepository = configurationRepository;
    }
    public ConfigurationBean addConfiguration(ConfigurationBean configutationB){
        return configurationRepository.save(configutationB);
    }
    public ConfigurationBean getConfiguration (String propiedadId){
        return configurationRepository.findById(propiedadId);
    }
    public List<ConfigurationBean> getAllConfiguration(){
        return configurationRepository.findAll();
    }
    public ConfigurationBean updateConfiguration(ConfigurationBean configutationB){
        if(configurationRepository.existsById(configutationB.getId())){
            return configurationRepository.save(configutationB);
        }
        return null;
    }

    public void deleteConfiguration(Long configurationId){
        configurationRepository.deleteById(configurationId);
    }

}