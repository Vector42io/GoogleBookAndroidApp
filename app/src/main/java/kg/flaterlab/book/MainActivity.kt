package kg.flaterlab.book

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kg.flaterlab.book.models.SearchRequest
import kg.flaterlab.book.services.GoogleBookService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: MyAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    val apiServe by lazy {
        create()
    }
    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val myDataset = arrayListOf<String>()

        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(myDataset)

        recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
        serch_activate.setOnClickListener{
            val g = search_field.text.toString().replace(" ", "+")
            beginSearch(g)
        }

    }

    fun create(): GoogleBookService {

        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(
                RxJava2CallAdapterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create())
            .baseUrl("https://www.googleapis.com")
            .build()

        return retrofit.create(GoogleBookService::class.java)
    }

    private fun beginSearch(srsearch: String) {

        disposable =
            apiServe.search(srsearch)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result -> showResult(result) },
                    { error -> showError(error.message) }
                )
        }
    private fun showResult(res: SearchRequest){
        val n = arrayListOf<String>()

        res.items.forEach{
            n.add(it.volumeInfo.title)
        }

        viewAdapter.update(n)
    }

    private fun showError(er: String?){}
}
