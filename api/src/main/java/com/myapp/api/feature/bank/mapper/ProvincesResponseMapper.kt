package com.myapp.api.feature.bank.mapper

import com.myapp.api.core.mapper.BaseInfoMapper
import com.myapp.api.feature.bank.model.ProvincesResponse
import com.myapp.business.feature.bank.info.ProvinceInfo


class ProvincesResponseMapper : BaseInfoMapper<List<ProvinceInfo>, ProvincesResponse>() {
    override fun transform(value: ProvincesResponse): List<ProvinceInfo> {
        var result = arrayListOf<ProvinceInfo>()
        for (province in value.provinces) {
            result.add(ProvinceInfo(province))
        }
        return result
    }

}