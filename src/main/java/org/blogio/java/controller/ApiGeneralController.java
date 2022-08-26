package org.blogio.java.controller;

import org.blogio.java.api.response.InitResponse;
import org.blogio.java.api.response.SettingsResponse;
import org.blogio.java.service.SettingsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiGeneralController {
    private final InitResponse initResponse;
    private final SettingsService settingsService;

    public ApiGeneralController(InitResponse initResponse, SettingsService settingsService) {
        this.initResponse = initResponse;
        this.settingsService = settingsService;
    }

    @GetMapping("/init")
    public InitResponse init() {
        return initResponse;
    }

    @GetMapping("/settings")
    public SettingsResponse settings() {
        return settingsService.getSettings();
    }
}
