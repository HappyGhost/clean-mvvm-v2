package com.myapp.api.feature.bank.mapper

import com.myapp.api.core.mapper.BaseInfoMapper
import okhttp3.ResponseBody
import retrofit2.Response


class SubmitLoanResponseMapper : BaseInfoMapper<String, Response<ResponseBody>>() {
    override fun transform(value: Response<ResponseBody>): String {
        return value.message()
    }

}