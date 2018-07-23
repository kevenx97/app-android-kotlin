package teste.keven.com.food.service

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import teste.keven.com.food.models.Comida

class ListagemApiComidas(val comidas: List<Comida>)

interface DeliciousRequest {
    @GET("comidas")
    fun buscar(): Call<ListagemApiComidas>
}

object DeliciousService {

    private val service = MainService.createService(DeliciousRequest::class.java)

    fun buscar(callback: (ListagemApiComidas?) -> Unit) {
        service.buscar().enqueue(object : Callback<ListagemApiComidas> {
            override fun onFailure(call: Call<ListagemApiComidas>?, t: Throwable?) {
                callback(null)
            }

            override fun onResponse(call: Call<ListagemApiComidas>?, response: Response<ListagemApiComidas>?) {
                response?.run {
                    when (code()) {
                        in 200..300 -> callback(body())
                        else -> callback(null)
                    }
                }
            }
        })
    }
}