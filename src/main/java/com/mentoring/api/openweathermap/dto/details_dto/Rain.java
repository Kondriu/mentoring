package com.mentoring.api.openweathermap.dto.details_dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain {

    @JsonProperty("3h")
    private int _3h;

    public int get_3h() {
        return _3h;
    }

    public void set_3h(int _3h) {
        this._3h = _3h;
    }
}
