package com.simplefit.di

import android.content.Context
import com.pmdm.recetas.data.room.SimpleFitDB
import com.simplefit.data.room.consejos.ConsejosDao
import com.simplefit.data.room.maquinas.MaquinasDao
import com.simplefit.data.room.rutinaMaquina.RutinaMaquinaDao
import com.simplefit.data.room.rutinas.RutinasDao
import com.simplefit.data.room.usuario.UsuarioDao
import com.simplefit.data.room.usuarioRutina.UsuarioRutinaDao
import com.simplefit.data.services.usuario.UsuarioService
//import com.simplefit.data.services.usuario.UsuarioService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
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
        .baseUrl("http://10.0.2.2/simplefit/") //Todavia no creado y añadido a tomcat y phpmyadmin
        .addConverterFactory(GsonConverterFactory.create())
        .build()
@Provides
@Singleton
fun provideUsuarioService(
    retrofit: Retrofit
) : UsuarioService = retrofit.create(UsuarioService::class.java)
    @Provides
    @Singleton
    fun provideUserDatabase(
        @ApplicationContext context: Context
    ) : SimpleFitDB = SimpleFitDB.getDatabase(context)

    @Provides
    @Singleton
    fun provideUsersDao(
        db: SimpleFitDB
    ) : UsuarioDao = db.usuarioDao()
    @Provides
    @Singleton
    fun provideRoutinesDao(
        db: SimpleFitDB
    ) : RutinasDao = db.rutinasDao()
    @Provides
    @Singleton
    fun provideMaquinasDao(
        db: SimpleFitDB
    ) : MaquinasDao = db.maquinasDao()
    @Provides
    @Singleton
    fun provideRutinaMaquinaDao(
        db: SimpleFitDB
    ) : RutinaMaquinaDao = db.rutinaMaquinaDao()
    @Provides
    @Singleton
    fun provideUsuarioRutinaDao(
        db: SimpleFitDB
    ) : UsuarioRutinaDao = db.usuarioRutinaDao()
    @Provides
    @Singleton
    fun provideConsejos(
        db: SimpleFitDB
    ) : ConsejosDao = db.consejosDao()
}