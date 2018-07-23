package teste.keven.com.food.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MainService {

    private val url = "http://192.168.10.7:3003/api/"

    private val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun <T> createService(servico: Class<T>): T {
        return retrofit.create(servico)
    }
}
