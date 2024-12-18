package com.example.ecom.model

import com.example.ecom.model.cart.CartRepository
import com.example.ecom.model.product.FireStoreRepository
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Provides
    @Singleton
    fun provideFirebaseFirestore() : FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun provideFireStoreRepository() : FireStoreRepository {
        return FireStoreRepository()
    }

    @Provides
    @Singleton
    fun provideCartRepository(firestore : FirebaseFirestore) : CartRepository {
        return CartRepository(fireStore = firestore)
    }
}