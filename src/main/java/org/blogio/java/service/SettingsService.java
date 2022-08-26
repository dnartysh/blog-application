package org.blogio.java.service;

import lombok.Getter;
import lombok.Setter;
import org.blogio.java.api.response.SettingsResponse;
import org.blogio.java.repository.SettingsRepository;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class SettingsService {
    private final SettingsRepository settingsRepository;
    private final SettingsResponse settingsResponse;

    public SettingsService(SettingsRepository settingsRepository, SettingsResponse settingsResponse) {
        this.settingsRepository = settingsRepository;
        this.settingsResponse = settingsResponse;
    }

    public SettingsResponse getSettings() {
        SettingsResponse settingsResponse = new SettingsResponse();

        settingsRepository.findAll().forEach(s -> {
            if ("MULTIUSER_MODE".equals(s.getCode())) {
                settingsResponse.setMultiuserMode(s.getValue().equals("YES"));
            } else if ("POST_PREMODERATION".equals(s.getCode())) {
                settingsResponse.setPostPremoderation(s.getValue().equals("YES"));
            } else if ("STATISTICS_IS_PUBLIC".equals(s.getCode())) {
                settingsResponse.setStatisticsIsPublic(s.getValue().equals("YES"));
            }
        });

        return settingsResponse;
    }
}
