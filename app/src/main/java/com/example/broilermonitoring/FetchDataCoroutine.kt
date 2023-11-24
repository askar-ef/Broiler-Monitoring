package com.example.broilermonitoring
import android.util.Log
import com.example.broilermonitoring.model.RekapDataResponse
import com.example.broilermonitoring.service.ApiService
import com.example.broilermonitoring.service.RekapDataHarian
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FetchDataCoroutine(private var token:String,private var path:Int) {
    private val coroutineScope= CoroutineScope(Dispatchers.Main)


    fun startFetching(){
        coroutineScope.launch{
            while (true){
                fetchData()
                delay(1000)
            }
        }
    }
    private suspend fun fetchData(){
        val api=ApiService().getInstance()
        val DataSensor=api.create(RekapDataHarian::class.java).getRekap(token,path)
        DataSensor.enqueue(object :Callback<RekapDataResponse>{
            override fun onResponse(
                call: Call<RekapDataResponse>,
                response: Response<RekapDataResponse>
            ) {
                if (response.isSuccessful){
                    val responseData=response.body()
                    val data=responseData?.data
                    amoniak=data?.amoniak!!
                    suhu=data?.suhu!!
                    Kelembaban =data?.kelembaban!!
                }
            }

            override fun onFailure(call: Call<RekapDataResponse>, t: Throwable) {
                Log.e("Failure",t.message.toString())
            }
        })
    }

    fun stop(){
        coroutineScope.cancel()
    }

        var Kelembaban=0
        var amoniak=0
        var suhu=0
    fun getSuhu():Int{
        return suhu
    }    fun getAmoniak():Int{
        return amoniak
    }    fun getKelembaban():Int{
        return Kelembaban
    }


}