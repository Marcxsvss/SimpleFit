package com.simplefit.di

import android.content.Context

import com.simplefit.data.services.consejo.ConsejosService
import com.simplefit.data.services.maquina.MaquinaService
import com.simplefit.data.services.rutina.RutinasService
import com.simplefit.data.services.rutinamaquina.RutinaMaquinaService
import com.simplefit.data.services.usuario.UsuarioService
import com.simplefit.data.services.usuariorutina.UsuarioRutinaService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient() : OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS

        val timeout = 10L
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)
            .writeTimeout(timeout, TimeUnit.SECONDS)
            .build()
    }
    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ) : Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("http://marcosvm.eastus.cloudapp.azure.com:8080/simplefit/datos/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    @Provides
    @Singleton
    fun provideUsuarioService(
        retrofit: Retrofit
    ) : UsuarioService = retrofit.create(UsuarioService::class.java)
    @Provides
    @Singleton
    fun provideConsejoService(
        retrofit: Retrofit
    ) : ConsejosService = retrofit.create(ConsejosService::class.java)
    @Provides
    @Singleton
    fun provideMaquinaService(
        retrofit: Retrofit
    ) : MaquinaService = retrofit.create(MaquinaService::class.java)
    @Provides
    @Singleton
    fun provideRutinaService(
        retrofit: Retrofit
    ) : RutinasService = retrofit.create(RutinasService::class.java)
    @Provides
    @Singleton
    fun provideRutinaMaquinaService(
        retrofit: Retrofit
    ) : RutinaMaquinaService = retrofit.create(RutinaMaquinaService::class.java)
    @Provides
    @Singleton
    fun provideUsuarioRutinaService(
        retrofit: Retrofit
    ) : UsuarioRutinaService = retrofit.create(UsuarioRutinaService::class.java)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}