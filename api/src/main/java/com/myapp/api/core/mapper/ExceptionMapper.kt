package com.myapp.api.core.mapper

import com.myapp.business.core.exception.BaseApiException
import retrofit2.HttpException

class ExceptionMapper : BaseInfoMapper<BaseApiException, HttpException>() {

    override fun transform(httpException: HttpException): BaseApiException {
        val baseException = BaseApiException()
        val response = httpException.response()
        response?.run {
            baseException.httpCode = code()
            baseException.headers = headers()
        }
        baseException.exceptionType = BaseApiException.ExceptionType.HTTP_ERROR
        //handle common error json from server
        return baseException
    }
}
