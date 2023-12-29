package com.riadul.advancedandroid.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.riadul.advancedandroid.R
import com.riadul.advancedandroid.databinding.ActivityRetrofitMainBinding
import retrofit2.Response

class RetrofitMainActivity : AppCompatActivity() {

    lateinit var binding: ActivityRetrofitMainBinding
    private lateinit var retService: AlbumService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit_main)
        retService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)


//        getRequestWithQueryParameters()
//        getRequestWithPathParameters()
        uploadAlbum()
    }

    private fun getRequestWithQueryParameters() {
        val responseLiveData: LiveData<Response<Albums>> = liveData {
//            val response = retService.getSortedAlbums(3)
            val response = retService.getAlbums()
            emit(response)
        }

        responseLiveData.observe(this) {
            val albumsList = it.body()?.listIterator()
            if (albumsList != null) {
                while (albumsList.hasNext()) {
                    val albumsItem = albumsList.next()
                    val result = " " + "Album Title : ${albumsItem.title}" + "\n" +
                            " " + "Album Id : ${albumsItem.id}" + "\n" +
                            " " + "User Id : ${albumsItem.userId}" + "\n\n\n"

                    binding.textView.append(result)


                    Log.i("Album Title", albumsItem.title)
                }
            }
        }
    }

    private fun getRequestWithPathParameters() {
        val pathResponse: LiveData<Response<AlbumsItem>> = liveData {
            val response = retService.getAlbum(3)
            emit(response)
        }

        pathResponse.observe(this) {
            val title = it.body()?.title
            Toast.makeText(applicationContext, title, Toast.LENGTH_SHORT).show()
        }
    }

    private fun uploadAlbum() {
        val album = AlbumsItem(0, "My Album", 3)

        val postResponse: LiveData<Response<AlbumsItem>> = liveData {
            val response = retService.uploadAlbum(album)
            emit(response)
        }

        postResponse.observe(this) {
            val receivedAlbumsItem = it.body()
            val result = " " + "Album Title : ${receivedAlbumsItem?.title}" + "\n" +
                    " " + "Album Id : ${receivedAlbumsItem?.id}" + "\n" +
                    " " + "User Id : ${receivedAlbumsItem?.userId}" + "\n\n\n"

            binding.textView.text = result
        }
    }
}