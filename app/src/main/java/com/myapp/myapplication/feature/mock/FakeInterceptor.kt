package com.myapp.myapplication.feature.mock

import android.content.Context
import com.myapp.myapplication.core.util.Utils
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody


class FakeInterceptor(var context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        var url = chain.request().url.toUrl().path
        url = url.replace("/", "_") + ".json"
        val jsonString = Utils.loadJSONFromAsset(url, context)
        if (!jsonString.isNullOrEmpty()) {
            return Response.Builder().apply {
                code(200).message(jsonString).protocol(Protocol.HTTP_1_0)
                request(chain.request())
                body(ResponseBody.create("application/json".toMediaTypeOrNull(), jsonString))
                addHeader("content-type", "application/json")
            }.build()
        }

        return Response.Builder().apply {
            code(501).message("not found").protocol(Protocol.HTTP_1_0)
            addHeader("content-type", "application/json")
        }.build()
    }

}