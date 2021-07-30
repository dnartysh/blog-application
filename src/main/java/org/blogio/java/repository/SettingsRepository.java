package org.blogio.java.repository;

import org.blogio.java.model.GlobalSetting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingsRepository extends CrudRepository<GlobalSetting, Integer> {

}
