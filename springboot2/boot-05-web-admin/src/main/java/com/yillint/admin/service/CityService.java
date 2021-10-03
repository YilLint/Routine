package com.yillint.admin.service;

import com.yillint.admin.bean.City;

public interface CityService {

    public City getCityById(Long id);

    public void saveCity(City city);
}
