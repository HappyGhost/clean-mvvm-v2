package com.myapp.api.core.mapper

abstract class BaseInfoMapper<T, R> {
    abstract fun transform(input: R): T
}
