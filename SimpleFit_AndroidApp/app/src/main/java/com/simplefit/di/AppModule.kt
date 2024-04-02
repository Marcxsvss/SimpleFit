package com.simplefit.di

import android.content.Context
import com.pmdm.recetas.data.room.SimpleFitDB
import com.simplefit.data.room.usuario.UsuarioDao
//import com.simplefit.data.services.usuario.UsuarioService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

//    @Provides
//    @Singleton
//    fun provideOkHttpClient() : OkHttpClient {
//        val loggingInterceptor = HttpLoggingInterceptor()
//        loggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS
//
//        val timeout = 10L
//        return OkHttpClient.Builder()
//            .addInterceptor(loggingInterceptor)
//            .connectTimeout(timeout, TimeUnit.SECONDS)
//            .readTimeout(timeout, TimeUnit.SECONDS)
//            .writeTimeout(timeout, TimeUnit.SECONDS)
//            .build()
//    }
//    @Provides
//    @Singleton
//    fun provideRetrofit(
//        okHttpClient: OkHttpClient
//    ) : Retrofit = Retrofit.Builder()
//        .client(okHttpClient)
//        .baseUrl("http://10.0.2.2/simplefit/") //Todavia no creado y añadido a tomcat y phpmyadmin
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//@Provides
//@Singleton
//fun provideUsuarioService(
//    retrofit: Retrofit
//) : UsuarioService = retrofit.create(UsuarioService::class.java)
    @Provides
    @Singleton
    fun provideUserDatabase(
        @ApplicationContext context: Context
    ) : SimpleFitDB = SimpleFitDB.getDatabase(context)

    @Provides
    @Singleton
    fun provideUsersDao(
        // La Bd es inyectada por provideAgendaDatabase() y
        // resuelto automáticamente por Hilt
        db: SimpleFitDB
    ) : UsuarioDao = db.usuarioDao()
}