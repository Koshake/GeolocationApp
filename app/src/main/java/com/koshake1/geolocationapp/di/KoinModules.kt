package com.koshake1.geolocationapp.di

import com.koshake1.geolocationapp.data.MarkerRepository
import com.koshake1.geolocationapp.data.MarkerRepositoryImpl
import com.koshake1.geolocationapp.viewmodel.MarkersViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val application = module {

    single {
        MarkerRepositoryImpl()
    } bind MarkerRepository::class

    viewModel { MarkersViewModel(get()) }
}