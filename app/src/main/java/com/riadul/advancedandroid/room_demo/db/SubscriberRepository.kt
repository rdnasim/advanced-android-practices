package com.riadul.advancedandroid.room_demo.db

class SubscriberRepository(private val dao: SubscriberDAO) {

    val subscribers = dao.getAllSubscribers()
    suspend fun insert(subscriber: Subscriber): Long = dao.insertSubscriber(subscriber)

    suspend fun update(subscriber: Subscriber): Int = dao.updateSubscriber(subscriber)

    suspend fun delete(subscriber: Subscriber): Int = dao.deleteSubscriber(subscriber)

    suspend fun deleteAll(): Int = dao.deleteAllSubscribers()

    suspend fun getSubscribers() = dao.getAllSubscribers()


}