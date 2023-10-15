package com.amk.superfollower.di

import com.amk.superfollower.model.net.createApiService
import com.amk.superfollower.model.repository.servicesList.AllItemsListRepository
import com.amk.superfollower.model.repository.servicesList.AllItemsListRepositoryImpl
import com.amk.superfollower.ui.features.mainScreen.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModules = module {

    single { createApiService() }

    single<AllItemsListRepository> { AllItemsListRepositoryImpl(get()) }

    viewModel { MainScreenViewModel(allServicesList = get()) }
}